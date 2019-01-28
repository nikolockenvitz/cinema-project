package com.fallstudie.cinemasystem.data.resource;

import java.util.ArrayList;
import java.util.Date;
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
import com.fallstudie.cinemasystem.common.transferobject.BookingTo;
import com.fallstudie.cinemasystem.common.transferobject.ReservationTo;
import com.fallstudie.cinemasystem.common.transferobject.SeatTo;
import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.common.transferobject.TicketTo;
import com.fallstudie.cinemasystem.common.utils.Utils;
import com.fallstudie.cinemasystem.data.service.ShowService;

@Path("/show")
public class ShowResource
{

    private static final Logger LOGGER = LoggerFactory.getLogger(ShowResource.class);

    private static final MediaType textMedia = MediaType.TEXT_PLAIN_TYPE;

    private static final MediaType jsonMedia = MediaType.APPLICATION_JSON_TYPE;

    private ShowService showService;

    private ResponseBuilder responseBuilder;

    public ShowResource( )
    {
        this.showService = new ShowService();
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
            BookingTo bookingTo = (BookingTo) JSONConverter.fromJSON(json, BookingTo.class);
            String showId = String.valueOf(bookingTo.getShowId());
            ShowTo showTo = showService.getShow(showId);
            List<TicketTo> ticketTos = showService.getAllTicketsForShow(showId);
            List<TicketTo> bookedTickets = new ArrayList<>();

            List<SeatTo> seatTos = new ArrayList<>();

            ReservationTo createdReservation = new ReservationTo();
            boolean bookable = true;
            for ( SeatTo seatTo : bookingTo.getSeats() )
            {
                for ( TicketTo ticketTo : ticketTos )
                {
                    if ( ticketTo.getSeat().getId() == seatTo.getId() )
                    {
                        bookable = false;
                        break;
                    }
                }
                if ( !bookable )
                {
                    break;
                }
                for ( SeatTo to : showTo.getHall().getSeats() )
                {
                    long seatIdHall = to.getId();
                    long test = seatTo.getId();
                    if ( seatIdHall == test )
                    {
                        seatTos.add(to);
                        break;
                    }
                }
            }

            List<TicketTo> toBook = new ArrayList<>();
            ReservationTo reservationTo = new ReservationTo();

            if ( bookable )
            {
                for ( SeatTo seatTo : seatTos )
                {
                    seatTo.setOccupied(true);

                    TicketTo ticketTo = new TicketTo();
                    ticketTo.setSeat(seatTo);
                    ticketTo.setShow(showTo);
                    ticketTo.setReservation(reservationTo);
                    toBook.add(ticketTo);
                }
//                bookedTickets = showService.bookShowTickets(toBook);
                reservationTo.setDateOfReservation(new Date());
                reservationTo.setTickets(toBook);

                createdReservation = showService.reservateAndBookTickets(reservationTo, bookingTo.getCustomer().getId());
            }

            json = JSONConverter.toJSON(createdReservation);
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(textMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(jsonMedia, json);
    }

}
