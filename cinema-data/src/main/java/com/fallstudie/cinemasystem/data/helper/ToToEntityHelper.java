package com.fallstudie.cinemasystem.data.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fallstudie.cinemasystem.common.transferobject.ActorTo;
import com.fallstudie.cinemasystem.common.transferobject.BlockToWithSessiontoken;
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
import com.fallstudie.cinemasystem.data.entity.Block;
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
            employee.setId(transferObject.getId());
            employee.setDateofbirth(Utils.convertStringToDate(transferObject.getDateofbirth()));
            employee.setEmail(transferObject.getEmail());
            employee.setFirstname(transferObject.getFirstname());
            employee.setLastname(transferObject.getLastname());
            return employee;
        }
        return null;
    }

    public static Movie createMovieEntity ( MovieTo transferObject, boolean withShow )
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
            if ( withShow )
            {
                movie.setShows(createShowEntities(transferObject.getShows(), false));
            }
            movie.setGenres(createGenreEntities(transferObject.getGenres()));
            return movie;
        }
        return null;
    }

    public static Rating createRatingEntity ( RatingTo transferObject )
    {
        if ( null != transferObject )
        {
            Rating rating = new Rating();
            rating.setId(transferObject.getId());
            rating.setComment(transferObject.getComment());
            rating.setUser(createCustomerEntity(transferObject.getCustomer()));
            rating.setRating(transferObject.getRating());
            return rating;
        }
        return null;
    }

    public static Genre createGenreEntity ( GenreTo transferObject )
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

    public static Actor createActorEntity ( ActorTo transferObject )
    {
        if ( null != transferObject )
        {
            Actor actor = new Actor();
            actor.setId(transferObject.getId());
            actor.setFirstname(transferObject.getFirstname());
            actor.setLastname(transferObject.getLastname());
            actor.setBirthdate(Utils.convertStringToDate(transferObject.getBirthdate()));
            return actor;
        }
        return null;
    }

    public static Show createShowEntity ( ShowTo transferObject, boolean withMovie )
    {
        if ( null != transferObject )
        {
            Show show = new Show();
            show.setId(transferObject.getId());
            show.setHall(createHallEntity(transferObject.getHall()));
            show.setIs3D(transferObject.isShowIs3D());
            show.setDate(Utils.convertStringToDate(transferObject.getDate()));
            show.setTime(Utils.convertStringToTime(transferObject.getTime()));
            show.setIs3D(transferObject.isShowIs3D());
            if ( withMovie )
            {
                show.setMovie(createMovieEntity(transferObject.getMovie(), false));
            }
            return show;
        }
        return null;
    }

    public static Reservation createReservationEntity ( ReservationTo transferObject )
    {
        if ( null != transferObject )
        {
            Reservation reservation = new Reservation();
            reservation.setId(transferObject.getId());
            reservation.setDateOfReservation(Utils.convertStringToDate(transferObject.getDateOfReservation()));
            reservation.setCustomer(createCustomerEntity(transferObject.getCustomer()));
            reservation.setTickets(createTicketEntitiesForReservation(transferObject.getTickets(), reservation));
            return reservation;
        }
        return null;
    }

    public static Ticket createTicketEntityForReservation ( TicketTo transferObject, Reservation reservation )
    {
        if ( null != transferObject )
        {
            Ticket ticket = new Ticket();
            ticket.setId(transferObject.getId());
            ticket.setReducedPrice(transferObject.isReducedPrice());
            ticket.setSeat(createSeatEntity(transferObject.getSeat()));
            ticket.setShow(createShowEntity(transferObject.getShow(), true));
            ticket.setReservation(reservation);
            return ticket;
        } else
        {
            return null;

        }
    }

    public static Ticket createTicketEntity ( TicketTo transferObject )
    {
        if ( null != transferObject )
        {
            Ticket ticket = new Ticket();
            ticket.setId(transferObject.getId());
            ticket.setSeat(createSeatEntity(transferObject.getSeat()));
            ticket.setShow(createShowEntity(transferObject.getShow(), true));
            ticket.setReservation(createReservationEntity(transferObject.getReservation()));
            return ticket;
        }
        return null;
    }

    public static Seat createSeatEntity ( SeatTo transferObject )
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

    public static Category createCategoryEntity ( CategoryTo transferObject )
    {
        if ( null != transferObject )
        {
            Category category = new Category();
            category.setId(transferObject.getId());
            category.setCategory(transferObject.getCategory());
            return category;
        }
        return null;
    }

    public static Hall createHallEntity ( HallTo transferObject )
    {
        if ( null != transferObject )
        {
            Hall hall = new Hall();
            hall.setId(transferObject.getId());
            hall.setLength(transferObject.getLength());
            hall.setWidth(transferObject.getWidth());
            hall.setSeats(createSeatEntities(transferObject.getSeats()));
            hall.setName(transferObject.getName());
            return hall;
        }
        return null;
    }

    public static Customer createCustomerEntity ( CustomerTo transferObject )
    {
        if ( null != transferObject )
        {
            Customer customer = new Customer();
            customer.setDateofbirth(Utils.convertStringToDate(transferObject.getDateofbirth()));
            customer.setEmail(transferObject.getEmail());
            customer.setFirstname(transferObject.getFirstname());
            customer.setIsadmin(transferObject.getIsAdmin());
            customer.setLastname(transferObject.getLastname());
            customer.setPwhash(transferObject.getPwhash());
            customer.setSessiontoken(transferObject.getSessiontoken());
            customer.setId(transferObject.getId());
            customer.setUsername(transferObject.getUsername());
            return customer;
        }
        return null;
    }

    public static Block createBlockEntity ( BlockToWithSessiontoken transferObject )
    {
        if ( null != transferObject )
        {
            Block block = new Block();
            block.setId(transferObject.getId());
            block.setSessiontoken(transferObject.getSessiontoken());
            block.setSeat(createSeatEntity(transferObject.getSeat()));
            block.setTimeofreservation(new Date());
            block.setShow(createShowEntity(transferObject.getShow(), true));
            return block;
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

    public static List<Actor> createActorEntities ( List<ActorTo> transferObject )
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

    public static List<Show> createShowEntities ( List<ShowTo> transferObject, boolean withMovie )
    {
        List<Show> list = new ArrayList<>();
        if ( null != transferObject )
        {
            for ( ShowTo element : transferObject )
            {
                list.add(createShowEntity(element, withMovie));
            }
        }
        return list;
    }

    public static List<Reservation> createReservationEntities ( List<ReservationTo> transferObject )
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

    public static List<Seat> createSeatEntities ( List<SeatTo> transferObject )
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

    public static List<Customer> createCustomerEntities ( List<CustomerTo> transferObject )
    {
        List<Customer> list = new ArrayList<>();
        if ( null != transferObject )
        {
            for ( CustomerTo element : transferObject )
            {
                list.add(createCustomerEntity(element));
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
                list.add(createMovieEntity(element, true));
            }
        }
        return list;
    }

    public static List<Rating> createRatingEntities ( List<RatingTo> transferObject )
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

    public static List<Genre> createGenreEntities ( List<GenreTo> transferObject )
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

    public static List<Ticket> createTicketEntitiesForReservation ( List<TicketTo> tickets, Reservation reservation )
    {
        List<Ticket> list = new ArrayList<>();
        if ( null != tickets )
        {
            for ( TicketTo ticketTo : tickets )
            {
                list.add(createTicketEntityForReservation(ticketTo, reservation));
            }
        }
        return list;
    }

}
