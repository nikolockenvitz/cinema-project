package com.fallstudie.cinemasystem.data.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.common.transferobject.TicketTo;
import com.fallstudie.cinemasystem.data.entity.Ticket;
import com.fallstudie.cinemasystem.data.entity.dao.ShowDao;
import com.fallstudie.cinemasystem.data.entity.dao.TicketDao;
import com.fallstudie.cinemasystem.data.helper.EntityToToHelper;
import com.fallstudie.cinemasystem.data.helper.ToToEntityHelper;

public class ShowService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ShowService.class);
    private ShowDao             showDao;
    private TicketDao           ticketDao;

    public ShowService( )
    {
        this.showDao = new ShowDao();
        this.ticketDao = new TicketDao();
    }

    public ShowTo getShow ( String idString )
    {
        Long showId = Long.parseLong(idString);
        return EntityToToHelper.createShowToWithMovie(showDao.find(showId));
    }

    public List<TicketTo> getAllTicketsForShow ( String id )
    {
        Long showId = Long.parseLong(id);
        return EntityToToHelper.createTicketTos(showDao.getAllTicketsForShow(showId), true);
    }

    public List<TicketTo> bookShowTickets ( List<TicketTo> ticketTos )
    {
        List<Ticket> tickets = ToToEntityHelper.createTicketEntities(ticketTos);
        List<TicketTo> bookedShowTickets = new ArrayList<>();

        for ( Ticket t : tickets )
        {
            bookedShowTickets.add(EntityToToHelper.createTicketTo(ticketDao.persist(t), true));
        }
        return bookedShowTickets;
    }

}
