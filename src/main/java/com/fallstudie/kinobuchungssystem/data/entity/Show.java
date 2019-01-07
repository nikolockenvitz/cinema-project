package com.fallstudie.kinobuchungssystem.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the show database table.
 * 
 */
@Entity
@Table(name = "show")
@NamedQuery(name = "Show.findAll", query = "SELECT s FROM Show s")
public class Show implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "starttime")
    private Date starttime;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-one association to Reservation
    @OneToMany(mappedBy = "show", targetEntity = Reservation.class)
    private List<Reservation> reservations;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional one-to-one association to Ticket
    @OneToMany(mappedBy = "show", fetch = FetchType.LAZY, targetEntity = Ticket.class)
    private List<Ticket> tickets;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-one association to Movie
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Movie.class)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Show( )
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

    public Date getStarttime ( )
    {
        return starttime;
    }

    public void setStarttime ( Date starttime )
    {
        this.starttime = starttime;
    }

    public List<Reservation> getReservations ( )
    {
        return reservations;
    }

    public void setReservations ( List<Reservation> reservations )
    {
        this.reservations = reservations;
    }

    public List<Ticket> getTickets ( )
    {
        return tickets;
    }

    public void setTickets ( List<Ticket> tickets )
    {
        this.tickets = tickets;
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