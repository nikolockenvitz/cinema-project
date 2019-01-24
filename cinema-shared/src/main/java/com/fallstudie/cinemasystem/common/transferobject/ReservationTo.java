package com.fallstudie.cinemasystem.common.transferobject;

import java.util.Date;

public class ReservationTo
{
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

    private long       id;
    private Date       dateOfReservation;
    private CustomerTo customer;

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

}
