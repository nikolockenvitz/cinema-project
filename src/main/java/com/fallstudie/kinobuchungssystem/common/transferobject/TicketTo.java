package com.fallstudie.kinobuchungssystem.common.transferobject;

public class TicketTo
{
    private long          id;
    private boolean       isReducedPrice;
    private ShowTo        show;
    private SeatTo        seat;
    private ReservationTo reservation;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public boolean isReducedPrice ( )
    {
        return isReducedPrice;
    }

    public void setReducedPrice ( boolean isReducedPrice )
    {
        this.isReducedPrice = isReducedPrice;
    }

    public ShowTo getShow ( )
    {
        return show;
    }

    public void setShow ( ShowTo show )
    {
        this.show = show;
    }

    public ReservationTo getReservation ( )
    {
        return reservation;
    }

    public void setReservation ( ReservationTo reservation )
    {
        this.reservation = reservation;
    }

    public SeatTo getSeat ( )
    {
        return seat;
    }

    public void setSeat ( SeatTo seat )
    {
        this.seat = seat;
    }

}
