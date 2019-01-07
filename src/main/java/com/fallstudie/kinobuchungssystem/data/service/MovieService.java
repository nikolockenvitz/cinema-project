package com.fallstudie.kinobuchungssystem.data.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.kinobuchungssystem.common.transferobject.MovieTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.TicketTo;
import com.fallstudie.kinobuchungssystem.data.entity.Actor;
import com.fallstudie.kinobuchungssystem.data.entity.Genre;
import com.fallstudie.kinobuchungssystem.data.entity.Movie;
import com.fallstudie.kinobuchungssystem.data.entity.Rating;
import com.fallstudie.kinobuchungssystem.data.entity.Show;
import com.fallstudie.kinobuchungssystem.data.entity.User;
import com.fallstudie.kinobuchungssystem.data.entity.dao.MovieDao;
import com.fallstudie.kinobuchungssystem.data.helper.EntityToToHelper;
import com.fallstudie.kinobuchungssystem.data.helper.ToToEntityHelper;

public class MovieService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
    private MovieDao            movieDao;
    private ModelMapper         modelMapper;

    public MovieService( )
    {
        this.movieDao = new MovieDao();
        this.modelMapper = new ModelMapper();
    }

    public MovieTo getMovie ( String idString )
    {
        Long id = Long.parseLong(idString);
        Movie movie = new Movie();

        List<Actor> actors = new ArrayList<>();
        Actor actor = new Actor();
        actor.setFirstname("sadasd");
        actor.setLastname("asdsad");
        actors.add(actor);
        movie.setActors(actors);
        Genre genre = new Genre();
        genre.setId(1L);
        genre.setGenre("test");
        movie.setGenre(genre);

        List<Rating> ratings = new ArrayList<>();
        Rating rating = new Rating();
        rating.setId(1L);
//        rating.setMovie_id(movie.getId());
        rating.setComment("asdwewqewqeqwe");

        User user = new User();
        user.setId(1L);
        user.setName("sadsadweqwxcxyc");
//        rating.setUser_id(user.getId());
        movie.setRatings(ratings);

        List<Show> shows = new ArrayList<>();
        Show show = new Show();
        show.setId(1L);
        show.setMovie(movie);
        show.setReservations(new ArrayList<>());
        show.setTickets(new ArrayList<>());
        movie.setShows(shows);
        movie.setFsk(18);
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
        return EntityToToHelper.createTicketTos(movieDao.getAllTickets());
    }

}
