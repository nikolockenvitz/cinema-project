package com.fallstudie.cinemasystem.common.transferobject;

public class SeatTo
{
    private long       id;
    private int        number;
    private String     row;
    private HallTo     hall;
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

    public int getNumber ( )
    {
        return number;
    }

    public void setNumber ( int number )
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

    public HallTo getHall ( )
    {
        return hall;
    }

    public void setHall ( HallTo hall )
    {
        this.hall = hall;
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

    public void setBlocked ( boolean isBlocked )
    {
        this.isBlocked = isBlocked;
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
