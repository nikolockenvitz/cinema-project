package com.fallstudie.kinobuchungssystem.common.transferobject;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class ActorTo
{
    private long          id;
    private String        firstname;
    private String        lastname;
    private Date          birthdate;
    @JsonManagedReference
    private List<MovieTo> movies;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getFirstname ( )
    {
        return firstname;
    }

    public void setFirstname ( String firstname )
    {
        this.firstname = firstname;
    }

    public String getLastname ( )
    {
        return lastname;
    }

    public void setLastname ( String lastname )
    {
        this.lastname = lastname;
    }

    public Date getBirthdate ( )
    {
        return birthdate;
    }

    public void setBirthdate ( Date birthdate )
    {
        this.birthdate = birthdate;
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
