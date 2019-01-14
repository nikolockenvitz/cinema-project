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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the reservation database table.
 * 
 */
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

    // bi-directional many-to-one association to Ticket
    @OneToMany(mappedBy = "reservation", targetEntity = Ticket.class)
    private List<Ticket> tickets;

    // bi-directional one-to-one association to Customer
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    @JoinColumn(name = "customer_id")
    private Customer customer;

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

    public Customer getCustomer ( )
    {
        return customer;
    }

    public void setCustomer ( Customer customer )
    {
        this.customer = customer;
    }

}