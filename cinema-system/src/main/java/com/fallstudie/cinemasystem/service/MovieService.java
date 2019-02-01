package com.fallstudie.cinemasystem.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.exception.GeneralException;
import com.fallstudie.cinemasystem.common.json.JSONConverter;
import com.fallstudie.cinemasystem.common.transferobject.MovieTo;
import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.common.urlhelper.URLS;
import com.fallstudie.cinemasystem.common.urlhelper.UrlCallHelper;

public class MovieService
{

    private static final Logger LOGGER        = LoggerFactory.getLogger(MovieService.class);
    private UrlCallHelper       urlCallHelper = new UrlCallHelper();

    public MovieService( )
    {

    }

    @SuppressWarnings("unchecked")
    public List<MovieTo> getAllMovies ( ) throws IOException, GeneralException
    {
        Map<String, String> parameters = new HashMap<>();
        String json = urlCallHelper.sendGet(URLS.CINEMASYSTEM_DATA_MOVIE + URLS.GETALLMOVIES, parameters, MediaType.TEXT_PLAIN);
        List<MovieTo> movieTos = (List<MovieTo>) JSONConverter.fromJSONList(json, MovieTo.class);
        return movieTos;
    }

    public MovieTo getMovieById ( String id ) throws IOException, GeneralException
    {
        Map<String, String> parameters = new HashMap<>();
        String json = urlCallHelper.sendGet(URLS.CINEMASYSTEM_DATA_MOVIE + id, parameters, MediaType.TEXT_PLAIN);
        MovieTo movieTo = (MovieTo) JSONConverter.fromJSON(json, MovieTo.class);
        return movieTo;
    }

    public ShowTo getShow ( String id ) throws IOException, GeneralException
    {
        Map<String, String> parameters = new HashMap<>();
        String json = urlCallHelper.sendGet(URLS.CINEMASYSTEM_DATA_MOVIE + URLS.GETSHOW + id, parameters, MediaType.TEXT_PLAIN);
        ShowTo showTo = (ShowTo) JSONConverter.fromJSON(json, ShowTo.class);
        return showTo;
    }

}
