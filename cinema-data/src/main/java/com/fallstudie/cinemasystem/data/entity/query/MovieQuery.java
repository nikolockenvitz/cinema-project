package com.fallstudie.cinemasystem.data.entity.query;

public interface MovieQuery
{
    public static final String FIND_TICKETS_BY_SHOW_ID = "SELECT t FROM Ticket t" + " WHERE t.show.id =:" + QueryParam.SHOW_ID;

    public static final String FIND_TICKETS_BY_SHOW_ID_QNAME = MovieQuery.FIND_TICKETS_BY_SHOW_ID;

}
