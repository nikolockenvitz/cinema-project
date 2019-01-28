package com.fallstudie.cinemasystem.common.transferobject;

import java.util.List;

import com.fallstudie.cinemasystem.common.utils.Utils;

public class SeatTo
{
    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + (isBlocked ? 1231 : 1237);
        result = prime * result + (isOccupied ? 1231 : 1237);
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((row == null) ? 0 : row.hashCode());
        result = prime * result + x;
        result = prime * result + y;
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
        SeatTo other = (SeatTo) obj;
        if ( category == null )
        {
            if ( other.category != null )
                return false;
        } else if ( !category.equals(other.category) )
            return false;
        if ( id != other.id )
            return false;
        if ( isBlocked != other.isBlocked )
            return false;
        if ( isOccupied != other.isOccupied )
            return false;
        if ( number == null )
        {
            if ( other.number != null )
                return false;
        } else if ( !number.equals(other.number) )
            return false;
        if ( price == null )
        {
            if ( other.price != null )
                return false;
        } else if ( !price.equals(other.price) )
            return false;
        if ( row == null )
        {
            if ( other.row != null )
                return false;
        } else if ( !row.equals(other.row) )
            return false;
        if ( x != other.x )
            return false;
        if ( y != other.y )
            return false;
        return true;
    }

    private long       id;
    private String     number;
    private String     row;
    private CategoryTo category;
    private PriceTo    price;
    private boolean    isBlocked;
    private boolean    isOccupied;
    private int        x;
    private int        y;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getNumber ( )
    {
        return number;
    }

    public void setNumber ( String number )
    {
        this.number = number;
    }

    public String getRow ( )
    {
        return row;
    }

    public void setRow ( String row )
    {
        this.row = row;
    }

    public CategoryTo getCategory ( )
    {
        return category;
    }

    public void setCategory ( CategoryTo category )
    {
        this.category = category;
    }

    public PriceTo getPrice ( )
    {
        return price;
    }

    public void setPrice ( PriceTo price )
    {
        this.price = price;
    }

    public boolean isBlocked ( )
    {
        return isBlocked;
    }

    public void setBlocked ( List<TicketTo> tickets, long seatId )
    {
        this.isBlocked = Utils.checkIfSeatIsBlocked(tickets, seatId);
    }

    public boolean isOccupied ( )
    {
        return isOccupied;
    }

    public void setOccupied ( boolean isOccupied )
    {
        this.isOccupied = isOccupied;
    }

    public int getX ( )
    {
        return x;
    }

    public void setX ( int x )
    {
        this.x = x;
    }

    public int getY ( )
    {
        return y;
    }

    public void setY ( int y )
    {
        this.y = y;
    }

}
