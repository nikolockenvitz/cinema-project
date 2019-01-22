package com.fallstudie.cinemasystem.common.transferobject;

import java.util.List;

public class BookingTo
{
    private long         id;
    private long         showId;
    private List<SeatTo> seats;
    private CustomerTo   customer;
    private String       paymentoption;
    private String       verification;

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

}
