package com.fallstudie.cinemasystem.common.transferobject;

import java.util.List;

public class BookingTo
{
    private long         id;
    private ShowTo       show;
    private List<SeatTo> seats;
    private CustomerTo   customer;
    private String       paymentoption;
    private boolean      ispayed;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public ShowTo getShow ( )
    {
        return show;
    }

    public void setShow ( ShowTo show )
    {
        this.show = show;
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

    public boolean isIspayed ( )
    {
        return ispayed;
    }

    public void setIspayed ( boolean ispayed )
    {
        this.ispayed = ispayed;
    }

}
