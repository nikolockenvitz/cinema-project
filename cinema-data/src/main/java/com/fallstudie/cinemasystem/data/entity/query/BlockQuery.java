package com.fallstudie.cinemasystem.data.entity.query;

public interface BlockQuery
{
    public static final String FIND_BLOCKEDSEATS_BY_SHOW_ID = "SELECT b FROM Block b" + " WHERE b.show.id =:" + QueryParam.SHOW_ID
            + " AND b.timeofreservation >:" + QueryParam.DATETOLOOKFOR;

    public static final String FIND_BLOCKEDSEATS_BY_SHOW_ID_QNAME = BlockQuery.FIND_BLOCKEDSEATS_BY_SHOW_ID;

    public static final String FIND_BLOCK_BY_SHOW_ID_SEAT_ID_SESSIONTOKEN = "SELECT b FROM Block b" + " WHERE b.show.id =:" + QueryParam.SHOW_ID
            + " AND b.seat.id =:" + QueryParam.SEAT_ID + " AND b.sessiontoken =:" + QueryParam.SESSIONTOKEN;

    public static final String FIND_BLOCK_BY_SHOW_ID_SEAT_ID_SESSIONTOKEN_QNAME = BlockQuery.FIND_BLOCK_BY_SHOW_ID_SEAT_ID_SESSIONTOKEN;

    public static final String FIND_BLOCKEDSEATS_BIGGER_5_MINUTES = "SELECT b FROM Block b" + " WHERE b.timeofreservation <:" + QueryParam.DATETOLOOKFOR;

    public static final String FIND_BLOCKEDSEATS_BIGGER_5_MINUTES_QNAME = BlockQuery.FIND_BLOCKEDSEATS_BIGGER_5_MINUTES;
}
