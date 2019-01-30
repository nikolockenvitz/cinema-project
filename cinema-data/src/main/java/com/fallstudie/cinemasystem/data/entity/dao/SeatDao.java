package com.fallstudie.cinemasystem.data.entity.dao;

import com.fallstudie.cinemasystem.data.entity.Seat;

public class SeatDao extends BaseDao<Seat>
{

    @Override
    public int count ( Seat crsRequest )
    {
        return 0;
    }

    @Override
    public Seat find ( long id )
    {
        Seat seat = getEm().find(Seat.class, id);
        return seat;
    }

}
