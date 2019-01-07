package com.fallstudie.kinobuchungssystem.data.helper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.fallstudie.kinobuchungssystem.common.transferobject.ActorTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.CategoryTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.EmployeeTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.GenreTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.HallTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.MovieTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.RatingTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.ReservationTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.SeatTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.ShowTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.TicketTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.UserTo;
import com.fallstudie.kinobuchungssystem.data.entity.Actor;
import com.fallstudie.kinobuchungssystem.data.entity.Category;
import com.fallstudie.kinobuchungssystem.data.entity.Employee;
import com.fallstudie.kinobuchungssystem.data.entity.Genre;
import com.fallstudie.kinobuchungssystem.data.entity.Hall;
import com.fallstudie.kinobuchungssystem.data.entity.Movie;
import com.fallstudie.kinobuchungssystem.data.entity.Rating;
import com.fallstudie.kinobuchungssystem.data.entity.Reservation;
import com.fallstudie.kinobuchungssystem.data.entity.Seat;
import com.fallstudie.kinobuchungssystem.data.entity.Show;
import com.fallstudie.kinobuchungssystem.data.entity.Ticket;
import com.fallstudie.kinobuchungssystem.data.entity.User;

public class ToToEntityHelper
{

    private static ModelMapper modelMapper = new ModelMapper();

    public static Employee createEmployeeEntity ( EmployeeTo transferObject )
    {
        if ( null != transferObject )
        {
            Employee employee = modelMapper.map(transferObject, Employee.class);
            return employee;
        }
        return null;
    }

    public static Movie createMovieEntity ( MovieTo transferObject )
    {
        Movie movie = modelMapper.map(transferObject, Movie.class);
        return movie;
    }

    private static Rating createRatingEntity ( RatingTo transferObject )
    {
        Rating rating = modelMapper.map(transferObject, Rating.class);
        return rating;
    }

    private static Genre createGenreEntity ( GenreTo transferObject )
    {
        Genre genre = modelMapper.map(transferObject, Genre.class);
        return genre;
    }

    private static Actor createActorEntity ( ActorTo transferObject )
    {
        Actor actor = modelMapper.map(transferObject, Actor.class);
        return actor;
    }

    private static Show createShowEntity ( ShowTo transferObject )
    {
        Show show = modelMapper.map(transferObject, Show.class);
        return show;
    }

    private static Reservation createReservationEntity ( ReservationTo transferObject )
    {
        Reservation reservation = modelMapper.map(transferObject, Reservation.class);
        return reservation;
    }

    private static Ticket createTicketEntity ( TicketTo transferObject )
    {
        Ticket ticket = modelMapper.map(transferObject, Ticket.class);
        return ticket;
    }

    private static Seat createSeatEntity ( SeatTo transferObject )
    {
        Seat seat = modelMapper.map(transferObject, Seat.class);
        return seat;
    }

    private static Category createCategoryEntity ( CategoryTo transferObject )
    {
        Category category = modelMapper.map(transferObject, Category.class);
        return category;
    }

    private static Hall createHallEntity ( HallTo transferObject )
    {
        Hall hall = modelMapper.map(transferObject, Hall.class);
        return hall;
    }

    private static User createUserEntity ( UserTo transferObject )
    {
        User user = modelMapper.map(transferObject, User.class);
        return user;
    }

    // LIST

    public static List<Employee> createEmployeeEntities ( List<EmployeeTo> transferObject )
    {
        List<Employee> list = new ArrayList<>();
        for ( EmployeeTo element : transferObject )
        {
            list.add(createEmployeeEntity(element));
        }
        return list;
    }

    private static List<Actor> createActorEntities ( List<ActorTo> transferObject )
    {
        List<Actor> list = new ArrayList<>();
        for ( ActorTo element : transferObject )
        {
            list.add(createActorEntity(element));
        }
        return list;
    }

    private static List<Show> createShowEntities ( List<ShowTo> transferObject )
    {
        List<Show> list = new ArrayList<>();
        for ( ShowTo element : transferObject )
        {
            list.add(createShowEntity(element));
        }
        return list;
    }

    private static List<Reservation> createReservationEntities ( List<ReservationTo> transferObject )
    {
        List<Reservation> list = new ArrayList<>();
        for ( ReservationTo element : transferObject )
        {
            list.add(createReservationEntity(element));
        }
        return list;
    }

    private static List<Ticket> createTicketEntities ( List<TicketTo> transferObject )
    {
        List<Ticket> list = new ArrayList<>();
        for ( TicketTo element : transferObject )
        {
            list.add(createTicketEntity(element));
        }
        return list;
    }

    private static List<Seat> createSeatEntities ( List<SeatTo> transferObject )
    {
        List<Seat> list = new ArrayList<>();
        for ( SeatTo element : transferObject )
        {
            list.add(createSeatEntity(element));
        }
        return list;
    }

    private static List<User> createUserEntities ( List<UserTo> transferObject )
    {
        List<User> list = new ArrayList<>();
        for ( UserTo element : transferObject )
        {
            list.add(createUserEntity(element));
        }
        return list;
    }

    public static List<Movie> createMovieEntities ( List<MovieTo> transferObject )
    {
        List<Movie> list = new ArrayList<>();
        for ( MovieTo element : transferObject )
        {
            list.add(createMovieEntity(element));
        }
        return list;
    }

    private static List<Rating> createRatingEntities ( List<RatingTo> transferObject )
    {
        List<Rating> list = new ArrayList<>();
        for ( RatingTo element : transferObject )
        {
            list.add(createRatingEntity(element));
        }
        return list;
    }

}
