package com.fallstudie.kinobuchungssystem.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fallstudie.kinobuchungssystem.common.transferobject.ActorTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.CategoryTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.GenreTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.HallTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.MovieTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.RatingTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.ReservationTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.SeatTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.ShowTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.TicketTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.UserTo;

public class ToCreator
{

    private List<SeatTo>          seats;
    private static MovieTo        movie = null;
    private static List<RatingTo> ratings;

    public void setRatings ( )
    {
        ratings = createRatings();
    }

    public static MovieTo createMovieTo ( int id )
    {
        MovieTo movieTo = new MovieTo();
        movieTo.setId(id);
        movieTo.setActors(createActors());
        movieTo.setDescription("Test Description");
        movieTo.setFsk(18);
        movieTo.setDuration(120);
        movieTo.setGenre(createGenre(movieTo));
        movieTo.setName("Test Movie");
        movieTo.setShows(createShows(movieTo));
        movieTo.setRatings(createRatings(movieTo));
        movie = movieTo;
        return movieTo;
    }

    private static List<RatingTo> createRatings ( MovieTo movieTo )
    {
        List<RatingTo> ratings = new ArrayList<>();
        RatingTo rating1 = createRatingWithoutUser(movieTo);
        ratings.add(rating1);
        return ratings;
    }

    private List<RatingTo> createRatings ( )
    {
        List<RatingTo> ratings = new ArrayList<>();
        RatingTo rating1 = createRating();
        ratings.add(rating1);
        return ratings;
    }

    private RatingTo createRating ( )
    {
        RatingTo ratingTo = new RatingTo();
        ratingTo.setId(1L);
        ratingTo.setMovie(movie);
        ratingTo.setRating(3);
        ratingTo.setUser(createUser());
        return ratingTo;
    }

    private static RatingTo createRatingWithoutUser ( MovieTo movieTo )
    {
        RatingTo rating = new RatingTo();
        rating.setId(1L);
        rating.setMovie(movieTo);
        rating.setRating(4);
//        rating.setUser(user);
        rating.setComment("Test Comment");
        return rating;
    }

    private static List<ShowTo> createShows ( MovieTo movieTo )
    {
        List<ShowTo> shows = new ArrayList<>();
        ShowTo show1 = createShow(movieTo);
        shows.add(show1);
        return shows;
    }

    private static List<TicketTo> createTickets ( )
    {
        List<TicketTo> tickets = new ArrayList<>();
        TicketTo ticket1 = createTicket();
        tickets.add(ticket1);
        return tickets;
    }

    private static ShowTo createShow ( MovieTo movieTo )
    {
        ShowTo show1 = new ShowTo();
        show1.setId(1L);
        show1.setMovie(movieTo);
        show1.setStarttime(new Date());
        show1.setReservations(null);
        show1.setTickets(null);
        return show1;
    }

    private static SeatTo createSeat ( TicketTo ticket1 )
    {
        SeatTo seat = new SeatTo();
        seat.setId(1L);
        seat.setHall(createHall());
        seat.setNumber(15);
        seat.setRow(10);
        seat.setTicket(createTicket());
//        seat.setCategory(createCategory());
        return seat;
    }

    private static CategoryTo createCategory ( )
    {
        CategoryTo category = new CategoryTo();
        category.setId(1L);
        category.setCategory("Test Category");
        return category;
    }

    private static TicketTo createTicket ( )
    {
        TicketTo ticket1 = new TicketTo();
        ticket1.setId(1L);
        ticket1.setReducedPrice(false);
        ticket1.setReservation(null);
        ticket1.setSeat(findSeat(ticket1));
//        ticket1.setShow(createShow());
        return ticket1;
    }

    private static SeatTo findSeat ( TicketTo ticket1 )
    {
        SeatTo seatTo = new SeatTo();
        seatTo.setId(1L);
        seatTo.setNumber(15);
        seatTo.setRow(10);
        seatTo.setReservation(null);
        seatTo.setTicket(ticket1);
        seatTo.setCategory(new CategoryTo());
        return seatTo;
    }

    private static HallTo createHall ( )
    {
        HallTo hall = new HallTo();
        hall.setId(1L);
        hall.setName("Test Hall");
//        hall.setSeats(createSeats());
        return null;
    }

    private static List<SeatTo> createSeats ( )
    {
        List<SeatTo> seats = new ArrayList<>();
        SeatTo seat1 = createSeat(new TicketTo());
        SeatTo seat2 = new SeatTo();
        seat2.setId(2L);
        seat2.setHall(createHall());
        seat2.setNumber(16);
        seat2.setRow(10);
        TicketTo ticket2 = new TicketTo();
        ticket2.setId(1L);
        ticket2.setReducedPrice(false);
        ticket2.setReservation(null);
        ticket2.setSeat(createSeat2());
//        ticket2.setShow(createShow());
        seat2.setTicket(createTicket());
//        seat2.setCategory(createCategory());
        seats.add(seat1);
        seats.add(seat2);

        return seats;
    }

    private static SeatTo createSeat2 ( )
    {
        SeatTo seat2 = new SeatTo();
        seat2.setId(2L);
        seat2.setHall(createHall());
        seat2.setNumber(16);
        seat2.setRow(10);
        seat2.setTicket(createTicket2());
//        seat2.setCategory(createCategory());
        return seat2;
    }

    private static TicketTo createTicket2 ( )
    {
        TicketTo ticket2 = new TicketTo();
        ticket2.setId(2L);
        ticket2.setReducedPrice(false);
        ticket2.setReservation(null);
        ticket2.setSeat(createSeat2());
//        ticket2.setShow(createShow());
        return ticket2;
    }

    private static List<ReservationTo> createReservations ( )
    {
        List<ReservationTo> reservations = new ArrayList<>();
        ReservationTo reservation1 = createReservation();
        reservations.add(reservation1);
        return reservations;
    }

    private static ReservationTo createReservation ( )
    {
        ReservationTo reservation = new ReservationTo();
        reservation.setId(1L);
        reservation.setDateOfReservation(new Date());
//        reservation.setShow(createShow());
        reservation.setTickets(createTickets());
        return reservation;
    }

    private static List<RatingTo> createRatings ( UserTo user )
    {
        List<RatingTo> ratings = new ArrayList<>();
        RatingTo rating1 = createRating(user);
        ratings.add(rating1);
        return ratings;
    }

    private static RatingTo createRating ( UserTo user )
    {
        RatingTo rating = new RatingTo();
        rating.setId(1L);
        rating.setComment("Test Comment");
        rating.setMovie(createMovieTo(100));
        rating.setRating(3);
        rating.setUser(user);
        return rating;
    }

    public static UserTo createUser ( )
    {
        UserTo user = new UserTo();
        user.setId(1L);
        user.setBirthday(new Date());
        user.setEmail("Test@Test.de");
        user.setIsAdmin(0);
        user.setName("TestUser");
        user.setSessiontoken("TestToken");
        user.setPwhash("TestPwHash");
        user.setRatings(createRatings(user));
        return user;
    }

    private static GenreTo createGenre ( MovieTo movieTo )
    {
        GenreTo genre = new GenreTo();
        genre.setId(1L);
        genre.setGenre("Test Genre");
        return genre;
    }

    private static List<ActorTo> createActors ( )
    {
        List<ActorTo> actors = new ArrayList<>();
        ActorTo actor = new ActorTo();
        actor.setId(1L);
        actor.setFirstname("Test");
        actor.setLastname("Actor");
        actor.setBirthdate(new Date());

        actors.add(actor);
        return actors;
    }

}
