package com.fallstudie.kinobuchungssystem.common.transferobject;

import java.util.List;

public class MovieTo
{
    private long           id;
    private String         description;
    private int            duration;
    private int            fsk;
    private String         name;
    private long           length;
    private List<ActorTo>  actors;
    private GenreTo        genre;
    private List<ShowTo>   shows;
    private List<RatingTo> ratings;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getDescription ( )
    {
        return description;
    }

    public void setDescription ( String description )
    {
        this.description = description;
    }

    public int getDuration ( )
    {
        return duration;
    }

    public void setDuration ( int duration )
    {
        this.duration = duration;
    }

    public int getFsk ( )
    {
        return fsk;
    }

    public void setFsk ( int fsk )
    {
        this.fsk = fsk;
    }

    public String getName ( )
    {
        return name;
    }

    public void setName ( String name )
    {
        this.name = name;
    }

    public long getLength ( )
    {
        return length;
    }

    public void setLength ( long length )
    {
        this.length = length;
    }

    public List<ActorTo> getActors ( )
    {
        return actors;
    }

    public void setActors ( List<ActorTo> actors )
    {
        this.actors = actors;
    }

    public GenreTo getGenre ( )
    {
        return genre;
    }

    public void setGenre ( GenreTo genre )
    {
        this.genre = genre;
    }

    public List<ShowTo> getShows ( )
    {
        return shows;
    }

    public void setShows ( List<ShowTo> shows )
    {
        this.shows = shows;
    }

    public List<RatingTo> getRatings ( )
    {
        return ratings;
    }

    public void setRatings ( List<RatingTo> ratings )
    {
        this.ratings = ratings;
    }

}