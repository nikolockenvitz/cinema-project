package com.fallstudie.kinobuchungssystem.common.transferobject;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference(alwaysAsId = false)
public class SeatTo
{
    private long          id;
    private int           row;
    private int           number;
    private CategoryTo    category;
    private HallTo        hall;
    private TicketTo      ticket;
    private ReservationTo reservation;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public int getRow ( )
    {
        return row;
    }

    public void setRow ( int row )
    {
        this.row = row;
    }

    public int getNumber ( )
    {
        return number;
    }

    public void setNumber ( int number )
    {
        this.number = number;
    }

    public CategoryTo getCategory ( )
    {
        return category;
    }

    public void setCategory ( CategoryTo category )
    {
        this.category = category;
    }

    public HallTo getHall ( )
    {
        return hall;
    }

    public void setHall ( HallTo hall )
    {
        this.hall = hall;
    }

    public TicketTo getTicket ( )
    {
        return ticket;
    }

    public void setTicket ( TicketTo ticket )
    {
        this.ticket = ticket;
    }

    public ReservationTo getReservation ( )
    {
        return reservation;
    }

    public void setReservation ( ReservationTo reservation )
    {
        this.reservation = reservation;
    }

}
