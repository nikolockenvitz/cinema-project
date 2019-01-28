package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
import javax.persistence.Table;

import com.fallstudie.cinemasystem.data.entity.query.MovieQuery;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "isreducedprice")
    private boolean isReducedPrice;

    // bi-directional one-to-one association to Show
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Show.class)
    @JoinColumn(name = "show_id")
    private Show show;

    // bi-directional one-to-one association to Seat
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Seat.class, cascade = CascadeType.MERGE)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isReducedPrice ? 1231 : 1237);
		result = prime * result + ((reservation == null) ? 0 : reservation.hashCode());
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		result = prime * result + ((show == null) ? 0 : show.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id != other.id)
			return false;
		if (isReducedPrice != other.isReducedPrice)
			return false;
		if (reservation == null) {
			if (other.reservation != null)
				return false;
		} else if (!reservation.equals(other.reservation))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		if (show == null) {
			if (other.show != null)
				return false;
		} else if (!show.equals(other.show))
			return false;
		return true;
	}

}