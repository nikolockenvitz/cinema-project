package com.fallstudie.cinemasystem.common.transferobject;

public class ShowTo
{
    private long   id;
    private String date;
    private String time;
    private String weekday;
//    private List<TicketTo> tickets;
    private MovieTo movie;
    private HallTo  hall;
    private boolean is3D;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getDate ( )
    {
        return date;
    }

    public void setDate ( String date )
    {
        this.date = date;
    }

    public String getTime ( )
    {
        return time;
    }

    public void setTime ( String time )
    {
        this.time = time;
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

    public String getWeekday ( )
    {
        return weekday;
    }

    public void setWeekday ( String weekday )
    {
        this.weekday = weekday;
    }

}
