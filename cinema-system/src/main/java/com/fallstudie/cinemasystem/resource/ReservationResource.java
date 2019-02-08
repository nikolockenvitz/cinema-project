package com.fallstudie.cinemasystem.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import com.fallstudie.cinemasystem.common.transferobject.BlockTo;
import com.fallstudie.cinemasystem.common.transferobject.BlockToWithSessiontoken;
import com.fallstudie.cinemasystem.common.transferobject.BookingToWithSessiontoken;
import com.fallstudie.cinemasystem.common.transferobject.ReservationTo;
import com.fallstudie.cinemasystem.service.ReservationService;

@Path("/reservation")
public class ReservationResource
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationResource.class);

    private static final MediaType errorMedia = MediaType.TEXT_PLAIN_TYPE;

    private static final MediaType media = MediaType.APPLICATION_JSON_TYPE;

    private ReservationService reservationService;

    private ResponseBuilder responseBuilder;

    public ReservationResource( )
    {
        this.reservationService = new ReservationService();
        this.responseBuilder = new ResponseBuilder();
    }

    @GET
    @Path("{id}")
    @Propagate
    @Description(value = "Method to get a reservation by id!")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response getReservationById ( @PathParam("id") String id )
    {
        String json = "";
        try
        {
            ReservationTo reservationTo = reservationService.getReservationById(id);
            json = JSONConverter.toJSON(reservationTo);
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(errorMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(media, json);
    }

    @POST
    @Path("book")
    @Propagate
    @Description(value = "Method to book seats for a show by its id!")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response postTickets ( @FormParam("book") String json )
    {
        try
        {
            BookingToWithSessiontoken bookingToWithSessiontoken = (BookingToWithSessiontoken) JSONConverter.fromJSON(json, BookingToWithSessiontoken.class);
            ReservationTo reservationTo = reservationService.createReservation(bookingToWithSessiontoken);
            json = JSONConverter.toJSON(reservationTo);
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(errorMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(media, json);
    }

    @DELETE
    @Path("delete/{id}")
    @Propagate
    @Description(value = "Method to delete a reservation by its id!")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response deleteReservationById ( @PathParam("id") String reservationId )
    {
        String json = null;
        try
        {
            ReservationTo deletedReservation = reservationService.deleteReservation(reservationId);
            json = JSONConverter.toJSON(deletedReservation);
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(errorMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(media, json);
    }

    @POST
    @Path("block")
    @Propagate
    @Description(value = "Method to block a seat for a show!")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response blockseat ( @FormParam("block") String json )
    {
        try
        {
            BlockToWithSessiontoken blockToWithSessiontoken = (BlockToWithSessiontoken) JSONConverter.fromJSON(json, BlockToWithSessiontoken.class);
            BlockTo createdBlockTo = reservationService.blockSeat(blockToWithSessiontoken);
            json = JSONConverter.toJSON(createdBlockTo);
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(errorMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(media, json);
    }

    @DELETE
    @Path("block")
    @Propagate
    @Description(value = "Method to deblock a seat for a show by showId, sessiontoken, seatId!")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response deblockseat ( @FormParam("block") String json )
    {
        try
        {
            BlockToWithSessiontoken blockToWithSessiontoken = (BlockToWithSessiontoken) JSONConverter.fromJSON(json, BlockToWithSessiontoken.class);

            BlockTo deletedBlockTo = reservationService.deblockSeat(blockToWithSessiontoken);

            json = JSONConverter.toJSON(deletedBlockTo);

        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(errorMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(media, json);
    }
}
