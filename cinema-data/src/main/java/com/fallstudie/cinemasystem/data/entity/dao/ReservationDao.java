package com.fallstudie.cinemasystem.data.entity.dao;

import java.util.List;

import javax.persistence.Query;

import com.fallstudie.cinemasystem.data.entity.Reservation;
import com.fallstudie.cinemasystem.data.entity.query.QueryParam;
import com.fallstudie.cinemasystem.data.entity.query.ReservationQuery;

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

    @SuppressWarnings("unchecked")
    public List<Reservation> getAllReservationsForShow ( Long showId )
    {
        List<Reservation> resultList = null;
        Query query = getEm().createNamedQuery(ReservationQuery.FIND_RESERVATIONS_BY_SHOW_ID);
        query.setParameter(QueryParam.SHOW_ID, showId);
        resultList = query.getResultList();
        return resultList;
    }

}
