package com.fallstudie.cinemasystem.data.entity.dao;

import java.util.List;

import javax.persistence.Query;

import com.fallstudie.cinemasystem.data.entity.Ticket;
import com.fallstudie.cinemasystem.data.entity.query.MovieQuery;
import com.fallstudie.cinemasystem.data.entity.query.QueryParam;

public class TicketDao extends BaseDao<Ticket>
{

    @Override
    public int count ( Ticket crsRequest )
    {
        return 0;
    }

    @Override
    public Ticket find ( long id )
    {
        Ticket ticket = getEm().find(Ticket.class, id);
        return ticket;
    }

    @SuppressWarnings("unchecked")
    public List<Ticket> getAllTicketsForShow ( Long showId )
    {
        List<Ticket> resultList = null;
        Query query = getEm().createNamedQuery(MovieQuery.FIND_TICKETS_BY_SHOW_ID);
        query.setParameter(QueryParam.SHOW_ID, showId);
        resultList = query.getResultList();
        return resultList;
    }

}
