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

public class EntityToToHelper
{

    public static EmployeeTo createEmployeeTo ( Employee entity )
    {
        if ( null != entity )
        {
            EmployeeTo employeeTo = new EmployeeTo();
            employeeTo.setId(entity.getId());
            employeeTo.setAge(entity.getAge());
            employeeTo.setEmail(entity.getEmail());
            employeeTo.setLastname(entity.getLastname());
            employeeTo.setFirstname(entity.getFirstname());
            return employeeTo;
        } else
            return null;
    }

    public static MovieTo createMovieTo ( Movie entity )
    {
        if ( null != entity )
        {
            MovieTo movieTo = new MovieTo();
            movieTo.setId(entity.getId());
            movieTo.setDescription(entity.getDescription());
            movieTo.setFsk(entity.getFsk());
            movieTo.setDuration(entity.getDuration());
            movieTo.setName(entity.getName());
            movieTo.setGenres(createGenreTos(entity.getGenres()));
            movieTo.setRatings(createRatingTos(entity.getRatings()));
            movieTo.setShows(createShowTos(entity.getShows(), false));
            movieTo.setActors(createActorTos(entity.getActors()));
            return movieTo;
        } else
            return null;
    }

    private static RatingTo createRatingTo ( Rating entity )
    {
        if ( null != entity )
        {
            RatingTo ratingTo = new RatingTo();
            ratingTo.setId(entity.getId());
            ratingTo.setComment(entity.getComment());
            ratingTo.setRating(entity.getRating());
            ratingTo.setCustomer(createCustomerToForRating(entity.getUser()));
            return ratingTo;
        } else
            return null;
    }

    private static GenreTo createGenreTo ( Genre entity )
    {
        if ( null != entity )
        {
            GenreTo genreTo = new GenreTo();
            genreTo.setId(entity.getId());
            genreTo.setGenre(entity.getGenre());
            return genreTo;
        } else
            return null;
    }

    private static ActorTo createActorTo ( Actor entity )
    {
        if ( null != entity )
        {
            ActorTo actorTo = new ActorTo();
            actorTo.setId(entity.getId());
            actorTo.setFirstname(entity.getFirstname());
            actorTo.setLastname(entity.getLastname());
            actorTo.setBirthdate(entity.getBirthdate());
            return actorTo;
        } else
            return null;
    }

    private static ShowTo createShowTo ( Show entity, boolean withtickets )
    {
        if ( null != entity )
        {
            ShowTo showTo = new ShowTo();
            showTo.setId(entity.getId());
            showTo.setHall(createHallTo(entity.getHall()));
            showTo.setStarttime(entity.getStarttime());
            if ( withtickets )
            {
                showTo.setTickets(createTicketTos(entity.getTickets(), false));
            }
            return showTo;
        }
        return null;
    }

    private static ShowTo createShowToWithMovie ( Show entity )
    {
        if ( null != entity )
        {
            ShowTo showTo = new ShowTo();
            showTo.setId(entity.getId());
            showTo.setHall(createHallTo(entity.getHall()));
            showTo.setMovie(createMovieTo(entity.getMovie()));
            showTo.setStarttime(entity.getStarttime());
            return showTo;
        }
        return null;
    }

    private static ShowTo createShowToWithoutMovie ( Show entity )
    {
        if ( null != entity )
        {
            ShowTo showTo = new ShowTo();
            showTo.setId(entity.getId());
            showTo.setHall(createHallTo(entity.getHall()));
            showTo.setStarttime(entity.getStarttime());
            return showTo;
        }
        return null;
    }

    private static ReservationTo createReservationTo ( Reservation entity )
    {
        if ( null != entity )
        {
            ReservationTo reservationTo = new ReservationTo();
            reservationTo.setId(entity.getId());
            reservationTo.setDateOfReservation(entity.getDateOfReservation());
            reservationTo.setCustomer(createCustomerTo(entity.getCustomer()));
            return reservationTo;
        } else
            return null;
    }

    private static TicketTo createTicketTo ( Ticket entity, boolean withshow )
    {
        if ( null != entity )
        {
            TicketTo ticketTo = new TicketTo();
            ticketTo.setId(entity.getId());
            ticketTo.setReducedPrice(entity.isReducedPrice());
            ticketTo.setSeat(createSeatTo(entity.getSeat()));
            ticketTo.setReservation(createReservationTo(entity.getReservation()));
            if ( withshow )
            {
                ticketTo.setShow(createShowTo(entity.getShow(), false));
            }
            return ticketTo;
        } else
            return null;
    }

    private static SeatTo createSeatTo ( Seat entity )
    {
        if ( null != entity )
        {
            SeatTo seatTo = new SeatTo();
            seatTo.setId(entity.getId());
            seatTo.setNumber(entity.getNumber());
            seatTo.setRow(entity.getRow());
            seatTo.setCategory(createCategoryTo(entity.getCategory()));
            seatTo.setHall(createHallTo(entity.getHall()));
            seatTo.setX(entity.getX());
            seatTo.setY(entity.getY());
            return seatTo;
        } else
            return null;
    }

    private static CategoryTo createCategoryTo ( Category entity )
    {
        if ( null != entity )
        {
            CategoryTo categoryTo = new CategoryTo();
            categoryTo.setId(entity.getId());
            categoryTo.setCategory(entity.getCategory());
            return categoryTo;
        } else
            return null;
    }

    private static HallTo createHallTo ( Hall entity )
    {
        if ( null != entity )
        {
            HallTo hallTo = new HallTo();
            hallTo.setId(entity.getId());
            hallTo.setName(entity.getName());
            hallTo.setWidth(entity.getWidth());
            hallTo.setLength(entity.getLength());
            return hallTo;
        } else
            return null;
    }

    private static CustomerTo createCustomerTo ( Customer entity )
    {
        if ( null != entity )
        {
            CustomerTo customerTo = new CustomerTo();
            customerTo.setId(entity.getId());
            customerTo.setBirthday(entity.getDateofbirth());
            customerTo.setEmail(entity.getEmail());
            customerTo.setIsAdmin(entity.getIsadmin());
            customerTo.setFirstname(entity.getFirstname());
            customerTo.setLastname(entity.getLastname());
            customerTo.setPwhash(entity.getPwhash());
            customerTo.setSessiontoken(entity.getSessiontoken());
            customerTo.setUsername(entity.getUsername());
            return customerTo;
        } else
            return null;
    }

    private static CustomerTo createCustomerToForRating ( Customer entity )
    {
        if ( null != entity )
        {
            CustomerTo customerTo = new CustomerTo();
            customerTo.setId(entity.getId());
            customerTo.setFirstname(entity.getFirstname());
            customerTo.setLastname(entity.getLastname());
            customerTo.setUsername(entity.getUsername());
            return customerTo;
        } else
            return null;
    }

    // LIST

    public static List<EmployeeTo> createEmployeeTos ( List<Employee> entity )
    {
        List<EmployeeTo> list = new ArrayList<>();
        for ( Employee element : entity )
        {
            list.add(createEmployeeTo(element));
        }
        return list;
    }

    private static List<ActorTo> createActorTos ( List<Actor> entity )
    {
        List<ActorTo> list = new ArrayList<>();
        for ( Actor element : entity )
        {
            list.add(createActorTo(element));
        }
        return list;
    }

    private static List<ShowTo> createShowTos ( List<Show> entity, boolean withtickets )
    {
        List<ShowTo> list = new ArrayList<>();
        for ( Show element : entity )
        {
            list.add(createShowTo(element, withtickets));
        }
        return list;
    }

    private static List<ShowTo> createShowTosWithMovie ( List<Show> entity )
    {
        List<ShowTo> list = new ArrayList<>();
        for ( Show element : entity )
        {
            list.add(createShowToWithMovie(element));
        }
        return list;
    }

    private static List<ShowTo> createShowTosWithoutMovie ( List<Show> entity )
    {
        List<ShowTo> list = new ArrayList<>();
        for ( Show element : entity )
        {
            list.add(createShowToWithoutMovie(element));
        }
        return list;
    }

    private static List<ReservationTo> createReservationTos ( List<Reservation> entity )
    {
        List<ReservationTo> list = new ArrayList<>();
        for ( Reservation element : entity )
        {
            list.add(createReservationTo(element));
        }
        return list;
    }

    public static List<TicketTo> createTicketTos ( List<Ticket> entity, boolean withShow )
    {
        List<TicketTo> list = new ArrayList<>();
        for ( Ticket element : entity )
        {
            list.add(createTicketTo(element, withShow));
        }
        return list;
    }

    private static List<SeatTo> createSeatTos ( List<Seat> entity )
    {
        List<SeatTo> list = new ArrayList<>();
        for ( Seat element : entity )
        {
            list.add(createSeatTo(element));
        }
        return list;
    }

    private static List<CustomerTo> createUserTos ( List<Customer> entity )
    {
        List<CustomerTo> list = new ArrayList<>();
        for ( Customer element : entity )
        {
            list.add(createCustomerTo(element));
        }
        return list;
    }

    public static List<MovieTo> createMovieTos ( List<Movie> entity )
    {
        List<MovieTo> list = new ArrayList<>();
        for ( Movie element : entity )
        {
            list.add(createMovieTo(element));
        }
        return list;
    }

    private static List<RatingTo> createRatingTos ( List<Rating> entity )
    {
        List<RatingTo> list = new ArrayList<>();
        for ( Rating element : entity )
        {
            list.add(createRatingTo(element));
        }
        return list;
    }

    private static List<GenreTo> createGenreTos ( List<Genre> entity )
    {
        List<GenreTo> list = new ArrayList<>();
        for ( Genre element : entity )
        {
            list.add(createGenreTo(element));
        }
        return list;
    }
}
