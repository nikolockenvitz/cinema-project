
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fallstudie.cinemasystem.common.json.JSONConverter;
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
import com.fasterxml.jackson.core.JsonProcessingException;

public class JSONConverter_Test
{
    ActorTo             testActorTo               = null;
    String              testStringActorTo         = null;
    String              testStringActorToList     = null;
    List<ActorTo>       testActorToList           = null;
    Calendar            testDate                  = null;
    String              testDateString            = null;
    Date                testDateDate              = null;
    MovieTo             testMovieTo               = null;
    GenreTo             testGenreTo               = null;
    List<GenreTo>       testGenreToList           = null;
    ArrayList           emptyList                 = null;
    ShowTo              testShowTo                = null;
    List<ShowTo>        testShowToList            = null;
    HallTo              testHallTo                = null;
    SeatTo              testSeatTo                = null;
    List<SeatTo>        testSeatToList            = null;
    PriceTo             testPriceTo               = null;
    CategoryTo          testCategoryTo            = null;
    RatingTo            testRatingTo              = null;
    List<RatingTo>      testRatingToList          = null;
    CustomerTo          testCustomerTo            = null;
    List<CustomerTo>    testCustomerToList        = null;
    CustomerTo          testCustomerToForRating   = null;
    ReservationTo       testReservationTo         = null;
    List<ReservationTo> testReservationToList     = null;
    TicketTo            testTicketTo              = null;
    List<TicketTo>      testTicketToList          = null;
    EmployeeTo          testEmployeeTo            = null;
    List<EmployeeTo>    testEmployeeToList        = null;
    BlockTo             testBlockTo               = null;
    List<BlockTo>       testBlockToList           = null;
    String              testStringGenreTo         = null;
    String              testStringPriceTo         = null;
    String              testStringCategoryTo      = null;
    String              testStringSeatTo          = null;
    String              testStringSeatToSpecial   = null;
    String              testStringHallTo          = null;
    String              testStringHallToSpecial   = null;
    String              testStringShowTo          = null;
    String              testStringShowToSpecial   = null;
    String              testStringCustomerTo      = null;
    String              testStringRatingTo        = null;
    String              testStringMovieTo         = null;
    String              testStringMovieToSpecial  = null;
    String              testStringReservationTo   = null;
    String              testStringTicketTo        = null;
    String              testStringTicketToSpecial = null;
    String              testStringEmployeeTo      = null;
    String              testStringBlockTo         = null;
    String              testStringBlockToSpecial  = null;

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

        // actor to
        testActorTo = new ActorTo();
        testActorTo.setId(1);
        testActorTo.setBirthdate("01.01.1970");
        testActorTo.setFirstname("Vorname");
        testActorTo.setLastname("Nachname");

        testStringActorTo = "{\"id\":1,\"firstname\":\"Vorname\",\"lastname\":\"Nachname\",\"birthdate\":\"01.01.1970\"}";

        testActorToList = new ArrayList();
        testActorToList.add(testActorTo);
        testActorToList.add(testActorTo);

        testStringActorToList = "[{\"id\":1,\"firstname\":\"Vorname\",\"lastname\":\"Nachname\",\"birthdate\":\"01.01.1970\"}, {\"id\":1,\"firstname\":\"Vorname\",\"lastname\":\"Nachname\",\"birthdate\":\"01.01.1970\"}]";

        // genre to
        testGenreTo = new GenreTo();
        testGenreTo.setGenre("Test Genre");
        testGenreTo.setId(1);

        testStringGenreTo = "{\"id\":1,\"genre\":\"Test Genre\"}";

        testGenreToList = new ArrayList<>();
        testGenreToList.add(testGenreTo);

        // price to
        testPriceTo = new PriceTo();
        testPriceTo.setDefaultPrice(1000);
        testPriceTo.setReducedPrice(800);

        testStringPriceTo = "{\"reducedPrice\":800,\"defaultPrice\":1000}";

        // category to
        testCategoryTo = new CategoryTo();
        testCategoryTo.setCategory("category");
        testCategoryTo.setId(1);

        testStringCategoryTo = "{\"id\":1,\"category\":\"category\"}";

        // seat to
        testSeatTo = new SeatTo();
        testSeatTo.setId(1);
        testSeatTo.setNumber("1");
        testSeatTo.setRow("1");
        testSeatTo.setX(1);
        testSeatTo.setY(1);
        testSeatTo.setCategory(testCategoryTo);
        testSeatTo.setPrice(testPriceTo);

        testStringSeatTo = "{\"id\":1,\"number\":\"1\",\"row\":\"1\",\"category\":{\"id\":1,\"category\":\"category\"},\"price\":{\"reducedPrice\":800,\"defaultPrice\":1000},\"x\":1,\"y\":1,\"blocked\":false,\"occupied\":false,\"reducedPrice\":false}";
        testStringSeatToSpecial = "{\"id\":1,\"number\":\"1\",\"row\":\"1\",\"category\":{\"id\":1,\"category\":\"category\"},\"price\":{\"reducedPrice\":800,\"defaultPrice\":1000},\"x\":1,\"y\":1";

        testSeatToList = new ArrayList<>();
        testSeatToList.add(testSeatTo);

        // hall to
        testHallTo = new HallTo();
        testHallTo.setId(1);
        testHallTo.setLength(0);
        testHallTo.setName("Name");
        testHallTo.setSeats(testSeatToList);
        testHallTo.setWidth(0);

        testStringHallTo = "{\"id\":1,\"name\":\"Name\",\"width\":0,\"length\":0,\"seats\":[{\"id\":1,\"number\":\"1\",\"row\":\"1\",\"category\":{\"id\":1,\"category\":\"category\"},\"price\":{\"reducedPrice\":800,\"defaultPrice\":1000},\"x\":1,\"y\":1,\"blocked\":false,\"occupied\":false,\"reducedPrice\":false}]}";
        testStringHallToSpecial = "{\"id\":1,\"name\":\"Name\",\"width\":0,\"length\":0,\"seats\":[{\"id\":1,\"number\":\"1\",\"row\":\"1\",\"category\":{\"id\":1,\"category\":\"category\"},\"price\":{\"reducedPrice\":800,\"defaultPrice\":1000},\"x\":1,\"y\":1";

        // show to
        testShowTo = new ShowTo();
        testShowTo.setDate(testDateString);
        testShowTo.setHall(testHallTo);
        testShowTo.setId(1);
        testShowTo.setShowIs3D(false);
        testShowTo.setTime(Utils.convertDateToTime(testDateDate));
        testShowTo.setWeekday(Utils.getWeekDay(testDateDate));

        testStringShowTo = "{\"id\":1,\"date\":\"17.01.2019\",\"time\":\"00:00\",\"weekday\":\"Donnerstag\",\"movie\":null,\"hall\":{\"id\":1,\"name\":\"Name\",\"width\":0,\"length\":0,\"seats\":[{\"id\":1,\"number\":\"1\",\"row\":\"1\",\"category\":{\"id\":1,\"category\":\"category\"},\"price\":{\"reducedPrice\":800,\"defaultPrice\":1000},\"x\":1,\"y\":1,\"blocked\":false,\"occupied\":false,\"reducedPrice\":false}]},\"showIs3D\":false}";
        testStringShowToSpecial = "{\"id\":1,\"date\":\"17.01.2019\",\"time\":\"00:00\",\"weekday\":\"Donnerstag\",\"movie\":null,\"hall\":{\"id\":1,\"name\":\"Name\",\"width\":0,\"length\":0,\"seats\":[{\"id\":1,\"number\":\"1\",\"row\":\"1\",\"category\":{\"id\":1,\"category\":\"category\"},\"price\":{\"reducedPrice\":800,\"defaultPrice\":1000},\"x\":1,\"y\":1";

        testShowToList = new ArrayList<>();
        testShowToList.add(testShowTo);

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

        testStringCustomerTo = "{\"id\":1,\"firstname\":\"firstname\",\"lastname\":\"lastname\",\"username\":\"username\",\"email\":\"mail\",\"dateofbirth\":\"17.01.2019\",\"isAdmin\":0}";

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

        // rating to
        testRatingTo = new RatingTo();
        testRatingTo.setComment("comment");
        testRatingTo.setId(1);
        testRatingTo.setRating(1);
        testRatingTo.setCustomer(testCustomerToForRating);

        testStringRatingTo = "{\"id\":1,\"comment\":\"comment\",\"rating\":1,\"customer\":{\"id\":1,\"firstname\":\"firstname\",\"lastname\":\"lastname\",\"username\":\"username\",\"email\":\"mail\",\"dateofbirth\":\"17.01.2019\",\"isAdmin\":0}}";

        testRatingToList = new ArrayList<>();
        testRatingToList.add(testRatingTo);

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

        testStringMovieTo = "{\"id\":1,\"description\":\"Testdesc\",\"duration\":10,\"fsk\":0,\"name\":\"Test Film\",\"actors\":[{\"id\":1,\"firstname\":\"Vorname\",\"lastname\":\"Nachname\",\"birthdate\":\"01.01.1970\"},{\"id\":1,\"firstname\":\"Vorname\",\"lastname\":\"Nachname\",\"birthdate\":\"01.01.1970\"}],\"genres\":[{\"id\":1,\"genre\":\"Test Genre\"}],\"shows\":[{\"id\":1,\"date\":\"17.01.2019\",\"time\":\"00:00\",\"weekday\":\"Donnerstag\",\"movie\":null,\"hall\":{\"id\":1,\"name\":\"Name\",\"width\":0,\"length\":0,\"seats\":[{\"id\":1,\"number\":\"1\",\"row\":\"1\",\"category\":{\"id\":1,\"category\":\"category\"},\"price\":{\"reducedPrice\":800,\"defaultPrice\":1000},\"x\":1,\"y\":1,\"blocked\":false,\"occupied\":false,\"reducedPrice\":false}]},\"showIs3D\":false}],\"ratings\":[{\"id\":1,\"comment\":\"comment\",\"rating\":1,\"customer\":{\"id\":1,\"firstname\":\"firstname\",\"lastname\":\"lastname\",\"username\":\"username\",\"email\":\"mail\",\"dateofbirth\":\"17.01.2019\",\"isAdmin\":0}}]}";
        testStringMovieToSpecial = "{\"id\":1,\"description\":\"Testdesc\",\"duration\":10,\"fsk\":0,\"name\":\"Test Film\",\"actors\":[{\"id\":1,\"firstname\":\"Vorname\",\"lastname\":\"Nachname\",\"birthdate\":\"01.01.1970\"},{\"id\":1,\"firstname\":\"Vorname\",\"lastname\":\"Nachname\",\"birthdate\":\"01.01.1970\"}],\"genres\":[{\"id\":1,\"genre\":\"Test Genre\"}]";

        // empty list
        emptyList = new ArrayList<>();

        // reservation to
        testReservationTo = new ReservationTo();
        testReservationTo.setCustomer(testCustomerTo);
        testReservationTo.setId(1);
        testReservationTo.setDateOfReservation(testDateString);

        testStringReservationTo = "{\"id\":1,\"dateOfReservation\":\"17.01.2019\",\"customer\":{\"id\":1,\"firstname\":\"firstname\",\"lastname\":\"lastname\",\"username\":\"username\",\"email\":\"mail\",\"dateofbirth\":\"17.01.2019\",\"isAdmin\":0},\"tickets\":null}";

        testReservationToList = new ArrayList<>();
        testReservationToList.add(testReservationTo);

        // ticket to
        testTicketTo = new TicketTo();
        testTicketTo.setId(1);
        testTicketTo.setReducedPrice(false);
        testTicketTo.setReservation(testReservationTo);
        testTicketTo.setSeat(testSeatTo);
        testTicketTo.setShow(testShowTo);

        testStringTicketTo = "{\"id\":1,\"show\":{\"id\":1,\"date\":\"17.01.2019\",\"time\":\"00:00\",\"weekday\":\"Donnerstag\",\"movie\":null,\"hall\":{\"id\":1,\"name\":\"Name\",\"width\":0,\"length\":0,\"seats\":[{\"id\":1,\"number\":\"1\",\"row\":\"1\",\"category\":{\"id\":1,\"category\":\"category\"},\"price\":{\"reducedPrice\":800,\"defaultPrice\":1000},\"x\":1,\"y\":1,\"blocked\":false,\"occupied\":false,\"reducedPrice\":false}]},\"showIs3D\":false},\"seat\":{\"id\":1,\"number\":\"1\",\"row\":\"1\",\"category\":{\"id\":1,\"category\":\"category\"},\"price\":{\"reducedPrice\":800,\"defaultPrice\":1000},\"x\":1,\"y\":1,\"blocked\":false,\"occupied\":false,\"reducedPrice\":false},\"reservation\":{\"id\":1,\"dateOfReservation\":\"17.01.2019\",\"customer\":{\"id\":1,\"firstname\":\"firstname\",\"lastname\":\"lastname\",\"username\":\"username\",\"email\":\"mail\",\"dateofbirth\":\"17.01.2019\",\"isAdmin\":0},\"tickets\":null},\"reducedPrice\":false}";
        testStringTicketToSpecial = "{\"id\":1,\"show\":{\"id\":1,\"date\":\"17.01.2019\",\"time\":\"00:00\",\"weekday\":\"Donnerstag\",\"movie\":null,\"hall\":{\"id\":1,\"name\":\"Name\",\"width\":0,\"length\":0";

        testTicketToList = new ArrayList<>();
        testTicketToList.add(testTicketTo);

        // employee to
        testEmployeeTo = new EmployeeTo();
        testEmployeeTo.setId(1);
        testEmployeeTo.setDateofbirth(testDateString);
        testEmployeeTo.setEmail("mail");
        testEmployeeTo.setFirstname("firstname");
        testEmployeeTo.setLastname("lastname");

        testStringEmployeeTo = "{\"id\":1,\"firstname\":\"firstname\",\"lastname\":\"lastname\",\"dateofbirth\":\"17.01.2019\",\"email\":\"mail\"}";

        testEmployeeToList = new ArrayList<>();
        testEmployeeToList.add(testEmployeeTo);

        // block to
        testBlockTo = new BlockTo();
        testBlockTo.setId(1);
        testBlockTo.setSeat(testSeatTo);
        testBlockTo.setSessiontoken("sessiontoken");
        testBlockTo.setShow(testShowTo);
        testBlockTo.setTimestamp(testDateDate);

        testStringBlockTo = "{\"id\":1,\"seat\":{\"id\":1,\"number\":\"1\",\"row\":\"1\",\"category\":{\"id\":1,\"category\":\"category\"},\"price\":{\"reducedPrice\":800,\"defaultPrice\":1000},\"x\":1,\"y\":1,\"blocked\":false,\"occupied\":false,\"reducedPrice\":false},\"show\":{\"id\":1,\"date\":\"17.01.2019\",\"time\":\"00:00\",\"weekday\":\"Donnerstag\",\"movie\":null,\"hall\":{\"id\":1,\"name\":\"Name\",\"width\":0,\"length\":0,\"seats\":[{\"id\":1,\"number\":\"1\",\"row\":\"1\",\"category\":{\"id\":1,\"category\":\"category\"},\"price\":{\"reducedPrice\":800,\"defaultPrice\":1000},\"x\":1,\"y\":1,\"blocked\":false,\"occupied\":false,\"reducedPrice\":false}]},\"showIs3D\":false},\"timestamp\":1547679600000}";
        testStringBlockToSpecial = "{\"id\":1,\"seat\":{\"id\":1,\"number\":\"1\",\"row\":\"1\",\"category\":{\"id\":1,\"category\":\"category\"},\"price\":{\"reducedPrice\":800,\"defaultPrice\":1000},\"x\":1,\"y\":1";

        testBlockToList = new ArrayList<>();
        testBlockToList.add(testBlockTo);

    }

    @Test
    public void testToJSON ( )
    {
        try
        {
            assertThat(testStringActorTo, equalTo(JSONConverter.toJSON(testActorTo)));
            assertThat(testStringGenreTo, equalTo(JSONConverter.toJSON(testGenreTo)));
            assertThat(testStringPriceTo, equalTo(JSONConverter.toJSON(testPriceTo)));
            assertThat(testStringCategoryTo, equalTo(JSONConverter.toJSON(testCategoryTo)));
            assertThat(testStringCustomerTo, equalTo(JSONConverter.toJSON(testCustomerTo)));
            assertThat(testStringRatingTo, equalTo(JSONConverter.toJSON(testRatingTo)));
            assertThat(testStringReservationTo, equalTo(JSONConverter.toJSON(testReservationTo)));
            assertThat(testStringEmployeeTo, equalTo(JSONConverter.toJSON(testEmployeeTo)));

            assertThat(true, equalTo(JSONConverter.toJSON(testSeatTo).contains(testStringSeatToSpecial)));
            assertThat(true, equalTo(JSONConverter.toJSON(testHallTo).contains(testStringHallToSpecial)));
            assertThat(true, equalTo(JSONConverter.toJSON(testShowTo).contains(testStringShowToSpecial)));
            assertThat(true, equalTo(JSONConverter.toJSON(testTicketTo).contains(testStringTicketToSpecial)));
            assertThat(true, equalTo(JSONConverter.toJSON(testBlockTo).contains(testStringBlockToSpecial)));
            assertThat(true, equalTo(JSONConverter.toJSON(testMovieTo).contains(testStringMovieToSpecial)));

        } catch (JsonProcessingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testFromJSON ( )
    {
        try
        {
            assertThat(testActorTo, equalTo(JSONConverter.fromJSON(testStringActorTo, ActorTo.class)));
            assertThat(testGenreTo, equalTo(JSONConverter.fromJSON(testStringGenreTo, GenreTo.class)));
            assertThat(testPriceTo, equalTo(JSONConverter.fromJSON(testStringPriceTo, PriceTo.class)));
            assertThat(testCategoryTo, equalTo(JSONConverter.fromJSON(testStringCategoryTo, CategoryTo.class)));
            assertThat(testRatingTo, equalTo(JSONConverter.fromJSON(testStringRatingTo, RatingTo.class)));
            assertThat(testEmployeeTo, equalTo(JSONConverter.fromJSON(testStringEmployeeTo, EmployeeTo.class)));
            assertThat(testMovieTo, equalTo(JSONConverter.fromJSON(testStringMovieTo, MovieTo.class)));
            assertThat(testSeatTo, equalTo(JSONConverter.fromJSON(testStringSeatTo, SeatTo.class)));
            assertThat(testHallTo, equalTo(JSONConverter.fromJSON(testStringHallTo, HallTo.class)));
            assertThat(testShowTo, equalTo(JSONConverter.fromJSON(testStringShowTo, ShowTo.class)));

            // special tos
            CustomerTo compareCustomerTo = (CustomerTo) JSONConverter.fromJSON(testStringCustomerTo, CustomerTo.class);
            ReservationTo compareReservationTo = (ReservationTo) JSONConverter.fromJSON(testStringReservationTo, ReservationTo.class);
            TicketTo compareTicketTo = (TicketTo) JSONConverter.fromJSON(testStringTicketTo, TicketTo.class);
            BlockTo compareBlockTo = (BlockTo) JSONConverter.fromJSON(testStringBlockTo, BlockTo.class);

            assertThat(testCustomerTo.getId(), equalTo(compareCustomerTo.getId()));
            assertThat(testReservationTo.getId(), equalTo(compareReservationTo.getId()));
            assertThat(testTicketTo.getId(), equalTo(compareTicketTo.getId()));
            assertThat(testBlockTo.getId(), equalTo(compareBlockTo.getId()));

        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testFromJSONList ( )
    {
        try
        {
            assertThat(testActorToList, equalTo(JSONConverter.fromJSONList(testStringActorToList, ActorTo.class)));
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
