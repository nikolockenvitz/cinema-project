package com.fallstudie.kinobuchungssystem.data.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.kinobuchungssystem.common.transferobject.MovieTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.TicketTo;
import com.fallstudie.kinobuchungssystem.data.entity.Movie;
import com.fallstudie.kinobuchungssystem.data.entity.dao.MovieDao;
import com.fallstudie.kinobuchungssystem.data.helper.EntityToToHelper;
import com.fallstudie.kinobuchungssystem.data.helper.ToToEntityHelper;

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
        Long id = Long.parseLong(idString);
        Movie movie = new Movie();

        return EntityToToHelper.createMovieTo(movie);
    }

    public MovieTo save ( MovieTo movieTo )
    {
        return EntityToToHelper.createMovieTo(movieDao.persist(ToToEntityHelper.createMovieEntity(movieTo)));
    }

    public List<MovieTo> getAllMovies ( )
    {
        return EntityToToHelper.createMovieTos(movieDao.getAllMovies());
//        return movieDao.getAllMovies();
    }

    public List<TicketTo> getAllTickets ( )
    {
        return EntityToToHelper.createTicketTos(movieDao.getAllTickets(), true);
    }

    public List<TicketTo> getAllTicketsForShow ( String id )
    {
        Long showId = Long.parseLong(id);
        return EntityToToHelper.createTicketTos(movieDao.getAllTicketsForShow(showId), true);
    }

}
