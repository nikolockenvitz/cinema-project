package com.fallstudie.kinobuchungssystem.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the movie database table.
 * 
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "movie")
@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m")
public class Movie implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "MOVIE_ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIE_ID_GENERATOR")
    private long   id;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "duration")
    private int    duration;
    @Column(name = "fsk")
    private int    fsk;
    @Column(name = "length")
    private int    length;
    @Column(name = "name", columnDefinition = "VARCHAR(40)")
    private String name;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-many association to Actor
    @ManyToMany(mappedBy = "movies", targetEntity = Actor.class)
    private List<Actor> actors;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-one association to Genre
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Genre.class)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-one association to Show
    @OneToMany(mappedBy = "movie", targetEntity = Show.class)
    private List<Show> shows;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional one-to-one association to Rating
    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, targetEntity = Rating.class)
    private List<Rating> ratings;

    public Movie( )
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

    public String getDescription ( )
    {
        return this.description;
    }

    public void setDescription ( String description )
    {
        this.description = description;
    }

    public int getDuration ( )
    {
        return this.duration;
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

    public List<Actor> getActors ( )
    {
        return actors;
    }

    public void setActors ( List<Actor> actors )
    {
        this.actors = actors;
    }

    public Genre getGenre ( )
    {
        return genre;
    }

    public void setGenre ( Genre genre )
    {
        this.genre = genre;
    }

    public List<Show> getShows ( )
    {
        return shows;
    }

    public void setShows ( List<Show> shows )
    {
        this.shows = shows;
    }

    public List<Rating> getRatings ( )
    {
        return ratings;
    }

    public void setRatings ( List<Rating> ratings )
    {
        this.ratings = ratings;
    }

}