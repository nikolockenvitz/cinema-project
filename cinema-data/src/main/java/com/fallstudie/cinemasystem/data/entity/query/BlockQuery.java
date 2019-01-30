package com.fallstudie.cinemasystem.data.entity.query;

public interface BlockQuery
{
    public static final String FIND_BLOCKEDSEATS_BY_SHOW_ID = "SELECT b FROM Block b" + " WHERE b.show.id =:" + QueryParam.SHOW_ID
            + " AND b.timeofreservation > SQL(\"(? - interval '5' minute)\", CURRENT_TIMESTAMP)";

    public static final String FIND_BLOCKEDSEATS_BY_SHOW_ID_QNAME = BlockQuery.FIND_BLOCKEDSEATS_BY_SHOW_ID;

}
