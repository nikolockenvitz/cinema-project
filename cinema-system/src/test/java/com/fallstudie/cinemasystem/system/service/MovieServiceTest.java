package com.fallstudie.cinemasystem.system.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import com.fallstudie.cinemasystem.common.exception.GeneralException;
import com.fallstudie.cinemasystem.common.json.JSONConverter;
import com.fallstudie.cinemasystem.common.transferobject.CustomerTo;
import com.fallstudie.cinemasystem.common.transferobject.MovieTo;
import com.fallstudie.cinemasystem.common.urlhelper.URLS;
import com.fallstudie.cinemasystem.common.urlhelper.UrlCallHelper;
import com.fallstudie.cinemasystem.common.utils.Utils;
import com.fallstudie.cinemasystem.system.ToCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MovieServiceTest
{

    private UrlCallHelper urlCallHelper = new UrlCallHelper();

    @Test
    public void ka ( ) throws JsonProcessingException
    {
        CustomerTo item = ToCreator.createCustomer();
        String result = new ObjectMapper().writeValueAsString(item);

        assertThat(result, (containsString("Test Comment")));
    }

    public void createUser ( ) throws IOException, GeneralException
    {
        URL url = new URL(URLS.KINOBUCHUNGSSYSTEM_DATA_MOVIE + "getAllMovies");
        String json = urlCallHelper.sendGet(url, MediaType.APPLICATION_JSON);
        CustomerTo savedUserTo = (CustomerTo) JSONConverter.fromJSON(json, CustomerTo.class);
        long savedId = savedUserTo.getId();
        assertNotNull(savedId);
    }

    @Test
    public void movieTo ( ) throws Exception
    {
        MovieTo movieTo = ToCreator.createMovieTo(100);
        String rqJson = JSONConverter.toJSON(movieTo);
        MovieTo savedMovieTo = (MovieTo) JSONConverter.fromJSON(rqJson, MovieTo.class);
        long id = savedMovieTo.getId();
        assertNotNull(id);
    }

    public void saveMovieTest ( ) throws Exception
    {
        MovieTo movieTo = ToCreator.createMovieTo(100);
        URL url = new URL(URLS.KINOBUCHUNGSSYSTEM_DATA_MOVIE);
        Map<String, String> parameters = new HashMap<>();
        String rqJson = JSONConverter.toJSON(movieTo);
        parameters.put("trip", rqJson);
        String json = urlCallHelper.sendPost(url, parameters, MediaType.APPLICATION_JSON);
        MovieTo savedMovieTo = (MovieTo) JSONConverter.fromJSON(json, MovieTo.class);
        long savedId = savedMovieTo.getId();
        assertNotNull(savedId);

        MovieTo readMovie = getMovie(savedId);
        // TODO assertEquals(savedMovieTo, readMovie);

        List<MovieTo> filteredMovies = filterMovie(readMovie.getId());
        assertTrue(filteredMovies.size() >= 1);

    }

    @SuppressWarnings("unchecked")
    private List<MovieTo> filterMovie ( long id ) throws Exception
    {
        Map<String, String> parameters = new HashMap<>();
        String json = urlCallHelper.sendGet(URLS.KINOBUCHUNGSSYSTEM_DATA_MOVIE + id, parameters, MediaType.TEXT_PLAIN);
        List<MovieTo> movieTos = (List<MovieTo>) JSONConverter.fromJSONList(json, MovieTo.class);
        return movieTos;
    }

    private MovieTo getMovie ( long id ) throws Exception
    {
        Map<String, String> parameters = new HashMap<>();
        String json = urlCallHelper.sendGet(URLS.KINOBUCHUNGSSYSTEM_DATA_MOVIE + id, parameters, MediaType.TEXT_PLAIN);
        MovieTo movieTo = (MovieTo) JSONConverter.fromJSON(json, MovieTo.class);
        return movieTo;
    }

    @Test
    public void convertDateToString ( )
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 17);

        Date date = cal.getTime();
        String convertedDate = Utils.convertDateToString(date);

        String toProof = "17.01.2019";
        assertEquals(convertedDate, toProof);
    }

    @Test
    public void getWeekDay ( )
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 17);

        Date date = cal.getTime();

        String s = Utils.getWeekDay(date);
        assertThat(s, containsString("Donnerstag"));
    }

    @Test
    public void getTimeOfDate ( )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 20);
        calendar.set(Calendar.MINUTE, 15);

        String s = Utils.convertDateToTime(calendar.getTime());
        assertEquals("20:15", s);
    }

}
