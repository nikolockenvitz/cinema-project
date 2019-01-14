package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the genre database table.
 * 
 */
@Entity
@NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g")
public class Genre implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "GENRE_ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENRE_ID_GENERATOR")
    private long id;

    private String genre;

    // bi-directional many-to-one association to Movie
    @OneToMany(mappedBy = "genre")
    private List<Movie> movies;

    public Genre( )
    {
    }

    public long getId ( )
    {
        return this.id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getGenre ( )
    {
        return this.genre;
    }

    public void setGenre ( String genre )
    {
        this.genre = genre;
    }

}