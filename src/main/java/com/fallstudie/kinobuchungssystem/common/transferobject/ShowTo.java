package com.fallstudie.kinobuchungssystem.common.transferobject;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class ShowTo
{
    private long                id;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Date                starttime;
    private List<ReservationTo> reservations;
    private List<TicketTo>      tickets;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private MovieTo             movie;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public Date getStarttime ( )
    {
        return starttime;
    }

    public void setStarttime ( Date starttime )
    {
        this.starttime = starttime;
    }

    public List<ReservationTo> getReservations ( )
    {
        return reservations;
    }

    public void setReservations ( List<ReservationTo> reservations )
    {
        this.reservations = reservations;
    }

    public List<TicketTo> getTickets ( )
    {
        return tickets;
    }

    public void setTickets ( List<TicketTo> tickets )
    {
        this.tickets = tickets;
    }

    public MovieTo getMovie ( )
    {
        return movie;
    }

    public void setMovie ( MovieTo movie )
    {
        this.movie = movie;
    }

}
