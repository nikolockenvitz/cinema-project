package com.fallstudie.cinemasystem.common.transferobject;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlockTo
{
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
