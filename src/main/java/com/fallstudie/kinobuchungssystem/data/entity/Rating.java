package com.fallstudie.kinobuchungssystem.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the rating database table.
 * 
 */
@Entity
@Table(name = "rating")
@NamedQuery(name = "Rating.findAll", query = "SELECT r FROM Rating r")
public class Rating implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "RATING_ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RATING_ID_GENERATOR")
    private long   id;
    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "rating")
    private int rating;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-many association to User
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional one-to-one association to Movie
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Movie.class)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Rating( )
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

    public User getUser ( )
    {
        return user;
    }

    public void setUser ( User user )
    {
        this.user = user;
    }

    public Movie getMovie ( )
    {
        return movie;
    }

    public void setMovie ( Movie movie )
    {
        this.movie = movie;
    }

}