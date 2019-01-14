package com.fallstudie.cinemasystem.data.entity.dao;

import java.util.List;

import javax.persistence.Query;

import com.fallstudie.cinemasystem.data.entity.Movie;
import com.fallstudie.cinemasystem.data.entity.Ticket;
import com.fallstudie.cinemasystem.data.entity.query.MovieQuery;
import com.fallstudie.cinemasystem.data.entity.query.QueryParam;

public class MovieDao extends BaseDao<Movie>
{

    @Override
    public int count ( Movie crsRequest )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Movie find ( long id )
    {
        Movie movie = getEm().find(Movie.class, id);
        return movie;
    }

    @SuppressWarnings("unchecked")
    public List<Movie> getAllMovies ( )
    {
        List<Movie> resultList = null;
        Query query = getEm().createNamedQuery("Movie.findAll");
        resultList = query.getResultList();
        return resultList;
    }

    @SuppressWarnings("unchecked")
    public List<Ticket> getAllTickets ( )
    {
        List<Ticket> resultList = null;
        Query query = getEm().createNamedQuery("Ticket.findAll");
        resultList = query.getResultList();
        return resultList;
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
