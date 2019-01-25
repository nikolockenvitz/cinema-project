package com.fallstudie.cinemasystem.common.transferobject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MovieTo
{
    private long           id;
    private String         description;
    private int            duration;
    private int            fsk;
    private String         name;
    private List<ActorTo>  actors;
    private List<GenreTo>  genres;
    @JsonInclude(JsonInclude.Include.NON_NULL)
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

    public List<ActorTo> getActors ( )
    {
        return actors;
    }

    public void setActors ( List<ActorTo> actors )
    {
        this.actors = actors;
    }

    public List<GenreTo> getGenres ( )
    {
        return genres;
    }

    public void setGenres ( List<GenreTo> genres )
    {
        this.genres = genres;
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

    public ShowTo addShow ( ShowTo showTo )
    {
        getShows().add(showTo);
        showTo.setMovie(this);
        return showTo;
    }

    public ShowTo removeShow ( ShowTo showTo )
    {
        getShows().remove(showTo);
        showTo.setMovie(null);
        return showTo;
    }

}