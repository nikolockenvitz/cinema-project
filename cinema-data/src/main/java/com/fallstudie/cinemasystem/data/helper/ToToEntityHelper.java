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
import com.fallstudie.cinemasystem.common.utils.Utils;
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
            movie.setId(transferObject.getId());
            movie.setActors(createActorEntities(transferObject.getActors()));
            movie.setDescription(transferObject.getDescription());
            movie.setFsk(transferObject.getFsk());
            movie.setDuration(transferObject.getDuration());
            movie.setName(transferObject.getName());
            movie.setRatings(createRatingEntities(transferObject.getRatings()));
            movie.setShows(createShowEntities(transferObject.getShows()));
            movie.setGenres(createGenreEntities(transferObject.getGenres()));
            return movie;
        }
        return null;
    }

    private static Rating createRatingEntity ( RatingTo transferObject )
    {
        if ( null != transferObject )
        {
            Rating rating = new Rating();
            rating.setId(transferObject.getId());
            rating.setComment(transferObject.getComment());
            rating.setUser(createUserEntity(transferObject.getCustomer()));
            rating.setRating(transferObject.getRating());
            return rating;
        }
        return null;
    }

    private static Genre createGenreEntity ( GenreTo transferObject )
    {
        if ( null != transferObject )
        {
            Genre genre = new Genre();
            genre.setId(transferObject.getId());
            genre.setGenre(transferObject.getGenre());
            return genre;
        }
        return null;
    }

    private static Actor createActorEntity ( ActorTo transferObject )
    {
        if ( null != transferObject )
        {
            Actor actor = new Actor();
            actor.setFirstname(transferObject.getFirstname());
            actor.setLastname(transferObject.getLastname());
            actor.setBirthdate(Utils.convertStringToDate(transferObject.getBirthdate()));
            return actor;
        }
        return null;
    }

    private static Show createShowEntity ( ShowTo transferObject )
    {
        if ( null != transferObject )
        {
            Show show = new Show();
            show.setId(transferObject.getId());
            show.setHall(createHallEntity(transferObject.getHall()));
            show.setIs3D(transferObject.is3D());
            show.setDate(Utils.convertStringToDate(transferObject.getDate()));
            show.setTime(transferObject.getTime());
            show.setIs3D(transferObject.is3D());
            return show;
        }
        return null;
    }

    private static Reservation createReservationEntity ( ReservationTo transferObject )
    {
        if ( null != transferObject )
        {
            Reservation reservation = new Reservation();
            reservation.setId(transferObject.getId());
            reservation.setDateOfReservation(transferObject.getDateOfReservation());
            reservation.setCustomer(createUserEntity(transferObject.getCustomer()));
            return reservation;
        }
        return null;
    }

    private static Ticket createTicketEntity ( TicketTo transferObject )
    {
        if ( null != transferObject )
        {
            Ticket ticket = new Ticket();
            ticket.setId(transferObject.getId());
            ticket.setSeat(createSeatEntity(transferObject.getSeat()));
            ticket.setShow(createShowEntity(transferObject.getShow()));
            ticket.setReservation(createReservationEntity(transferObject.getReservation()));
            return ticket;
        }
        return null;
    }

    private static Seat createSeatEntity ( SeatTo transferObject )
    {
        if ( null != transferObject )
        {
            Seat seat = new Seat();
            seat.setId(transferObject.getId());
            seat.setNumber(transferObject.getNumber());
            seat.setCategory(createCategoryEntity(transferObject.getCategory()));
            seat.setRow(transferObject.getRow());
            seat.setX(transferObject.getX());
            seat.setY(transferObject.getY());
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
        if ( null != transferObject )
        {
            for ( EmployeeTo element : transferObject )
            {
                list.add(createEmployeeEntity(element));
            }
        }
        return list;
    }

    private static List<Actor> createActorEntities ( List<ActorTo> transferObject )
    {
        List<Actor> list = new ArrayList<>();
        if ( null != transferObject )
        {
            for ( ActorTo element : transferObject )
            {
                list.add(createActorEntity(element));
            }
        }
        return list;
    }

    private static List<Show> createShowEntities ( List<ShowTo> transferObject )
    {
        List<Show> list = new ArrayList<>();
        if ( null != transferObject )
        {
            for ( ShowTo element : transferObject )
            {
                list.add(createShowEntity(element));
            }
        }
        return list;
    }

    private static List<Reservation> createReservationEntities ( List<ReservationTo> transferObject )
    {
        List<Reservation> list = new ArrayList<>();
        if ( null != transferObject )
        {
            for ( ReservationTo element : transferObject )
            {
                list.add(createReservationEntity(element));
            }
        }
        return list;
    }

    public static List<Ticket> createTicketEntities ( List<TicketTo> transferObject )
    {
        List<Ticket> list = new ArrayList<>();
        if ( null != transferObject )
        {
            for ( TicketTo element : transferObject )
            {
                list.add(createTicketEntity(element));
            }
        }
        return list;
    }

    private static List<Seat> createSeatEntities ( List<SeatTo> transferObject )
    {
        List<Seat> list = new ArrayList<>();
        if ( null != transferObject )
        {
            for ( SeatTo element : transferObject )
            {
                list.add(createSeatEntity(element));
            }
        }
        return list;
    }

    private static List<Customer> createUserEntities ( List<CustomerTo> transferObject )
    {
        List<Customer> list = new ArrayList<>();
        if ( null != transferObject )
        {
            for ( CustomerTo element : transferObject )
            {
                list.add(createUserEntity(element));
            }
        }
        return list;
    }

    public static List<Movie> createMovieEntities ( List<MovieTo> transferObject )
    {
        List<Movie> list = new ArrayList<>();
        if ( null != transferObject )
        {
            for ( MovieTo element : transferObject )
            {
                list.add(createMovieEntity(element));
            }
        }
        return list;
    }

    private static List<Rating> createRatingEntities ( List<RatingTo> transferObject )
    {
        List<Rating> list = new ArrayList<>();
        if ( null != transferObject )
        {
            for ( RatingTo element : transferObject )
            {
                list.add(createRatingEntity(element));
            }
        }
        return list;
    }

    private static List<Genre> createGenreEntities ( List<GenreTo> transferObject )
    {
        List<Genre> list = new ArrayList<>();
        if ( null != transferObject )
        {
            for ( GenreTo element : transferObject )
            {
                list.add(createGenreEntity((element)));
            }
        }
        return list;
    }

}
