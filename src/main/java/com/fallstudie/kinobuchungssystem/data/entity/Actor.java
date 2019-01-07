package com.fallstudie.kinobuchungssystem.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the actor database table.
 * 
 */
@Entity
@Table(name = "actor")
@NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a")
public class Actor implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ACTOR_ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTOR_ID_GENERATOR")
    private long id;

    @Temporal(TemporalType.DATE)
    private Date   birthdate;
    @Column(name = "firstname", columnDefinition = "VARCHAR(30)")
    private String firstname;
    @Column(name = "lastname", columnDefinition = "VARCHAR(30)")
    private String lastname;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-many association to Movie
    @ManyToMany
    @JoinTable(name = "actor_movie", joinColumns = { @JoinColumn(name = "actor_id") }, inverseJoinColumns = { @JoinColumn(name = "movie_id") })
    private List<Movie> movies;

    public Actor( )
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

    public Date getBirthdate ( )
    {
        return this.birthdate;
    }

    public void setBirthdate ( Date birthdate )
    {
        this.birthdate = birthdate;
    }

    public String getFirstname ( )
    {
        return this.firstname;
    }

    public void setFirstname ( String firstname )
    {
        this.firstname = firstname;
    }

    public String getLastname ( )
    {
        return this.lastname;
    }

    public void setLastname ( String lastname )
    {
        this.lastname = lastname;
    }

    public List<Movie> getMovies ( )
    {
        return this.movies;
    }

    public void setMovies ( List<Movie> movies )
    {
        this.movies = movies;
    }

}