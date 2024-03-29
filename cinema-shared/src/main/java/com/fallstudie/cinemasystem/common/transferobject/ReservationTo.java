package com.fallstudie.cinemasystem.common.transferobject;

import java.util.List;

public class ReservationTo
{
    private long           id;
    private String         dateOfReservation;
    private CustomerTo     customer;
    private List<TicketTo> tickets;

    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + ((dateOfReservation == null) ? 0 : dateOfReservation.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals ( Object obj )
    {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        ReservationTo other = (ReservationTo) obj;
        if ( customer == null )
        {
            if ( other.customer != null )
                return false;
        } else if ( !customer.equals(other.customer) )
            return false;
        if ( dateOfReservation == null )
        {
            if ( other.dateOfReservation != null )
                return false;
        } else if ( !dateOfReservation.equals(other.dateOfReservation) )
            return false;
        if ( id != other.id )
            return false;
        return true;
    }

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getDateOfReservation ( )
    {
        return dateOfReservation;
    }

    public void setDateOfReservation ( String dateOfReservation )
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
