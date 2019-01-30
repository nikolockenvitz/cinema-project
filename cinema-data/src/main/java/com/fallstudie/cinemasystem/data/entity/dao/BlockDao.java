package com.fallstudie.cinemasystem.data.entity.dao;

import com.fallstudie.cinemasystem.data.entity.Block;

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

}
