package com.fallstudie.cinemasystem.common.transferobject;

import java.util.Date;

public class BlockToWithSessiontoken
{
    private long   id;
    private SeatTo seat;
    private ShowTo show;
    private String sessiontoken;
    private Date   timestamp;

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
