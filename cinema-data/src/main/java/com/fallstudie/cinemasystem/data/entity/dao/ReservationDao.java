package com.fallstudie.cinemasystem.data.entity.dao;

import com.fallstudie.cinemasystem.data.entity.Reservation;

public class ReservationDao extends BaseDao<Reservation>
{

    @Override
    public int count ( Reservation crsRequest )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Reservation find ( long id )
    {
        Reservation reservation = getEm().find(Reservation.class, id);
        return reservation;
    }

}
