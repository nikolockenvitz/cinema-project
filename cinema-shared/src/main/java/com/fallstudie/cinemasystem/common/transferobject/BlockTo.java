package com.fallstudie.cinemasystem.common.transferobject;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlockTo
{
    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((seat == null) ? 0 : seat.hashCode());
        result = prime * result + ((sessiontoken == null) ? 0 : sessiontoken.hashCode());
        result = prime * result + ((show == null) ? 0 : show.hashCode());
        result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
        BlockTo other = (BlockTo) obj;
        if ( id != other.id )
            return false;
        if ( seat == null )
        {
            if ( other.seat != null )
                return false;
        } else if ( !seat.equals(other.seat) )
            return false;
        if ( sessiontoken == null )
        {
            if ( other.sessiontoken != null )
                return false;
        } else if ( !sessiontoken.equals(other.sessiontoken) )
            return false;
        if ( show == null )
        {
            if ( other.show != null )
                return false;
        } else if ( !show.equals(other.show) )
            return false;
        if ( timestamp == null )
        {
            if ( other.timestamp != null )
                return false;
        } else if ( !timestamp.equals(other.timestamp) )
            return false;
        return true;
    }

    private long   id;
    private SeatTo seat;
    private ShowTo show;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String sessiontoken;
//    private CustomerTo customer;
    private Date timestamp;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public SeatTo getSeat ( )
    {
        return seat;
    }

    public void setSeat ( SeatTo seat )
    {
        this.seat = seat;
    }

    public ShowTo getShow ( )
    {
        return show;
    }

    public void setShow ( ShowTo show )
    {
        this.show = show;
    }

    public Date getTimestamp ( )
    {
        return timestamp;
    }

    public void setTimestamp ( Date timestamp )
    {
        this.timestamp = timestamp;
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
