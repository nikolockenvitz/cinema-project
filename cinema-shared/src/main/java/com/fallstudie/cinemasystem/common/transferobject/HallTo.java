package com.fallstudie.cinemasystem.common.transferobject;

import java.util.List;

public class HallTo
{
    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + length;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((seats == null) ? 0 : seats.hashCode());
        result = prime * result + width;
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
        HallTo other = (HallTo) obj;
        if ( id != other.id )
            return false;
        if ( length != other.length )
            return false;
        if ( name == null )
        {
            if ( other.name != null )
                return false;
        } else if ( !name.equals(other.name) )
            return false;
        if ( seats == null )
        {
            if ( other.seats != null )
                return false;
        } else if ( !seats.equals(other.seats) )
            return false;
        if ( width != other.width )
            return false;
        return true;
    }

    private long         id;
    private String       name;
    private int          width;
    private int          length;
    private List<SeatTo> seats;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getName ( )
    {
        return name;
    }

    public void setName ( String name )
    {
        this.name = name;
    }

    public int getWidth ( )
    {
        return width;
    }

    public void setWidth ( int width )
    {
        this.width = width;
    }

    public int getLength ( )
    {
        return length;
    }

    public void setLength ( int length )
    {
        this.length = length;
    }

    public List<SeatTo> getSeats ( )
    {
        return seats;
    }

    public void setSeats ( List<SeatTo> seats )
    {
        this.seats = seats;
    }

}
