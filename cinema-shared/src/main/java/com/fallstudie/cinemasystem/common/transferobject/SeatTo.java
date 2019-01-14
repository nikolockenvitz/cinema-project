package com.fallstudie.cinemasystem.common.transferobject;

public class SeatTo
{
    private long       id;
    private int        number;
    private String     row;
    private HallTo     hall;
    private CategoryTo category;

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

}
