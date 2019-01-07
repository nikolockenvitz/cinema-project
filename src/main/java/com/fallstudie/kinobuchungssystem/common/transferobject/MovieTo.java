package com.fallstudie.kinobuchungssystem.common.transferobject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class MovieTo
{
    private long           id;
    private String         description;
    private int            duration;
    private int            fsk;
    private int            length;
    private String         name;
    private List<ShowTo>   shows;
    private List<RatingTo> ratings;
    private GenreTo        genre;
    private List<ActorTo>  actors;

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

    public int getLength ( )
    {
        return length;
    }

    public void setLength ( int length )
    {
        this.length = length;
    }

    public String getName ( )
    {
        return name;
    }

    public void setName ( String name )
    {
        this.name = name;
    }

    public List<ActorTo> getActors ( )
    {
        return actors;
    }

    public void setActors ( List<ActorTo> actors )
    {
        this.actors = actors;
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

    public GenreTo getGenre ( )
    {
        return genre;
    }

    public void setGenre ( GenreTo genre )
    {
        this.genre = genre;
    }

}