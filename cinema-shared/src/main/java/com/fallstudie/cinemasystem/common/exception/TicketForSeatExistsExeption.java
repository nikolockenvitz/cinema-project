package com.fallstudie.cinemasystem.common.exception;

import com.fallstudie.cinemasystem.common.transferobject.TicketTo;

public class TicketForSeatExistsExeption extends Exception
{
    public TicketForSeatExistsExeption( TicketTo ticketTo, long seatId )
    {
        super("This seat (seatId:" + seatId + ") is used by TicketId: " + ticketTo.getId());
    }
}
