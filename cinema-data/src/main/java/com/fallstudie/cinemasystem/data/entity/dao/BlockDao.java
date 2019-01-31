package com.fallstudie.cinemasystem.data.entity.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.fallstudie.cinemasystem.data.entity.Block;
import com.fallstudie.cinemasystem.data.entity.query.BlockQuery;
import com.fallstudie.cinemasystem.data.entity.query.QueryParam;

public class BlockDao extends BaseDao<Block>
{

    @Override
    public int count ( Block crsRequest )
    {
        return 0;
    }

    @Override
    public Block find ( long id )
    {
        Block ticket = getEm().find(Block.class, id);
        return ticket;
    }

    @SuppressWarnings("unchecked")
    public List<Block> getAllBlockedSeats ( long id, Date datetolookfor )
    {
        List<Block> resultList = null;
        Query query = getEm().createNamedQuery(BlockQuery.FIND_BLOCKEDSEATS_BY_SHOW_ID);
        query.setParameter(QueryParam.SHOW_ID, id);
        query.setParameter(QueryParam.DATETOLOOKFOR, datetolookfor, TemporalType.TIMESTAMP);
        resultList = query.getResultList();
        return resultList;
    }

    public Block getBlockedSeatBySeatIdShowIdSessiontoken ( long seatId, long showId, String sessiontoken )
    {
        Block result = null;
        Query query = getEm().createNamedQuery(BlockQuery.FIND_BLOCK_BY_SHOW_ID_SEAT_ID_SESSIONTOKEN);
        query.setParameter(QueryParam.SHOW_ID, showId);
        query.setParameter(QueryParam.SEAT_ID, seatId);
        query.setParameter(QueryParam.SESSIONTOKEN, sessiontoken);
        result = (Block) query.getSingleResult();
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<Block> getAllBlockedSeatsInLast5Minutes ( Date datetolookfor )
    {
        List<Block> resultList = null;
        Query query = getEm().createNamedQuery(BlockQuery.FIND_BLOCKEDSEATS_BIGGER_5_MINUTES);
        query.setParameter(QueryParam.DATETOLOOKFOR, datetolookfor, TemporalType.TIMESTAMP);
        resultList = query.getResultList();
        return resultList;
    }

}
