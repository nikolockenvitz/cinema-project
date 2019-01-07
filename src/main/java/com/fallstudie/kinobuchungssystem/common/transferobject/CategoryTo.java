package com.fallstudie.kinobuchungssystem.common.transferobject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference(alwaysAsId = false)
public class CategoryTo
{
    private long         id;
    private String       category;
    private List<SeatTo> seats;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getCategory ( )
    {
        return category;
    }

    public void setCategory ( String category )
    {
        this.category = category;
    }

    public List<SeatTo> getSeats ( )
    {
        return seats;
    }

    public void setSeats ( List<SeatTo> seats )
    {
        this.seats = seats;
    }

}
