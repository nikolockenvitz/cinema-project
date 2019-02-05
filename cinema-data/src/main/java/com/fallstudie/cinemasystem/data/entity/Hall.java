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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (int) (id ^ (id >>> 32));
//		result = prime * result + length;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((seats == null) ? 0 : seats.hashCode());
//		result = prime * result + width;
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Hall other = (Hall) obj;
//		if (id != other.id)
//			return false;
//		if (length != other.length)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (seats == null) {
//			if (other.seats != null)
//				return false;
//		} else if (!seats.equals(other.seats))
//			return false;
//		if (width != other.width)
//			return false;
//		return true;
//	}

}