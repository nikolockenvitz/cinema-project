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

    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((actors == null) ? 0 : actors.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + duration;
        result = prime * result + fsk;
        result = prime * result + ((genres == null) ? 0 : genres.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((ratings == null) ? 0 : ratings.hashCode());
        result = prime * result + ((shows == null) ? 0 : shows.hashCode());
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
        MovieTo other = (MovieTo) obj;
        if ( actors == null )
        {
            if ( other.actors != null )
                return false;
        } else if ( !actors.equals(other.actors) )
            return false;
        if ( description == null )
        {
            if ( other.description != null )
                return false;
        } else if ( !description.equals(other.description) )
            return false;
        if ( duration != other.duration )
            return false;
        if ( fsk != other.fsk )
            return false;
        if ( genres == null )
        {
            if ( other.genres != null )
                return false;
        } else if ( !genres.equals(other.genres) )
            return false;
        if ( id != other.id )
            return false;
        if ( name == null )
        {
            if ( other.name != null )
                return false;
        } else if ( !name.equals(other.name) )
            return false;
        if ( ratings == null )
        {
            if ( other.ratings != null )
                return false;
        } else if ( !ratings.equals(other.ratings) )
            return false;
        if ( shows == null )
        {
            if ( other.shows != null )
                return false;
        } else if ( !shows.equals(other.shows) )
            return false;
        return true;
    }
}