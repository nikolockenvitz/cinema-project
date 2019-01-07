package com.fallstudie.kinobuchungssystem.common.transferobject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference(alwaysAsId = false)
public class HallTo
{
    private long         id;
    private String       name;
    private List<SeatTo> seats;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getName ( )
    {
        return name;
    }

    public List<SeatTo> getSeats ( )
    {
        return seats;
    }

    public void setSeats ( List<SeatTo> seats )
    {
        this.seats = seats;
    }

    public void setName ( String name )
    {
        this.name = name;
    }

}
