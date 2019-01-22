package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the hall database table.
 * 
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "@id")
@JsonIdentityReference(alwaysAsId = false)
@Entity
@Table(name = "hall")
@NamedQuery(name = "Hall.findAll", query = "SELECT h FROM Hall h")
public class Hall implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "HALL_ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HALL_ID_GENERATOR")
    private long id;

    @Column(name = "name", columnDefinition = "VARCHAR(20)")
    private String name;

    @Column(name = "width")
    private int width;

    @Column(name = "length")
    private int length;

    // bi-directional many-to-one association to Seat
    @OneToMany(mappedBy = "hall", targetEntity = Seat.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats;

    public Hall( )
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

    public String getName ( )
    {
        return this.name;
    }

    public void setName ( String name )
    {
        this.name = name;
    }

    public List<Seat> getSeats ( )
    {
        return seats;
    }

    public void setSeats ( List<Seat> seats )
    {
        this.seats = seats;
    }

    public int getWidth ( )
    {
        return width;
    }

    public void setWidth ( int width )
    {
        this.width = width;
    }

    public int getLength ( )
    {
        return length;
    }

    public void setLength ( int length )
    {
        this.length = length;
    }

}