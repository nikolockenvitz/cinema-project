package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the actor database table.
 * 
 */
@Entity
@Table(name = "block")
@NamedQuery(name = "Block.findAll", query = "SELECT b FROM Block b")
public class Block implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long     id;
    private Seat     seat;
    private Show     show;
    private Customer customer;
    private Employee employee;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public Seat getSeat ( )
    {
        return seat;
    }

    public void setSeat ( Seat seat )
    {
        this.seat = seat;
    }

    public Show getShow ( )
    {
        return show;
    }

    public void setShow ( Show show )
    {
        this.show = show;
    }

    public Customer getCustomer ( )
    {
        return customer;
    }

    public void setCustomer ( Customer customer )
    {
        this.customer = customer;
    }

    public Date getTimestamp ( )
    {
        return timestamp;
    }

    public void setTimestamp ( Date timestamp )
    {
        this.timestamp = timestamp;
    }

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
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