package com.fallstudie.cinemasystem.common.transferobject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingTo
{
    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((paymentoption == null) ? 0 : paymentoption.hashCode());
        result = prime * result + ((seats == null) ? 0 : seats.hashCode());
        result = prime * result + (int) (showId ^ (showId >>> 32));
        result = prime * result + ((verification == null) ? 0 : verification.hashCode());
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
        BookingTo other = (BookingTo) obj;
        if ( customer == null )
        {
            if ( other.customer != null )
                return false;
        } else if ( !customer.equals(other.customer) )
            return false;
        if ( id != other.id )
            return false;
        if ( paymentoption == null )
        {
            if ( other.paymentoption != null )
                return false;
        } else if ( !paymentoption.equals(other.paymentoption) )
            return false;
        if ( seats == null )
        {
            if ( other.seats != null )
                return false;
        } else if ( !seats.equals(other.seats) )
            return false;
        if ( showId != other.showId )
            return false;
        if ( verification == null )
        {
            if ( other.verification != null )
                return false;
        } else if ( !verification.equals(other.verification) )
            return false;
        return true;
    }

    private long         id;
    private long         showId;
    private List<SeatTo> seats;
    private CustomerTo   customer;
    private String       paymentoption;
    private String       verification;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String       sessiontoken;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public long getShowId ( )
    {
        return showId;
    }

    public void setShowId ( long showId )
    {
        this.showId = showId;
    }

    public List<SeatTo> getSeats ( )
    {
        return seats;
    }

    public void setSeats ( List<SeatTo> seats )
    {
        this.seats = seats;
    }

    public CustomerTo getCustomer ( )
    {
        return customer;
    }

    public void setCustomer ( CustomerTo customer )
    {
        this.customer = customer;
    }

    public String getPaymentoption ( )
    {
        return paymentoption;
    }

    public void setPaymentoption ( String paymentoption )
    {
        this.paymentoption = paymentoption;
    }

    public String getVerification ( )
    {
        return verification;
    }

    public void setVerification ( String verification )
    {
        this.verification = verification;
    }

    public String getSessiontoken ( )
    {
        return sessiontoken;
    }

    public void setSessiontoken ( String sessiontoken )
    {
        this.sessiontoken = sessiontoken;
    }

}
