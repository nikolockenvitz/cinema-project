package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fallstudie.cinemasystem.data.entity.query.BlockQuery;

/**
 * The persistent class for the actor database table.
 * 
 */
@Entity
@Table(name = "block")
@NamedQueries({ @NamedQuery(name = "Block.findAll", query = "SELECT b FROM Block b"),
        @NamedQuery(name = BlockQuery.FIND_BLOCKEDSEATS_BY_SHOW_ID_QNAME, query = BlockQuery.FIND_BLOCKEDSEATS_BY_SHOW_ID),
        @NamedQuery(name = BlockQuery.FIND_BLOCK_BY_SHOW_ID_SEAT_ID_SESSIONTOKEN_QNAME, query = BlockQuery.FIND_BLOCK_BY_SHOW_ID_SEAT_ID_SESSIONTOKEN),
        @NamedQuery(name = BlockQuery.FIND_BLOCKEDSEATS_BIGGER_5_MINUTES_QNAME, query = BlockQuery.FIND_BLOCKEDSEATS_BIGGER_5_MINUTES) })
public class Block implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private Seat   seat;
    private Show   show;
    private String sessiontoken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeofreservation;

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

    public Date getTimeofreservation ( )
    {
        return timeofreservation;
    }

    public void setTimeofreservation ( Date timeofreservation )
    {
        this.timeofreservation = timeofreservation;
    }

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getSessiontoken ( )
    {
        return sessiontoken;
    }

    public void setSessiontoken ( String sessiontoken )
    {
        this.sessiontoken = sessiontoken;
    }

}