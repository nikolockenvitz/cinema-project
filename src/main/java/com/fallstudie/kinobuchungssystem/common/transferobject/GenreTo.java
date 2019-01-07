package com.fallstudie.kinobuchungssystem.common.transferobject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GenreTo.class)
public class GenreTo
{
    private long          id;
    private String        genre;
    private List<MovieTo> movies;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getGenre ( )
    {
        return genre;
    }

    public void setGenre ( String genre )
    {
        this.genre = genre;
    }

    public List<MovieTo> getMovies ( )
    {
        return movies;
    }

    public void setMovies ( List<MovieTo> movies )
    {
        this.movies = movies;
    }

}
