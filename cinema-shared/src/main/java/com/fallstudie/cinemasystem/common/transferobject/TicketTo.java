package com.fallstudie.cinemasystem.common.transferobject;

/**
 * @author Administrator
 *
 */
public class TicketTo
{
    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + (isReducedPrice ? 1231 : 1237);
        result = prime * result + ((reservation == null) ? 0 : reservation.hashCode());
        result = prime * result + ((seat == null) ? 0 : seat.hashCode());
        result = prime * result + ((show == null) ? 0 : show.hashCode());
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
        TicketTo other = (TicketTo) obj;
        if ( id != other.id )
            return false;
        if ( isReducedPrice != other.isReducedPrice )
            return false;
        if ( reservation == null )
        {
            if ( other.reservation != null )
                return false;
        } else if ( !reservation.equals(other.reservation) )
            return false;
        if ( seat == null )
        {
            if ( other.seat != null )
                return false;
        } else if ( !seat.equals(other.seat) )
            return false;
        if ( show == null )
        {
            if ( other.show != null )
                return false;
        } else if ( !show.equals(other.show) )
            return false;
        return true;
    }

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
