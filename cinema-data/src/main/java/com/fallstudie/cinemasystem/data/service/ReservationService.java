package com.fallstudie.cinemasystem.data.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.transferobject.CustomerTo;
import com.fallstudie.cinemasystem.common.transferobject.ReservationTo;
import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.common.transferobject.TicketTo;
import com.fallstudie.cinemasystem.data.entity.Reservation;
import com.fallstudie.cinemasystem.data.entity.dao.ReservationDao;
import com.fallstudie.cinemasystem.data.entity.dao.TicketDao;
import com.fallstudie.cinemasystem.data.helper.EntityToToHelper;
import com.fallstudie.cinemasystem.data.helper.ToToEntityHelper;

public class ReservationService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationService.class);
    private ReservationDao      reservationDao;
    private TicketDao           ticketDao;
    private ShowService         showService;
    private CustomerService     customerService;

    public ReservationService( )
    {
        this.reservationDao = new ReservationDao();
        this.ticketDao = new TicketDao();
        this.showService = new ShowService();
        this.customerService = new CustomerService();
    }

    public ReservationTo getReservation ( String idString )
    {
        Long reservationId = Long.parseLong(idString);
        return EntityToToHelper.createReservationTo(reservationDao.find(reservationId), true);
    }

    public ReservationTo createReservation ( ReservationTo reservationTo )
    {
        CustomerTo customerTo = customerService.getCustomer(String.valueOf(reservationTo.getCustomer().getId()));
        ShowTo showTo = showService.getShow(String.valueOf(reservationTo.getTickets().get(0).getShow().getId()));

        reservationTo.setCustomer(customerTo);
        for ( TicketTo t : reservationTo.getTickets() )
        {
            t.setShow(showTo);
        }

        Reservation reservation = ToToEntityHelper.createReservationEntity(reservationTo);

        return EntityToToHelper.createReservationTo(reservationDao.persist(reservation), true);
    }

    public ReservationTo deleteReservation ( String id )
    {
        Reservation r = ToToEntityHelper.createReservationEntity(getReservation(id));
        return EntityToToHelper.createReservationTo(reservationDao.remove(r), true);
    }

}
