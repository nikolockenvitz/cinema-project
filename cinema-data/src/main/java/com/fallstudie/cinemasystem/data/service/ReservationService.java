package com.fallstudie.cinemasystem.data.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.transferobject.ReservationTo;
import com.fallstudie.cinemasystem.data.entity.Reservation;
import com.fallstudie.cinemasystem.data.entity.Ticket;
import com.fallstudie.cinemasystem.data.entity.dao.ReservationDao;
import com.fallstudie.cinemasystem.data.entity.dao.TicketDao;
import com.fallstudie.cinemasystem.data.helper.EntityToToHelper;
import com.fallstudie.cinemasystem.data.helper.ToToEntityHelper;

public class ReservationService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationService.class);
    private ReservationDao      reservationDao;
    private TicketDao           ticketDao;

    public ReservationService( )
    {
        this.reservationDao = new ReservationDao();
        this.ticketDao = new TicketDao();
    }

    public ReservationTo getReservation ( String idString )
    {
        Long reservationId = Long.parseLong(idString);
        return EntityToToHelper.createReservationTo(reservationDao.find(reservationId), true);
    }

    public ReservationTo createReservation ( ReservationTo reservationTo )
    {
        Reservation reservation = ToToEntityHelper.createReservationEntity(reservationTo);
        return EntityToToHelper.createReservationTo(reservationDao.persist(reservation), true);
    }

    public ReservationTo deleteReservation ( String id )
    {
        Reservation r = ToToEntityHelper.createReservationEntity(getReservation(id));
        return EntityToToHelper.createReservationTo(reservationDao.remove(r), true);
    }

    public void deleteTicket ( String id )
    {
        Ticket t = ticketDao.find(Long.parseLong(id));
        ticketDao.remove(t);
    }

}
