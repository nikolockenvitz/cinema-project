package com.fallstudie.kinobuchungssystem.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.kinobuchungssystem.common.exception.GeneralException;
import com.fallstudie.kinobuchungssystem.common.json.JSONConverter;
import com.fallstudie.kinobuchungssystem.common.transferobject.MovieTo;
import com.fallstudie.kinobuchungssystem.common.urlhelper.URLS;
import com.fallstudie.kinobuchungssystem.common.urlhelper.UrlCallHelper;

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
//        List<MovieTo> movieTos = new ArrayList<>();
        Map<String, String> parameters = new HashMap<>();
        String json = urlCallHelper.sendGet(URLS.KINOBUCHUNGSSYSTEM_DATA_MOVIE + URLS.GETALLMOVIES, parameters, MediaType.TEXT_PLAIN);
        List<MovieTo> movieTos = (List<MovieTo>) JSONConverter.fromJSONList(json, MovieTo.class);
        return movieTos;
    }

}
