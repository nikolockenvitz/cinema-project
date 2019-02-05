package com.fallstudie.cinemasystem.data.entity;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the rating database table.
 * 
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "@id")
@JsonIdentityReference(alwaysAsId = false)
@Entity
@Table(name = "rating")
@NamedQuery(name = "Rating.findAll", query = "SELECT r FROM Rating r")
public class Rating implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "rating")
    private int rating;

    // bi-directional many-to-many association to User
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    @JoinColumn(name = "customer_id")
    private Customer customer;

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

    public Customer getUser ( )
    {
        return customer;
    }

    public void setUser ( Customer user )
    {
        this.customer = user;
    }

    public Movie getMovie ( )
    {
        return movie;
    }

    public void setMovie ( Movie movie )
    {
        this.movie = movie;
    }

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
//		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
//		result = prime * result + (int) (id ^ (id >>> 32));
//		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
//		result = prime * result + rating;
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
//		Rating other = (Rating) obj;
//		if (comment == null) {
//			if (other.comment != null)
//				return false;
//		} else if (!comment.equals(other.comment))
//			return false;
//		if (customer == null) {
//			if (other.customer != null)
//				return false;
//		} else if (!customer.equals(other.customer))
//			return false;
//		if (id != other.id)
//			return false;
//		if (movie == null) {
//			if (other.movie != null)
//				return false;
//		} else if (!movie.equals(other.movie))
//			return false;
//		if (rating != other.rating)
//			return false;
//		return true;
//	}

}