package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
    @SequenceGenerator(name = "SEAT_ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEAT_ID_GENERATOR")
    private long id;

    private int number;

    private String row;

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

    public int getNumber ( )
    {
        return this.number;
    }

    public void setNumber ( int number )
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

}