package com.fallstudie.kinobuchungssystem.common.transferobject;

public class RatingTo
{
    private long       id;
    private String     comment;
    private int        rating;
    private CustomerTo customer;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getComment ( )
    {
        return comment;
    }

    public void setComment ( String comment )
    {
        this.comment = comment;
    }

    public int getRating ( )
    {
        return rating;
    }

    public void setRating ( int rating )
    {
        this.rating = rating;
    }

    public CustomerTo getCustomer ( )
    {
        return customer;
    }

    public void setCustomer ( CustomerTo customer )
    {
        this.customer = customer;
    }

}
