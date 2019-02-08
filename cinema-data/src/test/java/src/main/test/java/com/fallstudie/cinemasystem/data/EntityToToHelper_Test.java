package src.main.test.java.com.fallstudie.cinemasystem.data;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

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
import com.fallstudie.cinemasystem.data.helper.EntityToToHelper;

public class EntityToToHelper_Test
{
    EntityToToHelper    EtoToHelper               = new EntityToToHelper();
    Actor               testActor1Entity          = null;
    List<Actor>         testActorEntityList       = null;
    ActorTo             testActor1To              = null;
    List<ActorTo>       testActorToList           = null;
    Calendar            testDate                  = null;
    String              testDateString            = null;
    Date                testDateDate              = null;
    Movie               testMovieEntity           = null;
    List<Movie>         testMovieEntityList       = null;
    MovieTo             testMovieTo               = null;
    List<MovieTo>       testMovieToList           = null;
    Genre               testGenreEntity           = null;
    List<Genre>         testGenreEntityList       = null;
    GenreTo             testGenreTo               = null;
    List<GenreTo>       testGenreToList           = null;
    ArrayList           emptyList                 = null;
    Show                testShowEntity            = null;
    List<Show>          testShowEntityList        = null;
    ShowTo              testShowTo                = null;
    List<ShowTo>        testShowToList            = null;
    Hall                testHallEntity            = null;
    HallTo              testHallTo                = null;
    Seat                testSeatEntity            = null;
    List<Seat>          testSeatEntityList        = null;
    SeatTo              testSeatTo                = null;
    List<SeatTo>        testSeatToList            = null;
    PriceTo             testPriceTo               = null;
    Category            testCategoryEntity        = null;
    CategoryTo          testCategoryTo            = null;
    Rating              testRatingEntity          = null;
    List<Rating>        testRatingEntityList      = null;
    RatingTo            testRatingTo              = null;
    List<RatingTo>      testRatingToList          = null;
    Customer            testCustomerEntity        = null;
    List<Customer>      testCustomerEntityList    = null;
    CustomerTo          testCustomerTo            = null;
    List<CustomerTo>    testCustomerToList        = null;
    CustomerTo          testCustomerToForRating   = null;
    Reservation         testReservationEntity     = null;
    List<Reservation>   testReservationEntityList = null;
    ReservationTo       testReservationTo         = null;
    List<ReservationTo> testReservationToList     = null;
    Ticket              testTicketEntity          = null;
    List<Ticket>        testTicketEntityList      = null;
    TicketTo            testTicketTo              = null;
    List<TicketTo>      testTicketToList          = null;
    Employee            testEmployeeEntity        = null;
    List<Employee>      testEmployeeEntityList    = null;
    EmployeeTo          testEmployeeTo            = null;
    List<EmployeeTo>    testEmployeeToList        = null;
    Block               testBlockEntity           = null;
    List<Block>         testBlockEntityList       = null;
    BlockTo             testBlockTo               = null;
    List<BlockTo>       testBlockToList           = null;

    @Before
    public void initialize ( )
    {
        // Date
        testDate = Calendar.getInstance();
        testDate.set(Calendar.YEAR, 2019);
        testDate.set(Calendar.MONTH, Calendar.JANUARY);
        testDate.set(Calendar.DAY_OF_MONTH, 17);

        testDateString = Utils.convertDateToString(testDate.getTime());
        testDateDate = Utils.convertStringToDate(testDateString);

        // actor entity
        testActor1Entity = new Actor();
        testActor1Entity.setId(1);
        testActor1Entity.setBirthdate(testDateDate);
        testActor1Entity.setFirstname("Vorname");
        testActor1Entity.setLastname("Nachname");

        testActorEntityList = new ArrayList<>();
        testActorEntityList.add(testActor1Entity);

        // actor to
        testActor1To = new ActorTo();
        testActor1To.setId(1);
        testActor1To.setBirthdate(testDateString);
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
        testShowEntity.setDate(testDateDate);
        testShowEntity.setHall(testHallEntity);
        testShowEntity.setId(1);
        testShowEntity.setIs3D(false);
        testShowEntity.setTime(testDateDate);

        testShowEntityList = new ArrayList<>();
        testShowEntityList.add(testShowEntity);

        // show to
        testShowTo = new ShowTo();
        testShowTo.setDate(testDateString);
        testShowTo.setHall(testHallTo);
        testShowTo.setId(1);
        testShowTo.setShowIs3D(false);
        testShowTo.setTime(Utils.convertDateToTime(testDateDate));
        testShowTo.setWeekday(Utils.getWeekDay(testDateDate));

        testShowToList = new ArrayList<>();
        testShowToList.add(testShowTo);

        // customer entity
        testCustomerEntity = new Customer();
        testCustomerEntity.setDateofbirth(testDateDate);
        testCustomerEntity.setEmail("mail");
        testCustomerEntity.setFirstname("firstname");
        testCustomerEntity.setId(1);
        testCustomerEntity.setIsadmin(0);
        testCustomerEntity.setLastname("lastname");
        testCustomerEntity.setPwhash("pwhash");
        testCustomerEntity.setSessiontoken("token");
        testCustomerEntity.setUsername("username");

        testCustomerEntityList = new ArrayList<>();
        testCustomerEntityList.add(testCustomerEntity);

        // customer to
        testCustomerTo = new CustomerTo();
        testCustomerTo.setDateofbirth(testDateString);
        testCustomerTo.setEmail("mail");
        testCustomerTo.setFirstname("firstname");
        testCustomerTo.setId(1);
        testCustomerTo.setIsAdmin(0);
        testCustomerTo.setLastname("lastname");
        testCustomerTo.setPwhash("pwhash");
        testCustomerTo.setSessiontoken("token");
        testCustomerTo.setUsername("username");

        testCustomerToList = new ArrayList<>();
        testCustomerToList.add(testCustomerTo);

        // customer to for rating
        testCustomerToForRating = new CustomerTo();
        testCustomerToForRating.setDateofbirth(testDateString);
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

        testMovieEntityList = new ArrayList<>();
        testMovieEntityList.add(testMovieEntity);

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

        testMovieToList = new ArrayList<>();
        testMovieToList.add(testMovieTo);

        // empty list
        emptyList = new ArrayList<>();

        // reservation entity
        testReservationEntity = new Reservation();
        testReservationEntity.setCustomer(testCustomerEntity);
        testReservationEntity.setId(1);
        testReservationEntity.setDateOfReservation(testDateDate);

        testReservationEntityList = new ArrayList<>();
        testReservationEntityList.add(testReservationEntity);

        // reservation to
        testReservationTo = new ReservationTo();
        testReservationTo.setCustomer(testCustomerTo);
        testReservationTo.setId(1);
        testReservationTo.setDateOfReservation(testDateString);

        testReservationToList = new ArrayList<>();
        testReservationToList.add(testReservationTo);

        // ticket entity
        testTicketEntity = new Ticket();
        testTicketEntity.setId(1);
        testTicketEntity.setReducedPrice(false);
        testTicketEntity.setReservation(testReservationEntity);
        testTicketEntity.setSeat(testSeatEntity);
        testTicketEntity.setShow(testShowEntity);

        testTicketEntityList = new ArrayList<>();
        testTicketEntityList.add(testTicketEntity);

        // ticket to
        testTicketTo = new TicketTo();
        testTicketTo.setId(1);
        testTicketTo.setReducedPrice(false);
        testTicketTo.setReservation(testReservationTo);
        testTicketTo.setSeat(testSeatTo);
        testTicketTo.setShow(testShowTo);

        testTicketToList = new ArrayList<>();
        testTicketToList.add(testTicketTo);

        // employee entity
        testEmployeeEntity = new Employee();
        testEmployeeEntity.setId(1);
        testEmployeeEntity.setDateofbirth(testDateDate);
        testEmployeeEntity.setEmail("mail");
        testEmployeeEntity.setFirstname("firstname");
        testEmployeeEntity.setLastname("lastname");

        testEmployeeEntityList = new ArrayList<>();
        testEmployeeEntityList.add(testEmployeeEntity);

        // employee to
        testEmployeeTo = new EmployeeTo();
        testEmployeeTo.setId(1);
        testEmployeeTo.setDateofbirth(testDateString);
        testEmployeeTo.setEmail("mail");
        testEmployeeTo.setFirstname("firstname");
        testEmployeeTo.setLastname("lastname");

        testEmployeeToList = new ArrayList<>();
        testEmployeeToList.add(testEmployeeTo);

        // block entity
        testBlockEntity = new Block();
        testBlockEntity.setId(1);
        testBlockEntity.setSeat(testSeatEntity);
        testBlockEntity.setSessiontoken("sessiontoken");
        testBlockEntity.setShow(testShowEntity);
        testBlockEntity.setTimeofreservation(testDateDate);

        testBlockEntityList = new ArrayList<>();
        testBlockEntityList.add(testBlockEntity);

        // block to
        testBlockTo = new BlockTo();
        testBlockTo.setId(1);
        testBlockTo.setSeat(testSeatTo);
        testBlockTo.setSessiontoken("sessiontoken");
        testBlockTo.setShow(testShowTo);
        testBlockTo.setTimestamp(testDateDate);

        testBlockToList = new ArrayList<>();
        testBlockToList.add(testBlockTo);

    }

    @Test
    public void testToNull ( )
    {
        // test all To with null entity
        assertEquals(null, EtoToHelper.createActorTo(null));
        assertEquals(null, EtoToHelper.createCategoryTo(null));
        assertEquals(null, EtoToHelper.createCustomerTo(null));
        assertEquals(null, EtoToHelper.createCustomerToForRating(null));
        assertEquals(null, EtoToHelper.createEmployeeTo(null));
        assertEquals(null, EtoToHelper.createGenreTo(null));
        assertEquals(null, EtoToHelper.createHallTo(null));
        assertEquals(null, EtoToHelper.createMovieTo(null, false));
        assertEquals(null, EtoToHelper.createRatingTo(null));
        assertEquals(null, EtoToHelper.createSeatTo(null));
        assertEquals(null, EtoToHelper.createShowTo(null, false));
        assertEquals(null, EtoToHelper.createShowToWithMovie(null));
        assertEquals(null, EtoToHelper.createShowToWithoutMovie(null));
        assertEquals(null, EtoToHelper.createReservationTo(null, false));
        assertEquals(null, EtoToHelper.createTicketToForReservation(null));
        assertEquals(null, EtoToHelper.createTicketTo(null));
        assertEquals(null, EtoToHelper.createPriceTo(null));
        assertEquals(null, EtoToHelper.createBlockTo(null));

        // test all Tos with null entity
        assertEquals(emptyList, EtoToHelper.createActorTos(null));
        assertEquals(emptyList, EtoToHelper.createEmployeeTos(null));
        assertEquals(emptyList, EtoToHelper.createGenreTos(null));
        assertEquals(emptyList, EtoToHelper.createMovieTos(null));
        assertEquals(emptyList, EtoToHelper.createRatingTos(null));
        assertEquals(emptyList, EtoToHelper.createSeatTos(null));
        assertEquals(emptyList, EtoToHelper.createShowTos(null, false));
        assertEquals(emptyList, EtoToHelper.createShowTosWithMovie(null));
        assertEquals(emptyList, EtoToHelper.createShowTosWithoutMovie(null));
        assertEquals(emptyList, EtoToHelper.createUserTos(null));
        assertEquals(emptyList, EtoToHelper.createReservationTos(null));
        assertEquals(emptyList, EtoToHelper.createTicketTos(null));
        assertEquals(emptyList, EtoToHelper.createBlockTos(null));
    }

    @Test
    public void testCreateMovieTo ( )
    {

        // test MovieTo and Movie
        MovieTo compareMovieTo = EtoToHelper.createMovieTo(testMovieEntity, true);

        assertThat(testMovieTo.getId(), equalTo(compareMovieTo.getId()));
        assertThat(testMovieTo.getActors(), equalTo(compareMovieTo.getActors()));
        assertThat(testMovieTo.getDescription(), equalTo(compareMovieTo.getDescription()));
        assertThat(testMovieTo.getDuration(), equalTo(compareMovieTo.getDuration()));
        assertThat(testMovieTo.getFsk(), equalTo(compareMovieTo.getFsk()));
        assertThat(testMovieTo.getName(), equalTo(compareMovieTo.getName()));
        assertThat(testMovieTo.getGenres(), equalTo(compareMovieTo.getGenres()));
        assertThat(testMovieTo.getShows(), equalTo(compareMovieTo.getShows()));
        assertThat(testMovieTo.getRatings(), equalTo(compareMovieTo.getRatings()));

    }

    @Test
    public void testCreateMovieToWithoutShow ( )
    {

        // test MovieTo and Movie

        MovieTo compareMovieTo = EtoToHelper.createMovieTo(testMovieEntity, false);

        assertThat(testMovieTo.getId(), equalTo(compareMovieTo.getId()));
        assertThat(testMovieTo.getActors(), equalTo(compareMovieTo.getActors()));
        assertThat(testMovieTo.getDescription(), equalTo(compareMovieTo.getDescription()));
        assertThat(testMovieTo.getDuration(), equalTo(compareMovieTo.getDuration()));
        assertThat(testMovieTo.getFsk(), equalTo(compareMovieTo.getFsk()));
        assertThat(testMovieTo.getName(), equalTo(compareMovieTo.getName()));
        assertThat(testMovieTo.getGenres(), equalTo(compareMovieTo.getGenres()));
        assertThat(testMovieTo.getRatings(), equalTo(compareMovieTo.getRatings()));

    }

    @Test
    public void testCreateReserverationTo ( )
    {

        ReservationTo compareReservationTo = EtoToHelper.createReservationTo(testReservationEntity, false);

        assertThat(testReservationTo.getDateOfReservation(), equalTo(compareReservationTo.getDateOfReservation()));
        assertThat(testReservationTo.getId(), equalTo(compareReservationTo.getId()));
        assertThat(testReservationTo.getCustomer(), equalTo(compareReservationTo.getCustomer()));

    }

    @Test
    public void testCreateTicketTo ( )
    {
        TicketTo compareTicketTo = EtoToHelper.createTicketTo(testTicketEntity);

        assertThat(testTicketTo.getId(), equalTo(compareTicketTo.getId()));
        assertThat(testTicketTo.getReservation(), equalTo(compareTicketTo.getReservation()));
        assertThat(testTicketTo.getSeat(), equalTo(compareTicketTo.getSeat()));
        assertThat(testTicketTo.getShow(), equalTo(compareTicketTo.getShow()));

    }

    @Test
    public void testCreateTicketToForReservation ( )
    {
        TicketTo compareTicketTo = EtoToHelper.createTicketToForReservation(testTicketEntity);

        assertThat(testTicketTo.getId(), equalTo(compareTicketTo.getId()));
        assertThat(testTicketTo.getSeat(), equalTo(compareTicketTo.getSeat()));
        assertThat(testTicketTo.getShow(), equalTo(compareTicketTo.getShow()));

    }

    @Test
    public void testCreateShowToWithMovie ( )
    {
        ShowTo compareShowTo = EtoToHelper.createShowToWithMovie(testShowEntity);

        assertThat(testShowTo.getId(), equalTo(compareShowTo.getId()));
        assertThat(testShowTo.getHall(), equalTo(compareShowTo.getHall()));
        assertThat(testShowTo.getDate(), equalTo(compareShowTo.getDate()));
        assertThat(testShowTo.getMovie(), equalTo(compareShowTo.getMovie()));
        assertThat(testShowTo.getTime(), equalTo(compareShowTo.getTime()));
        assertThat(testShowTo.getWeekday(), equalTo(compareShowTo.getWeekday()));
    }

    @Test
    public void testCreateShowToWithoutMovie ( )
    {
        ShowTo compareShowTo = EtoToHelper.createShowToWithoutMovie(testShowEntity);

        assertThat(testShowTo.getId(), equalTo(compareShowTo.getId()));
        assertThat(testShowTo.getHall(), equalTo(compareShowTo.getHall()));
        assertThat(testShowTo.getDate(), equalTo(compareShowTo.getDate()));
        assertThat(testShowTo.getTime(), equalTo(compareShowTo.getTime()));
        assertThat(testShowTo.getWeekday(), equalTo(compareShowTo.getWeekday()));
    }

    @Test
    public void testCreateEmployeeTo ( )
    {
        EmployeeTo compareEmployeeTo = EtoToHelper.createEmployeeTo(testEmployeeEntity);

        assertThat(testEmployeeTo.getId(), equalTo(compareEmployeeTo.getId()));
        assertThat(testEmployeeTo.getDateofbirth(), equalTo(compareEmployeeTo.getDateofbirth()));
        assertThat(testEmployeeTo.getEmail(), equalTo(compareEmployeeTo.getEmail()));
        assertThat(testEmployeeTo.getFirstname(), equalTo(compareEmployeeTo.getFirstname()));
        assertThat(testEmployeeTo.getLastname(), equalTo(compareEmployeeTo.getLastname()));
    }

    @Test
    public void testCreateBlockTo ( )
    {
        BlockTo compareBlockTo = EtoToHelper.createBlockTo(testBlockEntity);

        assertThat(testBlockTo.getId(), equalTo(compareBlockTo.getId()));
        assertThat(testBlockTo.getSeat(), equalTo(compareBlockTo.getSeat()));
        assertThat(testBlockTo.getShow(), equalTo(compareBlockTo.getShow()));
        assertThat(testBlockTo.getSessiontoken(), equalTo(compareBlockTo.getSessiontoken()));
        assertThat(testBlockTo.getTimestamp(), equalTo(compareBlockTo.getTimestamp()));
    }

    @Test
    public void testCreateShowTosWithAndWithoutMovie ( )
    {
        assertThat(testShowToList, equalTo(EtoToHelper.createShowTosWithMovie(testShowEntityList)));
        assertThat(testShowToList, equalTo(EtoToHelper.createShowTosWithoutMovie(testShowEntityList)));
    }

    @Test
    public void testCreateEmployeeTos ( )
    {
        for ( EmployeeTo toFromEntity : EtoToHelper.createEmployeeTos(testEmployeeEntityList) )
        {
            for ( EmployeeTo toObject : testEmployeeToList )
            {
                assertThat(toObject, equalTo(toFromEntity));
            }
        }
    }

    @Test
    public void testCreateReservationTos ( )
    {
        for ( ReservationTo toFromEntity : EtoToHelper.createReservationTos(testReservationEntityList) )
        {
            for ( ReservationTo toObject : testReservationToList )
            {
                assertThat(toObject, equalTo(toFromEntity));
            }
        }
    }

    @Test
    public void testCreateTicketTos ( )
    {
        for ( TicketTo toFromEntity : EtoToHelper.createTicketTos(testTicketEntityList) )
        {
            for ( TicketTo toObject : testTicketToList )
            {
                assertThat(toObject, equalTo(toFromEntity));
            }
        }
    }

    @Test
    public void testCreateUserTos ( )
    {
        for ( CustomerTo toFromEntity : EtoToHelper.createUserTos(testCustomerEntityList) )
        {
            for ( CustomerTo toObject : testCustomerToList )
            {
                assertThat(toObject, equalTo(toFromEntity));
            }
        }
    }

    @Test
    public void testCreateMovieTos ( )
    {
        for ( MovieTo toFromEntity : EtoToHelper.createMovieTos(testMovieEntityList) )
        {
            for ( MovieTo toObject : testMovieToList )
            {
                assertThat(toObject, equalTo(toFromEntity));
            }
        }
    }

    @Test
    public void testCreateBlockTos ( )
    {
        for ( BlockTo toFromEntity : EtoToHelper.createBlockTos(testBlockEntityList) )
        {
            for ( BlockTo toObject : testBlockToList )
            {
                assertThat(toObject, equalTo(toFromEntity));
            }
        }
    }

    @Test
    public void testCreateTicketTosForReservation ( )
    {
        for ( TicketTo toFromEntity : EtoToHelper.createTicketTosForReservation(testTicketEntityList, testReservationTo) )
        {
            for ( TicketTo toObject : testTicketToList )
            {
                assertThat(toObject.getId(), equalTo(toFromEntity.getId()));
                assertThat(toObject.getSeat(), equalTo(toFromEntity.getSeat()));
                assertThat(toObject.getShow(), equalTo(toFromEntity.getShow()));
            }
        }
    }
}
