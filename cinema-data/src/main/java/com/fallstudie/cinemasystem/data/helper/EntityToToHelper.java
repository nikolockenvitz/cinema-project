package com.fallstudie.cinemasystem.data.helper;

import java.util.ArrayList;
import java.util.List;

import com.fallstudie.cinemasystem.common.transferobject.ActorTo;
import com.fallstudie.cinemasystem.common.transferobject.BlockTo;
import com.fallstudie.cinemasystem.common.transferobject.CategoryTo;
import com.fallstudie.cinemasystem.common.transferobject.CustomerTo;
import com.fallstudie.cinemasystem.common.transferobject.EmployeeTo;
import com.fallstudie.cinemasystem.common.transferobject.GenreTo;
import com.fallstudie.cinemasystem.common.transferobject.HallTo;
import com.fallstudie.cinemasystem.common.transferobject.MovieTo;
import com.fallstudie.cinemasystem.common.transferobject.PriceTo;
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

public class EntityToToHelper
{

    public static EmployeeTo createEmployeeTo ( Employee entity )
    {
        if ( null != entity )
        {
            EmployeeTo employeeTo = new EmployeeTo();
            employeeTo.setId(entity.getId());
            employeeTo.setDateofbirth(Utils.convertDateToString(entity.getDateofbirth()));
            employeeTo.setEmail(entity.getEmail());
            employeeTo.setLastname(entity.getLastname());
            employeeTo.setFirstname(entity.getFirstname());
            return employeeTo;
        } else
            return null;
    }

    public static MovieTo createMovieTo ( Movie entity, boolean withShow )
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
            if ( withShow )
            {
                movieTo.setShows(createShowTos(entity.getShows(), false));
            }
            movieTo.setActors(createActorTos(entity.getActors()));
            return movieTo;
        } else
            return null;
    }

    public static RatingTo createRatingTo ( Rating entity )
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

    public static GenreTo createGenreTo ( Genre entity )
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

    public static ActorTo createActorTo ( Actor entity )
    {
        if ( null != entity )
        {
            ActorTo actorTo = new ActorTo();
            actorTo.setId(entity.getId());
            actorTo.setFirstname(entity.getFirstname());
            actorTo.setLastname(entity.getLastname());
            actorTo.setBirthdate(Utils.convertDateToString(entity.getBirthdate()));
            return actorTo;
        } else
            return null;
    }

    public static ShowTo createShowTo ( Show entity, boolean withMovie )
    {
        if ( null != entity )
        {
            ShowTo showTo = new ShowTo();
            showTo.setShowIs3D(entity.is3D());
            showTo.setId(entity.getId());
            showTo.setHall(createHallTo(entity.getHall()));
            showTo.setDate(Utils.convertDateToString(entity.getDate()));
            showTo.setTime(Utils.convertDateToTime(entity.getTime()));
            showTo.setWeekday(Utils.getWeekDay(entity.getDate()));
            if ( withMovie )
            {
//                showTo.setMovie(createMovieTo(entity.getMovie(), false));
            }
            return showTo;
        }
        return null;
    }

    public static ShowTo createShowToWithMovie ( Show entity )
    {
        if ( null != entity )
        {
            ShowTo showTo = new ShowTo();
            showTo.setId(entity.getId());
            showTo.setHall(createHallTo(entity.getHall()));
            showTo.setMovie(createMovieTo(entity.getMovie(), false));
            showTo.setDate(Utils.convertDateToString(entity.getDate()));
            showTo.setTime(Utils.convertDateToTime(entity.getTime()));
            showTo.setWeekday(Utils.getWeekDay(entity.getDate()));
            showTo.setShowIs3D(entity.is3D());
            return showTo;
        }
        return null;
    }

    public static ShowTo createShowToWithoutMovie ( Show entity )
    {
        if ( null != entity )
        {
            ShowTo showTo = new ShowTo();
            showTo.setId(entity.getId());
            showTo.setHall(createHallTo(entity.getHall()));
            showTo.setDate(Utils.convertDateToString(entity.getDate()));
            showTo.setTime(Utils.convertDateToTime(entity.getTime()));
            showTo.setWeekday(Utils.getWeekDay(entity.getDate()));
            return showTo;
        }
        return null;
    }

    public static ReservationTo createReservationTo ( Reservation entity, boolean withTickets )
    {
        if ( null != entity )
        {
            ReservationTo reservationTo = new ReservationTo();
            reservationTo.setId(entity.getId());
            reservationTo.setDateOfReservation(Utils.convertDateToString(entity.getDateOfReservation()));
            reservationTo.setCustomer(createCustomerTo(entity.getCustomer()));
            if ( withTickets )
            {
                reservationTo.setTickets(createTicketTosForReservation(entity.getTickets(), reservationTo));
            }
            return reservationTo;
        } else
            return null;
    }

    public static TicketTo createTicketToForReservation ( Ticket entity )
    {
        if ( null != entity )
        {
            TicketTo ticketTo = new TicketTo();
            ticketTo.setId(entity.getId());
            ticketTo.setReducedPrice(entity.isReducedPrice());
            ticketTo.setSeat(createSeatTo(entity.getSeat()));
            ticketTo.setShow(createShowTo(entity.getShow(), true));
            return ticketTo;
        }
        return null;
    }

    public static TicketTo createTicketTo ( Ticket entity )
    {
        if ( null != entity )
        {
            TicketTo ticketTo = new TicketTo();
            ticketTo.setId(entity.getId());
            ticketTo.setReducedPrice(entity.isReducedPrice());
            ticketTo.setSeat(createSeatTo(entity.getSeat()));
            ticketTo.setReservation(createReservationTo(entity.getReservation(), true));
            ticketTo.setShow(createShowTo(entity.getShow(), true));
            return ticketTo;
        } else
            return null;
    }

    public static SeatTo createSeatTo ( Seat entity )
    {
        if ( null != entity )
        {
            SeatTo seatTo = new SeatTo();
            seatTo.setId(entity.getId());
            seatTo.setNumber(entity.getNumber());
            seatTo.setRow(entity.getRow());
            seatTo.setCategory(createCategoryTo(entity.getCategory()));
            seatTo.setX(entity.getX());
            seatTo.setY(entity.getY());
            seatTo.setPrice(createPriceTo(seatTo.getCategory()));
            return seatTo;
        } else
            return null;
    }

    public static PriceTo createPriceTo ( CategoryTo transferobject )
    {
        if ( null != transferobject )
        {
            return Utils.getPriceForCategory(transferobject.getCategory());
        } else
        {
            return null;
        }
    }

    public static CategoryTo createCategoryTo ( Category entity )
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

    public static HallTo createHallTo ( Hall entity )
    {
        if ( null != entity )
        {
            HallTo hallTo = new HallTo();
            hallTo.setId(entity.getId());
            hallTo.setName(entity.getName());
            hallTo.setWidth(entity.getWidth());
            hallTo.setLength(entity.getLength());
            hallTo.setSeats(createSeatTos(entity.getSeats()));
            return hallTo;
        } else
            return null;
    }

    public static CustomerTo createCustomerTo ( Customer entity )
    {
        if ( null != entity )
        {
            CustomerTo customerTo = new CustomerTo();
            customerTo.setId(entity.getId());
            customerTo.setDateofbirth(Utils.convertDateToString(entity.getDateofbirth()));
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

    public static CustomerTo createCustomerToForRating ( Customer entity )
    {
        if ( null != entity )
        {
            CustomerTo customerTo = new CustomerTo();
            customerTo.setId(entity.getId());
            customerTo.setFirstname(entity.getFirstname());
            customerTo.setLastname(entity.getLastname());
            customerTo.setUsername(entity.getUsername());
            customerTo.setEmail(entity.getEmail());
            customerTo.setDateofbirth(Utils.convertDateToString(entity.getDateofbirth()));
            return customerTo;
        } else
            return null;
    }

    public static BlockTo createBlockTo ( Block entity )
    {
        if ( null != entity )
        {
            BlockTo blockTo = new BlockTo();
            blockTo.setId(entity.getId());
            blockTo.setSeat(createSeatTo(entity.getSeat()));
            blockTo.setShow(createShowTo(entity.getShow(), true));
            blockTo.setSessiontoken(entity.getSessiontoken());
            blockTo.setTimestamp(entity.getTimeofreservation());
            return blockTo;
        } else
            return null;
    }

    // LIST

    public static List<EmployeeTo> createEmployeeTos ( List<Employee> entity )
    {
        List<EmployeeTo> list = new ArrayList<>();
        if ( null != entity )
        {
            for ( Employee element : entity )
            {
                list.add(createEmployeeTo(element));
            }
        }
        return list;
    }

    public static List<ActorTo> createActorTos ( List<Actor> entity )
    {
        List<ActorTo> list = new ArrayList<>();
        if ( null != entity )
        {
            for ( Actor element : entity )
            {
                list.add(createActorTo(element));
            }
        }
        return list;
    }

    public static List<ShowTo> createShowTos ( List<Show> entity, boolean withtickets )
    {
        List<ShowTo> list = new ArrayList<>();
        if ( null != entity )
        {
            for ( Show element : entity )
            {
                list.add(createShowTo(element, withtickets));
            }
        }
        return list;
    }

    public static List<ShowTo> createShowTosWithMovie ( List<Show> entity )
    {
        List<ShowTo> list = new ArrayList<>();
        if ( null != entity )
        {
            for ( Show element : entity )
            {
                list.add(createShowToWithMovie(element));
            }
        }
        return list;
    }

    public static List<ShowTo> createShowTosWithoutMovie ( List<Show> entity )
    {
        List<ShowTo> list = new ArrayList<>();
        if ( null != entity )
        {
            for ( Show element : entity )
            {
                list.add(createShowToWithoutMovie(element));
            }
        }
        return list;
    }

    public static List<ReservationTo> createReservationTos ( List<Reservation> entity )
    {
        List<ReservationTo> list = new ArrayList<>();
        if ( null != entity )
        {
            for ( Reservation element : entity )
            {
                list.add(createReservationTo(element, true));
            }
        }
        return list;
    }

    public static List<TicketTo> createTicketTos ( List<Ticket> entity )
    {
        List<TicketTo> list = new ArrayList<>();
        if ( null != entity )
        {
            for ( Ticket element : entity )
            {
                list.add(createTicketTo(element));
            }
        }
        return list;
    }

    public static List<SeatTo> createSeatTos ( List<Seat> entity )
    {
        List<SeatTo> list = new ArrayList<>();
        if ( null != entity )
        {
            for ( Seat element : entity )
            {
                list.add(createSeatTo(element));
            }
        }
        return list;
    }

    public static List<CustomerTo> createUserTos ( List<Customer> entity )
    {
        List<CustomerTo> list = new ArrayList<>();
        if ( null != entity )
        {
            for ( Customer element : entity )
            {
                list.add(createCustomerTo(element));
            }
        }
        return list;
    }

    public static List<MovieTo> createMovieTos ( List<Movie> entity )
    {
        List<MovieTo> list = new ArrayList<>();
        if ( null != entity )
        {
            for ( Movie element : entity )
            {
                list.add(createMovieTo(element, true));
            }
        }
        return list;
    }

    public static List<RatingTo> createRatingTos ( List<Rating> entity )
    {
        List<RatingTo> list = new ArrayList<>();
        if ( null != entity )
        {
            for ( Rating element : entity )
            {
                list.add(createRatingTo(element));
            }
        }
        return list;
    }

    public static List<GenreTo> createGenreTos ( List<Genre> entity )
    {
        List<GenreTo> list = new ArrayList<>();
        if ( null != entity )
        {
            for ( Genre element : entity )
            {
                list.add(createGenreTo(element));
            }
        }
        return list;
    }

    public static List<TicketTo> createTicketTosForReservation ( List<Ticket> tickets, ReservationTo reservationTo )
    {
        List<TicketTo> list = new ArrayList<>();
        if ( null != tickets )
        {
            for ( Ticket t : tickets )
            {
                list.add(createTicketToForReservation(t));
            }
        }
        return list;
    }

    public static List<BlockTo> createBlockTos ( List<Block> blocks )
    {
        List<BlockTo> list = new ArrayList<>();
        if ( null != blocks )
        {
            for ( Block b : blocks )
            {
                list.add(createBlockTo(b));
            }
        }
        return list;
    }

}
