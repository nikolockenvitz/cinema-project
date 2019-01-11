package com.fallstudie.kinobuchungssystem.common.transferobject;

import java.util.Date;

public class ReservationTo
{
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
