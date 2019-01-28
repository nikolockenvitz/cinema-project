package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the movie database table.
 * 
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "@id")
@JsonIdentityReference(alwaysAsId = false)
@Entity
@Table(name = "movie")
@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m")
public class Movie implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "duration")
    private int    duration;
    @Column(name = "fsk")
    private int    fsk;
    @Column(name = "name", columnDefinition = "VARCHAR(40)")
    private String name;

    // bi-directional many-to-many association to Actor
    @ManyToMany(mappedBy = "movies", targetEntity = Actor.class, cascade = CascadeType.ALL)
    @JoinTable(name = "actor_movie", joinColumns = { @JoinColumn(name = "actor_id") }, inverseJoinColumns = { @JoinColumn(name = "movie_id") })
    private List<Actor> actors;

    // bi-directional many-to-one association to Genre
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Genre.class, cascade = CascadeType.ALL)
    @JoinTable(name = "movie_genre", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = { @JoinColumn(name = "genre_id") })
    private List<Genre> genres;

    // bi-directional many-to-one association to Show
    @OneToMany(mappedBy = "movie", targetEntity = Show.class, cascade = CascadeType.ALL)
    private List<Show> shows;

    // bi-directional many-to-one association to Show
    @OneToMany(mappedBy = "movie", targetEntity = Rating.class, cascade = CascadeType.ALL)
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

    public List<Genre> getGenres ( )
    {
        return genres;
    }

    public void setGenres ( List<Genre> genres )
    {
        this.genres = genres;
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

	@Override
	public int hashCode() {
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration != other.duration)
			return false;
		if (fsk != other.fsk)
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ratings == null) {
			if (other.ratings != null)
				return false;
		} else if (!ratings.equals(other.ratings))
			return false;
		if (shows == null) {
			if (other.shows != null)
				return false;
		} else if (!shows.equals(other.shows))
			return false;
		return true;
	}

}