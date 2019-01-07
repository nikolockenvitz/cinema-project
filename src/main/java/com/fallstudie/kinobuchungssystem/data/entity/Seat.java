package com.fallstudie.kinobuchungssystem.data.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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

    private int row;

    @Column(name = "ticket_id")
    private long ticketId;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-one association to Category
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional one-to-one association to Ticket
    @OneToOne(mappedBy = "seat", fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-one association to Hall
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Hall.class)
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-one association to Hall
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Reservation.class)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

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

    public int getRow ( )
    {
        return row;
    }

    public void setRow ( int row )
    {
        this.row = row;
    }

    public Category getCategory ( )
    {
        return category;
    }

    public void setCategory ( Category category )
    {
        this.category = category;
    }

    public long getTicketId ( )
    {
        return ticketId;
    }

    public void setTicketId ( long ticketId )
    {
        this.ticketId = ticketId;
    }

    public Ticket getTicket ( )
    {
        return ticket;
    }

    public void setTicket ( Ticket ticket )
    {
        this.ticket = ticket;
    }

    public Hall getHall ( )
    {
        return hall;
    }

    public void setHall ( Hall hall )
    {
        this.hall = hall;
    }

    public Reservation getReservation ( )
    {
        return reservation;
    }

    public void setReservation ( Reservation reservation )
    {
        this.reservation = reservation;
    }

}