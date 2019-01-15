package com.fallstudie.cinemasystem.common.transferobject;

import java.util.Date;
import java.util.List;

public class ShowTo
{
    private long           id;
    private Date           starttime;
    private List<TicketTo> tickets;
    private MovieTo        movie;
    private HallTo         hall;
    private boolean        is3D;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public Date getStarttime ( )
    {
        return starttime;
    }

    public void setStarttime ( Date starttime )
    {
        this.starttime = starttime;
    }

    public List<TicketTo> getTickets ( )
    {
        return tickets;
    }

    public void setTickets ( List<TicketTo> tickets )
    {
        this.tickets = tickets;
    }

    public MovieTo getMovie ( )
    {
        return movie;
    }

    public void setMovie ( MovieTo movie )
    {
        this.movie = movie;
    }

    public HallTo getHall ( )
    {
        return hall;
    }

    public void setHall ( HallTo hall )
    {
        this.hall = hall;
    }

    public boolean is3D ( )
    {
        return is3D;
    }

    public void setIs3D ( boolean is3d )
    {
        is3D = is3d;
    }

}
