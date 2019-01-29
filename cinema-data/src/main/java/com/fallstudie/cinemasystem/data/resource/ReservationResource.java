package com.fallstudie.cinemasystem.data.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.fallstudie.cinemasystem.common.transferobject.BookingTo;
import com.fallstudie.cinemasystem.common.transferobject.CustomerTo;
import com.fallstudie.cinemasystem.common.transferobject.ReservationTo;
import com.fallstudie.cinemasystem.common.transferobject.SeatTo;
import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.common.transferobject.TicketTo;
import com.fallstudie.cinemasystem.common.utils.Utils;
import com.fallstudie.cinemasystem.data.service.CustomerService;
import com.fallstudie.cinemasystem.data.service.ReservationService;
import com.fallstudie.cinemasystem.data.service.SeatService;
import com.fallstudie.cinemasystem.data.service.ShowService;

@Path("/reservation")
public class ReservationResource
{

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationResource.class);

    private static final MediaType textMedia = MediaType.TEXT_PLAIN_TYPE;

    private static final MediaType jsonMedia = MediaType.APPLICATION_JSON_TYPE;

    private ShowService        showService;
    private ReservationService reservationService;
    private SeatService        seatService;
    private CustomerService    customerService;

    private ResponseBuilder responseBuilder;

    public ReservationResource( )
    {
        this.showService = new ShowService();
        this.reservationService = new ReservationService();
        this.responseBuilder = new ResponseBuilder();
        this.seatService = new SeatService();
        this.customerService = new CustomerService();
    }

    @GET
    @Path("{id}")
    @Propagate
    @Description(value = "Method to get a reservation by id!")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response getReservationByID ( @PathParam("id") String id )
    {
        String json = null;
        try
        {
            ReservationTo showTo = reservationService.getReservation(id);
            json = JSONConverter.toJSON(showTo);
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
            ReservationTo createdReservation = new ReservationTo();

            if ( Utils.checkIfShowIsReservable(showTo) )
            {
                // TODO CHECK IF CUSTOMER Exists if not persist
                CustomerTo customerTo = customerService.getCustomerByEmail(bookingTo.getCustomer().getEmail());

                List<TicketTo> ticketTos = showService.getAllTicketsForShow(showId);

                List<SeatTo> seatTos = new ArrayList<>();

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
                    reservationTo.setDateOfReservation(Utils.convertDateToString(new Date()));
                    reservationTo.setTickets(toBook);
                    reservationTo.setCustomer(customerTo);

                    createdReservation = reservationService.createReservation((reservationTo));
                }

            }

            json = JSONConverter.toJSON(createdReservation);
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(textMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(jsonMedia, json);
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
            return responseBuilder.buildResponse(textMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(jsonMedia, json);
    }

    @POST
    @Path("block")
    @Propagate
    @Description(value = "Method to book seats for a show by its id!")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response blockseat ( @FormParam("block") String json )
    {
        try
        {
            BlockTo bookingTo = (BlockTo) JSONConverter.fromJSON(json, BlockTo.class);
            String showId = String.valueOf(bookingTo.getShow().getId());
            ShowTo showTo = showService.getShow(showId);
            String seatId = String.valueOf(bookingTo.getSeat().getId());
            SeatTo seatTo = seatService.getSeat(seatId);
            bookingTo.setShow(showTo);
            bookingTo.setSeat(seatTo);

            BlockTo createdBlockTo = reservationService.blockSeat(bookingTo);

            json = JSONConverter.toJSON(createdBlockTo);
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(textMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(jsonMedia, json);
    }
}