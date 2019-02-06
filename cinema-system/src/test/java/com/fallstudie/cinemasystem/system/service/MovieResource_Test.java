package com.fallstudie.cinemasystem.system.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.fallstudie.cinemasystem.common.json.JSONConverter;
import com.fallstudie.cinemasystem.common.transferobject.MovieTo;
import com.fallstudie.cinemasystem.resource.MovieResource;

public class MovieResource_Test
{

    MovieResource testMovieResource = null;
    String        testMovieJSON     = null;
    String        testMovieJSONPost = null;
    MovieTo       testMovieTo       = null;
    ArrayList     emptyList         = null;

    @Before
    public void initialize ( )
    {

        testMovieResource = new MovieResource();

        testMovieJSON = "{\"id\":0,\"description\":\"test description\",\"duration\":100,\"fsk\":0,\"name\":\"Test - The Movie\",\"actors\":[],\"genres\":[],\"shows\":[],\"ratings\":[]}";
        testMovieJSONPost = "\"description\":\"test description\",\"duration\":100,\"fsk\":0,\"name\":\"Test - The Movie\",\"actors\":[],\"genres\":[],\"shows\":[],\"ratings\":[]}";

        emptyList = new ArrayList<>();

        // movie to
        testMovieTo = new MovieTo();
        testMovieTo.setId(100);
        testMovieTo.setDescription("Testdesc");
        testMovieTo.setDuration(10);
        testMovieTo.setFsk(0);
        testMovieTo.setName("Test Film");
        testMovieTo.setGenres(emptyList);
        testMovieTo.setActors(emptyList);
        testMovieTo.setShows(emptyList);
        testMovieTo.setRatings(emptyList);

    }

    @Test
    public void testGetMovieById ( )
    {
        assertThat(testMovieJSON, equalTo(testMovieResource.getMovieById("0").getEntity()));
    }

    @Test
    public void testGetAllMovies ( )
    {
        assertThat(true, equalTo(testMovieResource.getAllMovies().getEntity().toString().contains(testMovieJSON)));
    }

    @Test
    public void testPostMovie ( )
    {
        assertThat(true, equalTo(testMovieResource.postMovie(testMovieJSON).getEntity().toString().contains(testMovieJSONPost)));
    }

    @Test
    public void testPostAndGetMovie ( )
    {
        String sendString = null;
        String receivedAfterPost = null;
        String receivedAfterGet = null;
        MovieTo receivedMovieToFromPost = null;
        MovieTo receivedMovieToFromGet = null;

        try
        {
            sendString = JSONConverter.toJSON(testMovieTo);
            System.out.println(sendString);
            System.out.println(testMovieJSON);

            receivedAfterPost = testMovieResource.postMovie(sendString).getEntity().toString();
            System.out.println(receivedAfterPost);

            receivedMovieToFromPost = (MovieTo) JSONConverter.fromJSON(receivedAfterPost, MovieTo.class);
            long testMovieId = receivedMovieToFromPost.getId();

            receivedAfterGet = testMovieResource.getMovieById(String.valueOf(testMovieId)).getEntity().toString();

            receivedMovieToFromGet = (MovieTo) JSONConverter.fromJSON(receivedAfterGet, MovieTo.class);

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        assertThat(testMovieTo.getName(), equalTo(receivedMovieToFromGet.getName()));
        assertThat(testMovieTo.getDescription(), equalTo(receivedMovieToFromGet.getDescription()));
        assertThat(testMovieTo.getFsk(), equalTo(receivedMovieToFromGet.getFsk()));
        assertThat(testMovieTo.getDuration(), equalTo(receivedMovieToFromGet.getDuration()));
        assertThat(testMovieTo.getGenres(), equalTo(receivedMovieToFromGet.getGenres()));
        assertThat(testMovieTo.getActors(), equalTo(receivedMovieToFromGet.getActors()));
        assertThat(testMovieTo.getRatings(), equalTo(receivedMovieToFromGet.getRatings()));
        assertThat(testMovieTo.getShows(), equalTo(receivedMovieToFromGet.getShows()));

    }

}
