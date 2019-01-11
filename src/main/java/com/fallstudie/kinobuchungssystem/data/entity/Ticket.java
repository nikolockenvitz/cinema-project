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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fallstudie.kinobuchungssystem.data.entity.query.MovieQuery;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the ticket database table.
 * 
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "@id")
@JsonIdentityReference(alwaysAsId = false)
@Entity
@Table(name = "ticket")
@NamedQueries({ @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
        @NamedQuery(name = MovieQuery.FIND_TICKETS_BY_SHOW_ID_QNAME, query = MovieQuery.FIND_TICKETS_BY_SHOW_ID) })
public class Ticket implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TICKET_ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TICKET_ID_GENERATOR")
    private long id;

    @Column(name = "isreducedprice")
    private boolean isReducedPrice;

    // bi-directional one-to-one association to Show
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Show.class)
    @JoinColumn(name = "show_id")
    private Show show;

    // bi-directional one-to-one association to Seat
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Seat.class)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    // bi-directional many-to-one association to Reservation
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Reservation.class)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    // bi-directional one-to-one association to Seat
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Employee.class)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Ticket( )
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

    public boolean isReducedPrice ( )
    {
        return isReducedPrice;
    }

    public void setReducedPrice ( boolean isReducedPrice )
    {
        this.isReducedPrice = isReducedPrice;
    }

    public Show getShow ( )
    {
        return show;
    }

    public void setShow ( Show show )
    {
        this.show = show;
    }

    public Seat getSeat ( )
    {
        return seat;
    }

    public void setSeat ( Seat seat )
    {
        this.seat = seat;
    }

    public Reservation getReservation ( )
    {
        return reservation;
    }

    public void setReservation ( Reservation reservation )
    {
        this.reservation = reservation;
    }

    public Employee getEmployee ( )
    {
        return employee;
    }

    public void setEmployee ( Employee employee )
    {
        this.employee = employee;
    }

}