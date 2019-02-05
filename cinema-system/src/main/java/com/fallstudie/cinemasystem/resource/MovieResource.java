package com.fallstudie.cinemasystem.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.annotation.Description;
import com.fallstudie.cinemasystem.common.annotation.Propagate;
import com.fallstudie.cinemasystem.common.json.JSONConverter;
import com.fallstudie.cinemasystem.common.responsebuilder.ResponseBuilder;
import com.fallstudie.cinemasystem.common.transferobject.MovieTo;
import com.fallstudie.cinemasystem.service.MovieService;

@Path("/movie")
public class MovieResource
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieResource.class);

    private static final MediaType errorMedia = MediaType.TEXT_PLAIN_TYPE;

    private static final MediaType media = MediaType.APPLICATION_JSON_TYPE;

    private MovieService movieService;

    private ResponseBuilder responseBuilder;

    public MovieResource( )
    {
        this.movieService = new MovieService();
        this.responseBuilder = new ResponseBuilder();
    }

    @GET
    @Path("{id}")
    @Propagate
    @Description(value = "Method to get a movie by id!")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response getMovieById ( @PathParam("id") String id )
    {
        String json = "";
        try
        {
            MovieTo movieTo = movieService.getMovieById(id);
            json = JSONConverter.toJSON(movieTo);
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(errorMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(media, json);
    }

    @GET
    @Path("getAllMovies")
    @Propagate
    @Description(value = "Method to get all movies!")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response getAllMovies ( )
    {
        String json = "";
        try
        {
            List<MovieTo> movies = movieService.getAllMovies();
            json = JSONConverter.toJSON(movies);
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(errorMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(media, json);
    }

    @POST
    @Propagate
    @Description(value = "Method to post a movie")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response postMovie ( @FormParam("movie") String movieJson )
    {
        String json = null;
        try
        {
            MovieTo movieTo = (MovieTo) JSONConverter.fromJSON(movieJson, MovieTo.class);
            MovieTo savedMovieTo = movieService.save(movieTo);
            json = JSONConverter.toJSON(savedMovieTo);
        } catch (Throwable e)
        {
            return responseBuilder.buildResponse(errorMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(media, json);
    }

}
