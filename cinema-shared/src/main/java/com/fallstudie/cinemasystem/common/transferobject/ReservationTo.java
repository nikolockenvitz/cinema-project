package com.fallstudie.cinemasystem.common.transferobject;

import java.util.Date;
import java.util.List;

public class ReservationTo
{
    private long           id;
    private Date           dateOfReservation;
    private CustomerTo     customer;
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

    public CustomerTo getCustomer ( )
    {
        return customer;
    }

    public void setCustomer ( CustomerTo customer )
    {
        this.customer = customer;
    }

    public List<TicketTo> getTickets ( )
    {
        return tickets;
    }

    public void setTickets ( List<TicketTo> tickets )
    {
        this.tickets = tickets;
    }

    public TicketTo addTicket ( TicketTo ticketTo )
    {
        getTickets().add(ticketTo);
        ticketTo.setReservation(this);
        return ticketTo;
    }

}
