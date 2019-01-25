package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fallstudie.cinemasystem.data.entity.query.ReservationQuery;

/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@Table(name = "reservation")
@NamedQueries({ @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
        @NamedQuery(name = ReservationQuery.FIND_TICKETS_BY_SHOW_ID_QNAME, query = ReservationQuery.FIND_RESERVATIONS_BY_SHOW_ID) })
public class Reservation implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateofreservation")
    private Date dateOfReservation;

    // bi-directional many-to-one association to Ticket
    @OneToMany(mappedBy = "reservation", targetEntity = Ticket.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;

//    // bi-directional one-to-one association to Customer
//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
//    private Customer customer;

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

    public List<Ticket> getTickets ( )
    {
        return tickets;
    }

    public void setTickets ( List<Ticket> tickets )
    {
        this.tickets = tickets;
    }

//    public Customer getCustomer ( )
//    {
//        return customer;
//    }
//
//    public void setCustomer ( Customer customer )
//    {
//        this.customer = customer;
//    }

    public Ticket addTicket ( Ticket ticket )
    {
        getTickets().add(ticket);
        ticket.setReservation(this);
        return ticket;
    }

    public Ticket removeTicket ( Ticket ticket )
    {
        getTickets().remove(ticket);
        ticket.setReservation(null);
        return ticket;
    }
}