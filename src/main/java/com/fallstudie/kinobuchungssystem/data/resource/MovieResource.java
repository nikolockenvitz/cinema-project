package com.fallstudie.kinobuchungssystem.data.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.kinobuchungssystem.common.annotation.Description;
import com.fallstudie.kinobuchungssystem.common.annotation.Propagate;
import com.fallstudie.kinobuchungssystem.common.json.JSONConverter;
import com.fallstudie.kinobuchungssystem.common.responsebuilder.ResponseBuilder;
import com.fallstudie.kinobuchungssystem.common.transferobject.MovieTo;
import com.fallstudie.kinobuchungssystem.common.transferobject.TicketTo;
import com.fallstudie.kinobuchungssystem.data.service.MovieService;

@Path("/movie")
public class MovieResource
{

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieResource.class);

    private static final MediaType textMedia = MediaType.TEXT_PLAIN_TYPE;

    private static final MediaType jsonMedia = MediaType.APPLICATION_JSON_TYPE;

    private MovieService movieService;

    private ResponseBuilder responseBuilder;

    private static ModelMapper modelMapper = new ModelMapper();

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
    public Response getMovieByID ( @PathParam("id") String id )
    {
        String json = null;
        try
        {
            MovieTo movieTo = movieService.getMovie(id);
            json = JSONConverter.toJSON(movieTo);
        } catch (Throwable e)
        {
            return responseBuilder.buildResponse(textMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(jsonMedia, json);
    }

    @GET
    @Path("getAllMovies")
    @Propagate
    @Description(value = "Method to get all movies!")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response getAllMovies ( )
    {
        String json = null;
        try
        {
            List<MovieTo> movieTos = movieService.getAllMovies();
            json = JSONConverter.toJSON(movieTos);
        } catch (Throwable e)
        {
            return responseBuilder.buildResponse(textMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(jsonMedia, json);
    }

    @GET
    @Path("getAllTickets")
    @Propagate
    @Description(value = "Method to get all tickets!")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response getAllTickets ( )
    {
        String json = null;
        try
        {
            List<TicketTo> ticketTos = movieService.getAllTickets();
            json = JSONConverter.toJSON(ticketTos);
        } catch (Throwable e)
        {
            return responseBuilder.buildResponse(textMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(jsonMedia, json);
    }

}
