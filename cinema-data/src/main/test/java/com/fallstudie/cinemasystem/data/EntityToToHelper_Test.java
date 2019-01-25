package com.fallstudie.cinemasystem.data.helper;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fallstudie.cinemasystem.common.transferobject.ActorTo;
import com.fallstudie.cinemasystem.common.transferobject.CategoryTo;
import com.fallstudie.cinemasystem.common.transferobject.CustomerTo;
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
import com.fallstudie.cinemasystem.data.entity.Category;
import com.fallstudie.cinemasystem.data.entity.Customer;
import com.fallstudie.cinemasystem.data.entity.Genre;
import com.fallstudie.cinemasystem.data.entity.Hall;
import com.fallstudie.cinemasystem.data.entity.Movie;
import com.fallstudie.cinemasystem.data.entity.Rating;
import com.fallstudie.cinemasystem.data.entity.Reservation;
import com.fallstudie.cinemasystem.data.entity.Seat;
import com.fallstudie.cinemasystem.data.entity.Show;
import com.fallstudie.cinemasystem.data.entity.Ticket;

public class EntityToToHelper_Test
{
    Actor          testActor1Entity        = null;
    List<Actor>    testActorEntityList     = null;
    ActorTo        testActor1To            = null;
    List<ActorTo>  testActorToList         = null;
    Date           testDate                = null;
    Movie          testMovieEntity         = null;
    MovieTo        testMovieTo             = null;
    Genre          testGenreEntity         = null;
    List<Genre>    testGenreEntityList     = null;
    GenreTo        testGenreTo             = null;
    List<GenreTo>  testGenreToList         = null;
    ArrayList      emptyList               = null;
    Show           testShowEntity          = null;
    List<Show>     testShowEntityList      = null;
    ShowTo         testShowTo              = null;
    List<ShowTo>   testShowToList          = null;
    Hall           testHallEntity          = null;
    HallTo         testHallTo              = null;
    Seat           testSeatEntity          = null;
    List<Seat>     testSeatEntityList      = null;
    SeatTo         testSeatTo              = null;
    List<SeatTo>   testSeatToList          = null;
    PriceTo        testPriceTo             = null;
    Category       testCategoryEntity      = null;
    CategoryTo     testCategoryTo          = null;
    Rating         testRatingEntity        = null;
    List<Rating>   testRatingEntityList    = null;
    RatingTo       testRatingTo            = null;
    List<RatingTo> testRatingToList        = null;
    Customer       testCustomerEntity      = null;
    CustomerTo     testCustomerTo          = null;
    CustomerTo     testCustomerToForRating = null;
    Reservation    testReservationEntity   = null;
    ReservationTo  testReservationTo       = null;
    Ticket         testTicketEntity        = null;
    TicketTo       testTicketTo            = null;

    @Before
    public void initialize ( )
    {
        // Date
        testDate = new Date(2019, 1, 1, 1, 1);

        // actor entity
        testActor1Entity = new Actor();
        testActor1Entity.setId(1);
        testActor1Entity.setBirthdate(testDate);
        testActor1Entity.setFirstname("Vorname");
        testActor1Entity.setLastname("Nachname");

        testActorEntityList = new ArrayList<>();
        testActorEntityList.add(testActor1Entity);

        // actor to
        testActor1To = new ActorTo();
        testActor1To.setId(1);
        testActor1To.setBirthdate(Utils.convertDateToString(testDate));
        testActor1To.setFirstname("Vorname");
        testActor1To.setLastname("Nachname");

        testActorToList = new ArrayList<>();
        testActorToList.add(testActor1To);

        // genre entity
        testGenreEntity = new Genre();
        testGenreEntity.setGenre("Test Genre");
        testGenreEntity.setId(1);

        testGenreEntityList = new ArrayList<>();
        testGenreEntityList.add(testGenreEntity);

        // genre to
        testGenreTo = new GenreTo();
        testGenreTo.setGenre("Test Genre");
        testGenreTo.setId(1);

        testGenreToList = new ArrayList<>();
        testGenreToList.add(testGenreTo);

        // price to
        testPriceTo = new PriceTo();
        testPriceTo.setDefaultPrice(1000);
        testPriceTo.setReducedPrice(800);

        // category entity
        testCategoryEntity = new Category();
        testCategoryEntity.setCategory("category");
        testCategoryEntity.setId(1);

        // category to
        testCategoryTo = new CategoryTo();
        testCategoryTo.setCategory("category");
        testCategoryTo.setId(1);

        // seat entity
        testSeatEntity = new Seat();
        testSeatEntity.setId(1);
        testSeatEntity.setNumber("1");
        testSeatEntity.setRow("1");
        testSeatEntity.setX(1);
        testSeatEntity.setY(1);
        testSeatEntity.setCategory(testCategoryEntity);

        testSeatEntityList = new ArrayList<>();
        testSeatEntityList.add(testSeatEntity);

        // seat to
        testSeatTo = new SeatTo();
        testSeatTo.setId(1);
        testSeatTo.setNumber("1");
        testSeatTo.setRow("1");
        testSeatTo.setX(1);
        testSeatTo.setY(1);
        testSeatTo.setCategory(testCategoryTo);
        testSeatTo.setPrice(testPriceTo);

        testSeatToList = new ArrayList<>();
        testSeatToList.add(testSeatTo);

        // hall entity
        testHallEntity = new Hall();
        testHallEntity.setId(1);
        testHallEntity.setLength(0);
        testHallEntity.setName("Name");
        testHallEntity.setSeats(testSeatEntityList);
        testHallEntity.setWidth(0);

        // hall to
        testHallTo = new HallTo();
        testHallTo.setId(1);
        testHallTo.setLength(0);
        testHallTo.setName("Name");
        testHallTo.setSeats(testSeatToList);
        testHallTo.setWidth(0);

        // show entity
        testShowEntity = new Show();
        testShowEntity.setDate(testDate);
        testShowEntity.setHall(testHallEntity);
        testShowEntity.setId(1);
        testShowEntity.setIs3D(false);
        testShowEntity.setTime("Time");

        testShowEntityList = new ArrayList<>();
        testShowEntityList.add(testShowEntity);

        // show to
        testShowTo = new ShowTo();
        testShowTo.setDate(Utils.convertDateToString(testDate));
        testShowTo.setHall(testHallTo);
        testShowTo.setId(1);
        testShowTo.setIs3D(false);
        testShowTo.setTime("Time");
        testShowTo.setWeekday(Utils.getWeekDay(testDate));

        testShowToList = new ArrayList<>();
        testShowToList.add(testShowTo);

        // customer entity
        testCustomerEntity = new Customer();
        testCustomerEntity.setDateofbirth(testDate);
        testCustomerEntity.setEmail("mail");
        testCustomerEntity.setFirstname("firstname");
        testCustomerEntity.setId(1);
        testCustomerEntity.setIsadmin(0);
        testCustomerEntity.setLastname("lastname");
        testCustomerEntity.setPwhash("pwhash");
        testCustomerEntity.setSessiontoken("token");
        testCustomerEntity.setUsername("username");

        // customer to
        testCustomerTo = new CustomerTo();
        testCustomerTo.setDateofbirth(Utils.convertDateToString(testDate));
        testCustomerTo.setEmail("mail");
        testCustomerTo.setFirstname("firstname");
        testCustomerTo.setId(1);
        testCustomerTo.setIsAdmin(0);
        testCustomerTo.setLastname("lastname");
        testCustomerTo.setPwhash("pwhash");
        testCustomerTo.setSessiontoken("token");
        testCustomerTo.setUsername("username");

        // customer to for rating
        testCustomerToForRating = new CustomerTo();
        testCustomerToForRating.setDateofbirth(Utils.convertDateToString(testDate));
        testCustomerToForRating.setEmail("mail");
        testCustomerToForRating.setFirstname("firstname");
        testCustomerToForRating.setId(1);
        testCustomerToForRating.setLastname("lastname");
        testCustomerToForRating.setUsername("username");

        // rating entity
        testRatingEntity = new Rating();
        testRatingEntity.setComment("comment");
        testRatingEntity.setId(1);
        testRatingEntity.setRating(1);
        testRatingEntity.setUser(testCustomerEntity);

        testRatingEntityList = new ArrayList<>();
        testRatingEntityList.add(testRatingEntity);

        // rating to
        testRatingTo = new RatingTo();
        testRatingTo.setComment("comment");
        testRatingTo.setId(1);
        testRatingTo.setRating(1);
        testRatingTo.setCustomer(testCustomerToForRating);

        testRatingToList = new ArrayList<>();
        testRatingToList.add(testRatingTo);

        // movie entity
        testMovieEntity = new Movie();
        testMovieEntity.setId(1);
        testMovieEntity.setDescription("Testdesc");
        testMovieEntity.setDuration(10);
        testMovieEntity.setFsk(0);
        testMovieEntity.setName("Test Film");
        testMovieEntity.setGenres(testGenreEntityList);
        testMovieEntity.setActors(testActorEntityList);
        testMovieEntity.setShows(testShowEntityList);
        testMovieEntity.setRatings(testRatingEntityList);

        // movie to
        testMovieTo = new MovieTo();
        testMovieTo.setId(1);
        testMovieTo.setDescription("Testdesc");
        testMovieTo.setDuration(10);
        testMovieTo.setFsk(0);
        testMovieTo.setName("Test Film");
        testMovieTo.setGenres(testGenreToList);
        testMovieTo.setActors(testActorToList);
        testMovieTo.setShows(testShowToList);
        testMovieTo.setRatings(testRatingToList);

        // empty list
        emptyList = new ArrayList<>();

        // reservation entity
        testReservationEntity = new Reservation();
        testReservationEntity.setCustomer(testCustomerEntity);
        testReservationEntity.setId(1);
        testReservationEntity.setDateOfReservation(testDate);

        // reservation to
        testReservationTo = new ReservationTo();
        testReservationTo.setCustomer(testCustomerTo);
        testReservationTo.setId(1);
        testReservationTo.setDateOfReservation(testDate);

        // ticket entity
        testTicketEntity = new Ticket();
        testTicketEntity.setId(1);
        testTicketEntity.setReducedPrice(false);
        testTicketEntity.setReservation(testReservationEntity);
        testTicketEntity.setSeat(testSeatEntity);
        testTicketEntity.setShow(testShowEntity);

        // ticket to
        testTicketTo = new TicketTo();
        testTicketTo.setId(1);
        testTicketTo.setReducedPrice(false);
        testTicketTo.setReservation(testReservationTo);
        testTicketTo.setSeat(testSeatTo);
        testTicketTo.setShow(testShowTo);

    }

    @Test
    public void testToNull ( )
    {
        // test all To with null entity
        assertEquals(null, EntityToToHelper.createActorTo(null));
        assertEquals(null, EntityToToHelper.createCategoryTo(null));
        assertEquals(null, EntityToToHelper.createCustomerTo(null));
        assertEquals(null, EntityToToHelper.createCustomerToForRating(null));
        assertEquals(null, EntityToToHelper.createEmployeeTo(null));
        assertEquals(null, EntityToToHelper.createGenreTo(null));
        assertEquals(null, EntityToToHelper.createHallTo(null));
        assertEquals(null, EntityToToHelper.createMovieTo(null, false));
        assertEquals(null, EntityToToHelper.createRatingTo(null));
        assertEquals(null, EntityToToHelper.createSeatTo(null));
        assertEquals(null, EntityToToHelper.createShowTo(null, false));
        assertEquals(null, EntityToToHelper.createShowToWithMovie(null));
        assertEquals(null, EntityToToHelper.createShowToWithoutMovie(null));
        assertEquals(null, EntityToToHelper.createTicketTo(null, false));

        // test all Tos with null entity
        assertEquals(emptyList, EntityToToHelper.createActorTos(null));
        assertEquals(emptyList, EntityToToHelper.createEmployeeTos(null));
        assertEquals(emptyList, EntityToToHelper.createGenreTos(null));
        assertEquals(emptyList, EntityToToHelper.createMovieTos(null));
        assertEquals(emptyList, EntityToToHelper.createRatingTos(null));
        assertEquals(emptyList, EntityToToHelper.createSeatTos(null));
        assertEquals(emptyList, EntityToToHelper.createShowTos(null, false));
        assertEquals(emptyList, EntityToToHelper.createShowTosWithMovie(null));
        assertEquals(emptyList, EntityToToHelper.createShowTosWithoutMovie(null));
        assertEquals(emptyList, EntityToToHelper.createTicketTos(null, false));
        assertEquals(emptyList, EntityToToHelper.createUserTos(null));
    }

    @Test
    public void testCreateMovieTo ( )
    {

        // test MovieTo and Movie

        assertThat(testMovieTo.getActors(), equalTo(EntityToToHelper.createMovieTo(testMovieEntity, true).getActors()));
        assertThat(testMovieTo.getDescription(), equalTo(EntityToToHelper.createMovieTo(testMovieEntity, true).getDescription()));
        assertThat(testMovieTo.getDuration(), equalTo(EntityToToHelper.createMovieTo(testMovieEntity, true).getDuration()));
        assertThat(testMovieTo.getFsk(), equalTo(EntityToToHelper.createMovieTo(testMovieEntity, true).getFsk()));
        assertThat(testMovieTo.getName(), equalTo(EntityToToHelper.createMovieTo(testMovieEntity, true).getName()));
        assertThat(testMovieTo.getGenres(), equalTo(EntityToToHelper.createMovieTo(testMovieEntity, true).getGenres()));
        assertThat(testMovieTo.getShows(), equalTo(EntityToToHelper.createMovieTo(testMovieEntity, true).getShows()));
        assertThat(testMovieTo.getRatings(), equalTo(EntityToToHelper.createMovieTo(testMovieEntity, true).getRatings()));

    }

    @Test
    public void testCreateReserverationTo ( )
    {
        assertThat(testReservationTo.getDateOfReservation(), equalTo(EntityToToHelper.createReservationTo(testReservationEntity).getDateOfReservation()));
        assertThat(testReservationTo.getId(), equalTo(EntityToToHelper.createReservationTo(testReservationEntity).getId()));
        assertThat(testReservationTo.getCustomer(), equalTo(EntityToToHelper.createReservationTo(testReservationEntity).getCustomer()));

    }

    @Test
    public void testCreateTicketTo ( )
    {
        assertThat(testTicketTo.getId(), equalTo(EntityToToHelper.createTicketTo(testTicketEntity, true).getId()));
        assertThat(testTicketTo.getReservation(), equalTo(EntityToToHelper.createTicketTo(testTicketEntity, true).getReservation()));
        assertThat(testTicketTo.getSeat(), equalTo(EntityToToHelper.createTicketTo(testTicketEntity, true).getSeat()));
        assertThat(testTicketTo.getShow(), equalTo(EntityToToHelper.createTicketTo(testTicketEntity, true).getShow()));

    }
}
