package com.fallstudie.kinobuchungssystem.common.transferobject;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference(alwaysAsId = false)
public class ReservationTo
{
    private long           id;
    private Date           dateOfReservation;
    private ShowTo         show;
    private List<TicketTo> tickets;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public Date getDateOfReservation ( )
    {
        return dateOfReservation;
    }

    public void setDateOfReservation ( Date dateOfReservation )
    {
        this.dateOfReservation = dateOfReservation;
    }

    public ShowTo getShow ( )
    {
        return show;
    }

    public void setShow ( ShowTo show )
    {
        this.show = show;
    }

    public List<TicketTo> getTickets ( )
    {
        return tickets;
    }

    public void setTickets ( List<TicketTo> tickets )
    {
        this.tickets = tickets;
    }

}
