package com.fallstudie.cinemasystem.data.entity.query;

public interface ReservationQuery
{
    public static final String FIND_RESERVATIONS_BY_SHOW_ID = "SELECT r FROM Reservation r JOIN Ticket t" + " WHERE t.show.id =:" + QueryParam.SHOW_ID;

    public static final String FIND_TICKETS_BY_SHOW_ID_QNAME = ReservationQuery.FIND_RESERVATIONS_BY_SHOW_ID;

}
