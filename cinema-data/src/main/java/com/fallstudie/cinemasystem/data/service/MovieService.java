package com.fallstudie.cinemasystem.data.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.transferobject.MovieTo;
import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.common.transferobject.TicketTo;
import com.fallstudie.cinemasystem.data.entity.dao.MovieDao;
import com.fallstudie.cinemasystem.data.helper.EntityToToHelper;
import com.fallstudie.cinemasystem.data.helper.ToToEntityHelper;

public class MovieService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
    private MovieDao            movieDao;

    public MovieService( )
    {
        this.movieDao = new MovieDao();
    }

    public MovieTo getMovie ( String idString )
    {
        Long movieId = Long.parseLong(idString);
        return EntityToToHelper.createMovieTo(movieDao.find(movieId), true);
    }

    public MovieTo save ( MovieTo movieTo )
    {
        return EntityToToHelper.createMovieTo(movieDao.persist(ToToEntityHelper.createMovieEntity(movieTo, true)), true);
    }

    public List<MovieTo> getAllMovies ( )
    {
        return EntityToToHelper.createMovieTos(movieDao.getAllMovies());
    }

    public List<TicketTo> getAllTickets ( )
    {
        return EntityToToHelper.createTicketTos(movieDao.getAllTickets());
    }

    public List<TicketTo> getAllTicketsForShow ( String id )
    {
        Long showId = Long.parseLong(id);
        return EntityToToHelper.createTicketTos(movieDao.getAllTicketsForShow(showId));
    }

    public ShowTo getShow ( String id )
    {
        // TODO Auto-generated method stub
        return null;
    }

}
