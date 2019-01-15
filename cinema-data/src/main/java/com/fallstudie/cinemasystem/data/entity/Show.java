package com.fallstudie.cinemasystem.data.entity;

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

    @Column(name = "3d")
    private boolean is3D;

    // bi-directional one-to-one association to Ticket
    @OneToMany(mappedBy = "show", fetch = FetchType.LAZY, targetEntity = Ticket.class)
    private List<Ticket> tickets;

    // bi-directional many-to-one association to Movie
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Movie.class)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    // bi-directional many-to-one association to Hall
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Hall.class)
    @JoinColumn(name = "hall_id")
    private Hall hall;

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

    public Hall getHall ( )
    {
        return hall;
    }

    public void setHall ( Hall hall )
    {
        this.hall = hall;
    }

    public boolean is3D ( )
    {
        return is3D;
    }

    public void setIs3D ( boolean is3d )
    {
        is3D = is3d;
    }

}