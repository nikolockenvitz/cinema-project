package com.fallstudie.kinobuchungssystem.system.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import com.fallstudie.kinobuchungssystem.common.exception.GeneralException;
import com.fallstudie.kinobuchungssystem.common.json.JSONConverter;
import com.fallstudie.kinobuchungssystem.common.transferobject.MovieTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.UserTo;
import com.fallstudie.kinobuchungssystem.common.urlhelper.URLS;
import com.fallstudie.kinobuchungssystem.common.urlhelper.UrlCallHelper;
import com.fallstudie.kinobuchungssystem.system.ToCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MovieServiceTest
{

    private UrlCallHelper urlCallHelper = new UrlCallHelper();

    @Test
    public void ka ( ) throws JsonProcessingException
    {
        UserTo item = ToCreator.createUser();
        String result = new ObjectMapper().writeValueAsString(item);

        assertThat(result, containsString("Test Comment"));
    }

    public void createUser ( ) throws IOException, GeneralException
    {
        URL url = new URL(URLS.KINOBUCHUNGSSYSTEM_DATA_MOVIE + "getAllMovies");
        String json = urlCallHelper.sendGet(url, MediaType.APPLICATION_JSON);
        UserTo savedUserTo = (UserTo) JSONConverter.fromJSON(json, UserTo.class);
        long savedId = savedUserTo.getId();
        assertNotNull(savedId);
    }

    public void test ( ) throws Exception
    {
        MovieTo movieTo = ToCreator.createMovieTo(100);
        String rqJson = JSONConverter.toJSON(movieTo);
        MovieTo savedMovieTo = (MovieTo) JSONConverter.fromJSON(rqJson, MovieTo.class);
        long savedId = savedMovieTo.getId();
        assertNotNull(savedId);

    }

    public void saveTripTest ( ) throws Exception
    {
        MovieTo movieTo = ToCreator.createMovieTo(100);
        URL url = new URL(URLS.KINOBUCHUNGSSYSTEM_DATA_MOVIE);
        Map<String, String> parameters = new HashMap<>();
        String rqJson = JSONConverter.toJSON(movieTo);
        parameters.put("trip", rqJson);
        String json = urlCallHelper.sendPost(url, parameters, MediaType.APPLICATION_JSON);
        MovieTo savedTripTo = (MovieTo) JSONConverter.fromJSON(json, MovieTo.class);
        long savedId = savedTripTo.getId();
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

}
