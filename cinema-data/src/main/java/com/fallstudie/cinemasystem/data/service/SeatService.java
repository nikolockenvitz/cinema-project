package com.fallstudie.cinemasystem.data.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.transferobject.SeatTo;
import com.fallstudie.cinemasystem.data.entity.dao.SeatDao;
import com.fallstudie.cinemasystem.data.helper.EntityToToHelper;

public class SeatService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(SeatService.class);
    private SeatDao             seatDao;

    public SeatService( )
    {
        this.seatDao = new SeatDao();
    }

    public SeatTo getSeat ( String idString )
    {
        Long id = Long.parseLong(idString);
        return EntityToToHelper.createSeatTo(seatDao.find(id));
    }

}
