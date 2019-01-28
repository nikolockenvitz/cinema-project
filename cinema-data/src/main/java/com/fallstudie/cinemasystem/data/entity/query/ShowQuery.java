package com.fallstudie.cinemasystem.data.entity.query;

public interface ShowQuery
{
    public static final String FIND_SHOWS_BY_MOVIE_ID = "SELECT s FROM Show s" + " WHERE s.movie.id =:" + QueryParam.MOVIE_ID + " AND s.date >= CURRENT_DATE";

    public static final String FIND_SHOWS_BY_MOVIE_ID_QNAME = ShowQuery.FIND_SHOWS_BY_MOVIE_ID;

}
