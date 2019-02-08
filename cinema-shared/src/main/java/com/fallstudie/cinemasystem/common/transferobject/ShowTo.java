package com.fallstudie.cinemasystem.common.transferobject;

public class ShowTo
{
    private long    id;
    private boolean showis3D;
    private String  date;
    private String  time;
    private String  weekday;
//    private List<TicketTo> tickets;
    private MovieTo movie;
    private HallTo  hall;

    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((hall == null) ? 0 : hall.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + (showis3D ? 1231 : 1237);
        result = prime * result + ((movie == null) ? 0 : movie.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        result = prime * result + ((weekday == null) ? 0 : weekday.hashCode());
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
        ShowTo other = (ShowTo) obj;
        if ( date == null )
        {
            if ( other.date != null )
                return false;
        } else if ( !date.equals(other.date) )
            return false;
        if ( hall == null )
        {
            if ( other.hall != null )
                return false;
        } else if ( !hall.equals(other.hall) )
            return false;
        if ( id != other.id )
            return false;
        if ( showis3D != other.showis3D )
            return false;
        if ( movie == null )
        {
            if ( other.movie != null )
                return false;
        } else if ( !movie.equals(other.movie) )
            return false;
        if ( time == null )
        {
            if ( other.time != null )
                return false;
        } else if ( !time.equals(other.time) )
            return false;
        if ( weekday == null )
        {
            if ( other.weekday != null )
                return false;
        } else if ( !weekday.equals(other.weekday) )
            return false;
        return true;
    }

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

    public boolean isShowIs3D ( )
    {
        return showis3D;
    }

    public void setShowIs3D ( boolean showIs3D )
    {
        this.showis3D = showIs3D;
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
