package com.fallstudie.cinemasystem.data.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.common.transferobject.TicketTo;
import com.fallstudie.cinemasystem.common.utils.Utils;
import com.fallstudie.cinemasystem.data.service.ReservationService;
import com.fallstudie.cinemasystem.data.service.ShowService;

@Path("/show")
public class ShowResource
{

    private static final Logger LOGGER = LoggerFactory.getLogger(ShowResource.class);

    private static final MediaType textMedia = MediaType.TEXT_PLAIN_TYPE;

    private static final MediaType jsonMedia = MediaType.APPLICATION_JSON_TYPE;

    private ShowService        showService;
    private ReservationService reservationService;

    private ResponseBuilder responseBuilder;

    public ShowResource( )
    {
        this.showService = new ShowService();
        this.reservationService = new ReservationService();
        this.responseBuilder = new ResponseBuilder();
    }

    @GET
    @Path("{id}")
    @Propagate
    @Description(value = "Method to get a show by id!")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response getShowByID ( @PathParam("id") String id )
    {
        String json = null;
        try
        {
            ShowTo showTo = showService.getShow(id);
            List<TicketTo> ticketTos = showService.getAllTicketsForShow(id);
            Utils.checkIfSeatIsOccupied(showTo, ticketTos);
            json = JSONConverter.toJSON(showTo);
        } catch (Throwable e)
        {
            return responseBuilder.buildResponse(textMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(jsonMedia, json);
    }

    @GET
    @Path("getAllShows/{id}")
    @Propagate
    @Description(value = "Method to get all shows by movie id!")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response getAllShowsByMovieID ( @PathParam("id") String id )
    {
        String json = null;
        try
        {
            List<ShowTo> showTos = showService.getAllShowsByMovieId(id);
            json = JSONConverter.toJSON(showTos);
        } catch (Throwable e)
        {
            return responseBuilder.buildResponse(textMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(jsonMedia, json);
    }

}
