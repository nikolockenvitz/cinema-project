package com.fallstudie.cinemasystem.data.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.common.transferobject.TicketTo;
import com.fallstudie.cinemasystem.data.entity.dao.ShowDao;
import com.fallstudie.cinemasystem.data.helper.EntityToToHelper;

public class ShowService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ShowService.class);
    private ShowDao             showDao;

    public ShowService( )
    {
        this.showDao = new ShowDao();
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
}
