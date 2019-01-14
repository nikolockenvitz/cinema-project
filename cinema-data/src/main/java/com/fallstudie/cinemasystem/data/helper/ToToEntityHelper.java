package com.fallstudie.cinemasystem.data.helper;

import java.util.ArrayList;
import java.util.List;

import com.fallstudie.cinemasystem.common.transferobject.ActorTo;
import com.fallstudie.cinemasystem.common.transferobject.CategoryTo;
import com.fallstudie.cinemasystem.common.transferobject.CustomerTo;
import com.fallstudie.cinemasystem.common.transferobject.EmployeeTo;
import com.fallstudie.cinemasystem.common.transferobject.GenreTo;
import com.fallstudie.cinemasystem.common.transferobject.HallTo;
import com.fallstudie.cinemasystem.common.transferobject.MovieTo;
import com.fallstudie.cinemasystem.common.transferobject.RatingTo;
import com.fallstudie.cinemasystem.common.transferobject.ReservationTo;
import com.fallstudie.cinemasystem.common.transferobject.SeatTo;
import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.common.transferobject.TicketTo;
import com.fallstudie.cinemasystem.data.entity.Actor;
import com.fallstudie.cinemasystem.data.entity.Category;
import com.fallstudie.cinemasystem.data.entity.Customer;
import com.fallstudie.cinemasystem.data.entity.Employee;
import com.fallstudie.cinemasystem.data.entity.Genre;
import com.fallstudie.cinemasystem.data.entity.Hall;
import com.fallstudie.cinemasystem.data.entity.Movie;
import com.fallstudie.cinemasystem.data.entity.Rating;
import com.fallstudie.cinemasystem.data.entity.Reservation;
import com.fallstudie.cinemasystem.data.entity.Seat;
import com.fallstudie.cinemasystem.data.entity.Show;
import com.fallstudie.cinemasystem.data.entity.Ticket;

public class ToToEntityHelper
{

    public static Employee createEmployeeEntity ( EmployeeTo transferObject )
    {
        if ( null != transferObject )
        {
            Employee employee = new Employee();
            return employee;
        }
        return null;
    }

    public static Movie createMovieEntity ( MovieTo transferObject )
    {
        if ( null != transferObject )
        {
            Movie movie = new Movie();
            return movie;
        }
        return null;
    }

    private static Rating createRatingEntity ( RatingTo transferObject )
    {
        if ( null != transferObject )
        {
            Rating rating = new Rating();
            return rating;
        }
        return null;
    }

    private static Genre createGenreEntity ( GenreTo transferObject )
    {
        if ( null != transferObject )
        {
            Genre genre = new Genre();
            return genre;
        }
        return null;
    }

    private static Actor createActorEntity ( ActorTo transferObject )
    {
        if ( null != transferObject )
        {
            Actor actor = new Actor();
            return actor;
        }
        return null;
    }

    private static Show createShowEntity ( ShowTo transferObject )
    {
        if ( null != transferObject )
        {
            Show show = new Show();
            return show;
        }
        return null;
    }

    private static Reservation createReservationEntity ( ReservationTo transferObject )
    {
        if ( null != transferObject )
        {
            Reservation reservation = new Reservation();
            return reservation;
        }
        return null;
    }

    private static Ticket createTicketEntity ( TicketTo transferObject )
    {
        if ( null != transferObject )
        {
            Ticket ticket = new Ticket();
            return ticket;
        }
        return null;
    }

    private static Seat createSeatEntity ( SeatTo transferObject )
    {
        if ( null != transferObject )
        {
            Seat seat = new Seat();
            return seat;
        }
        return null;
    }

    private static Category createCategoryEntity ( CategoryTo transferObject )
    {
        if ( null != transferObject )
        {
            Category category = new Category();
            return category;
        }
        return null;
    }

    private static Hall createHallEntity ( HallTo transferObject )
    {
        if ( null != transferObject )
        {
            Hall hall = new Hall();
            return hall;
        }
        return null;
    }

    private static Customer createUserEntity ( CustomerTo transferObject )
    {
        if ( null != transferObject )
        {
            Customer user = new Customer();
            return user;
        }
        return null;
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

    private static List<Customer> createUserEntities ( List<CustomerTo> transferObject )
    {
        List<Customer> list = new ArrayList<>();
        for ( CustomerTo element : transferObject )
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