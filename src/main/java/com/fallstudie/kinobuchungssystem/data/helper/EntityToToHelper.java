package com.fallstudie.kinobuchungssystem.data.helper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.NamingConventions;

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

public class EntityToToHelper
{
    // for converting entity to dto
    private static ModelMapper modelMapper = new ModelMapper();

    public static EmployeeTo createEmployeeTo ( Employee entity )
    {
        if ( null != entity )
        {
            EmployeeTo employeeTo = modelMapper.map(entity, EmployeeTo.class);
            return employeeTo;
        } else
            return null;
    }

    public static MovieTo createMovieTo ( Movie entity )
    {
        modelMapper.getConfiguration().setFieldMatchingEnabled(true);
        modelMapper.getConfiguration().setFieldAccessLevel(AccessLevel.PRIVATE);
        modelMapper.getConfiguration().setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        if ( null != entity )
        {
            MovieTo movieTo = modelMapper.map(entity, MovieTo.class);
            return movieTo;
        } else
            return null;
    }

    private static RatingTo createRatingTo ( Rating entity )
    {
        if ( null != entity )
        {
            RatingTo ratingTo = modelMapper.map(entity, RatingTo.class);
            return ratingTo;
        } else
            return null;
    }

    private static GenreTo createGenreTo ( Genre entity )
    {
        if ( null != entity )
        {
            GenreTo genreTo = modelMapper.map(entity, GenreTo.class);
            return genreTo;
        } else
            return null;
    }

    private static ActorTo createActorTo ( Actor entity )
    {
        if ( null != entity )
        {
            ActorTo actorTo = modelMapper.map(entity, ActorTo.class);
            return actorTo;
        } else
            return null;
    }

    private static ShowTo createShowTo ( Show entity )
    {
        if ( null != entity )
        {
            ShowTo showTo = modelMapper.map(entity, ShowTo.class);
            return showTo;
        }
        return null;
    }

    private static ReservationTo createReservationTo ( Reservation entity )
    {
        if ( null != entity )
        {
            ReservationTo reservationTo = modelMapper.map(entity, ReservationTo.class);
            return reservationTo;
        } else
            return null;
    }

    private static TicketTo createTicketTo ( Ticket entity )
    {
        if ( null != entity )
        {
            TicketTo ticketTo = modelMapper.map(entity, TicketTo.class);
            return ticketTo;
        } else
            return null;
    }

    private static SeatTo createSeatTo ( Seat entity )
    {
        if ( null != entity )
        {
            SeatTo seatTo = modelMapper.map(entity, SeatTo.class);
            return seatTo;
        } else
            return null;
    }

    private static CategoryTo createCategoryTo ( Category entity )
    {
        if ( null != entity )
        {
            CategoryTo categoryTo = modelMapper.map(entity, CategoryTo.class);
            return categoryTo;
        } else
            return null;
    }

    private static HallTo createHallTo ( Hall entity )
    {
        if ( null != entity )
        {

            HallTo hallTo = modelMapper.map(entity, HallTo.class);
            return hallTo;
        } else
            return null;
    }

    private static UserTo createUserTo ( User entity )
    {
        if ( null != entity )
        {
            UserTo userTo = modelMapper.map(entity, UserTo.class);
            return userTo;
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

    private static List<ShowTo> createShowTos ( List<Show> entity )
    {
        List<ShowTo> list = new ArrayList<>();
        for ( Show element : entity )
        {
            list.add(createShowTo(element));
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

    public static List<TicketTo> createTicketTos ( List<Ticket> entity )
    {
        List<TicketTo> list = new ArrayList<>();
        for ( Ticket element : entity )
        {
            list.add(createTicketTo(element));
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

    private static List<UserTo> createUserTos ( List<User> entity )
    {
        List<UserTo> list = new ArrayList<>();
        for ( User element : entity )
        {
            list.add(createUserTo(element));
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
}
