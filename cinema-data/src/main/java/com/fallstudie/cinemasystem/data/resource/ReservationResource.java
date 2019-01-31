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
            boolean bookable = true;

            if ( Utils.checkIfShowIsReservable(showTo.getDate(), showTo.getTime()) )
            {
                CustomerTo customerTo = customerService.checkIfCustomerExistsIfNotPersist(bookingTo.getCustomer());

                List<TicketTo> ticketTos = showService.getAllTicketsForShow(showId);
                List<BlockTo> blockTos = reservationService.getBlockedSeats(showId);

                List<SeatTo> seatTos = checkIfSeatsAreBookable(bookable, bookingTo.getSeats(), ticketTos, blockTos, bookingTo.getSessiontoken());

                if ( bookable )
                {
                    ReservationTo reservationTo = createReservationForSeats(seatTos, showTo);
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

    private ReservationTo createReservationForSeats ( List<SeatTo> seatTos, ShowTo showTo )
    {
        List<TicketTo> toBook = new ArrayList<>();
        ReservationTo createdReservationTo = new ReservationTo();

        for ( SeatTo seatTo : seatTos )
        {
            seatTo.setOccupied(true);

            TicketTo ticketTo = new TicketTo();
            ticketTo.setSeat(seatTo);
            ticketTo.setShow(showTo);
            ticketTo.setReservation(createdReservationTo);
            if ( seatTo.isReducedPrice() )
            {
                ticketTo.setReducedPrice(true);
            }
            toBook.add(ticketTo);
        }
        createdReservationTo.setDateOfReservation(Utils.convertDateToString(new Date()));
        createdReservationTo.setTickets(toBook);
        return createdReservationTo;

    }

    private List<SeatTo> checkIfSeatsAreBookable ( boolean bookable, List<SeatTo> seatsToProof, List<TicketTo> bookedTicketTos, List<BlockTo> blockTos,
            String sessiontoken )
    {
        List<SeatTo> seatsToBook = new ArrayList<>();
        for ( SeatTo s : seatsToProof )
        {
            for ( TicketTo t : bookedTicketTos )
            {
                if ( s.getId() == t.getSeat().getId() )
                {
                    bookable = false;
                    break;
                } else
                {
                    s.setOccupied(true);
                }
            }
            for ( BlockTo b : blockTos )
            {
                if ( s.getId() == b.getSeat().getId() && !(b.getSessiontoken().equals(sessiontoken)) )
                {
                    bookable = false;
                    break;
                } else
                {
                    s.setBlocked(true);
                }
            }
            seatsToBook.add(s);
        }
        return seatsToBook;
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
    @Description(value = "Method to block a seat for a show!")
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

            // delete elements older than 5 minutes
            List<BlockTo> blockTos = reservationService.deleteBlockedElements();

            // deblock seat
            BlockTo deblockedSeat = reservationService.deblockSeatIfExists(seatTo.getId(), showTo.getId(), bookingTo.getSessiontoken());

            // block seat
            BlockTo createdBlockTo = reservationService.blockSeat(bookingTo);

            json = JSONConverter.toJSON(createdBlockTo);
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(textMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(jsonMedia, json);
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
            BlockTo bookingTo = (BlockTo) JSONConverter.fromJSON(json, BlockTo.class);

            BlockTo deletedBlockTo = reservationService.deblockSeat(bookingTo.getSeat().getId(), bookingTo.getShow().getId(), bookingTo.getSessiontoken());

            json = JSONConverter.toJSON(deletedBlockTo);

        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(textMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(jsonMedia, json);
    }
}
