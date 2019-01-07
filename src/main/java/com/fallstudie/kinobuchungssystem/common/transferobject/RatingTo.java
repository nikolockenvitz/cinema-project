package com.fallstudie.kinobuchungssystem.common.transferobject;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference(alwaysAsId = false)
public class RatingTo
{
    private long    id;
    private String  comment;
    private int     rating;
    private UserTo  user;
    private MovieTo movie;

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

    public UserTo getUser ( )
    {
        return user;
    }

    public void setUser ( UserTo user )
    {
        this.user = user;
    }

    public MovieTo getMovie ( )
    {
        return movie;
    }

    public void setMovie ( MovieTo movie )
    {
        this.movie = movie;
    }

}
