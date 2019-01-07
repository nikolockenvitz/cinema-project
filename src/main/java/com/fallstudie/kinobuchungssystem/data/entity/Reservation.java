package com.fallstudie.kinobuchungssystem.data.entity;

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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the reservation database table.
 * 
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference(alwaysAsId = false)
@Entity
@Table(name = "reservation")
@NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
public class Reservation implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "RESERVATION_ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESERVATION_ID_GENERATOR")
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateofreservation")
    private Date dateOfReservation;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-one association to Show
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Show.class)
    @JoinColumn(name = "show_id")
    private Show show;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-one association to Ticket
    @OneToMany(mappedBy = "reservation", targetEntity = Ticket.class)
    private List<Ticket> tickets;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-one association to Ticket
    @OneToMany(mappedBy = "reservation", targetEntity = Seat.class)
    private List<Seat> seats;

    public Reservation( )
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

    public Date getDateOfReservation ( )
    {
        return dateOfReservation;
    }

    public void setDateOfReservation ( Date dateOfReservation )
    {
        this.dateOfReservation = dateOfReservation;
    }

    public Show getShow ( )
    {
        return show;
    }

    public void setShow ( Show show )
    {
        this.show = show;
    }

    public List<Ticket> getTickets ( )
    {
        return tickets;
    }

    public void setTickets ( List<Ticket> tickets )
    {
        this.tickets = tickets;
    }

    public List<Seat> getSeats ( )
    {
        return seats;
    }

    public void setSeats ( List<Seat> seats )
    {
        this.seats = seats;
    }

}