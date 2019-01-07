package com.fallstudie.kinobuchungssystem.data.entity.dao;

import java.util.List;

import javax.persistence.Query;

import com.fallstudie.kinobuchungssystem.data.entity.Movie;
import com.fallstudie.kinobuchungssystem.data.entity.Ticket;

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
}
