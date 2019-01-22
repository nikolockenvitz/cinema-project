package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
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

    private Seat     seat;
    private Show     show;
    private Customer customer;

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

}