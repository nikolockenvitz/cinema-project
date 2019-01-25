package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the seat database table.
 * 
 */
@Entity
@Table(name = "seat")
@NamedQuery(name = "Seat.findAll", query = "SELECT s FROM Seat s")
public class Seat implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number")
    private String number;

    @Column(name = "row")
    private String row;

    @Column(name = "y")
    private int y;

    @Column(name = "x")
    private int x;

    // bi-directional many-to-one association to Ticket
    @OneToMany(mappedBy = "seat", targetEntity = Ticket.class)
    private List<Ticket> tickets;

    // bi-directional many-to-one association to Hall
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Hall.class)
    @JoinColumn(name = "hall_id")
    private Hall hall;

    // bi-directional many-to-one association to Category
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    public Seat( )
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

    public String getNumber ( )
    {
        return number;
    }

    public void setNumber ( String number )
    {
        this.number = number;
    }

    public String getRow ( )
    {
        return row;
    }

    public void setRow ( String row )
    {
        this.row = row;
    }

    public Hall getHall ( )
    {
        return hall;
    }

    public void setHall ( Hall hall )
    {
        this.hall = hall;
    }

    public Category getCategory ( )
    {
        return category;
    }

    public void setCategory ( Category category )
    {
        this.category = category;
    }

    public List<Ticket> getTickets ( )
    {
        return tickets;
    }

    public void setTickets ( List<Ticket> tickets )
    {
        this.tickets = tickets;
    }

    public int getY ( )
    {
        return y;
    }

    public void setY ( int y )
    {
        this.y = y;
    }

    public int getX ( )
    {
        return x;
    }

    public void setX ( int x )
    {
        this.x = x;
    }

    public Ticket addTicket ( Ticket ticket )
    {
        getTickets().add(ticket);
        ticket.setSeat(this);
        return ticket;
    }

    public Ticket removeTicket ( Ticket ticket )
    {
        getTickets().remove(ticket);
        ticket.setSeat(null);
        return ticket;
    }
}