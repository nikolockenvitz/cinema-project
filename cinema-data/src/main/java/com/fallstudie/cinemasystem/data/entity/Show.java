package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fallstudie.cinemasystem.data.entity.query.ShowQuery;

/**
 * The persistent class for the show database table.
 * 
 */
@Entity
@Table(name = "show")
@NamedQueries({ @NamedQuery(name = "Show.findAll", query = "SELECT s FROM Show s"),
        @NamedQuery(name = ShowQuery.FIND_SHOWS_BY_MOVIE_ID_QNAME, query = ShowQuery.FIND_SHOWS_BY_MOVIE_ID) })
public class Show implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "time", columnDefinition = "VARCHAR(5)")
    private String time;

    @Column(name = "is3d")
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

    public Date getDate ( )
    {
        return date;
    }

    public void setDate ( Date date )
    {
        this.date = date;
    }

    public String getTime ( )
    {
        return time;
    }

    public void setTime ( String time )
    {
        this.time = time;
    }

    public Ticket addTicket ( Ticket ticket )
    {
        getTickets().add(ticket);
        ticket.setShow(this);
        return ticket;
    }

    public Ticket removeTicket ( Ticket ticket )
    {
        getTickets().remove(ticket);
        ticket.setShow(null);
        return ticket;
    }

}