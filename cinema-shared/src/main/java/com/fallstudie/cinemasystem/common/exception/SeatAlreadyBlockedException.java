package com.fallstudie.cinemasystem.common.exception;

public class SeatAlreadyBlockedException extends Exception
{

    public SeatAlreadyBlockedException( long seatId, long showId )
    {
        super("Seat " + seatId + " in Show " + showId + " already blocked");
    }

}
