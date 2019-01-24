package com.fallstudie.cinemasystem.common.transferobject;

public class RatingTo
{
    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + rating;
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
        RatingTo other = (RatingTo) obj;
        if ( comment == null )
        {
            if ( other.comment != null )
                return false;
        } else if ( !comment.equals(other.comment) )
            return false;
        if ( customer == null )
        {
            if ( other.customer != null )
                return false;
        } else if ( !customer.equals(other.customer) )
            return false;
        if ( id != other.id )
            return false;
        if ( rating != other.rating )
            return false;
        return true;
    }

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
