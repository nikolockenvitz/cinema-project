package com.fallstudie.cinemasystem.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fallstudie.cinemasystem.common.transferobject.SeatTo;
import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.common.transferobject.TicketTo;

public class Utils
{
    public static String convertDateToString ( Date date )
    {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String convertedDate = df.format(date);

        return convertedDate;
    }

    public static String getWeekDay ( Date date )
    {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        return sdf.format(date);
    }

    public static String convertDateToTime ( Date date )
    {
        DateFormat df = new SimpleDateFormat("HH:mm");
        String convertedTime = df.format(date);
        return convertedTime;
    }

    public static boolean checkIfSeatIsBlocked ( List<TicketTo> tickets, long seatId )
    {
        long tempSeatId = 0;
        for ( TicketTo ticketTo : tickets )
        {
            tempSeatId = ticketTo.getSeat().getId();
            if ( tempSeatId == seatId )
            {
                return true;
            }
        }
        return false;
    }

    public static void checkIfSeatIsOccupied ( ShowTo showTo, List<TicketTo> ticketTos )
    {
        List<SeatTo> seatTos = showTo.getHall().getSeats();
        long actualSeatId;
        long tmpSeatId;

        for ( SeatTo seatTo : seatTos )
        {
            for ( TicketTo ticketTo : ticketTos )
            {
                actualSeatId = seatTo.getId();
                tmpSeatId = ticketTo.getSeat().getId();
                if ( tmpSeatId == actualSeatId )
                {
                    seatTo.setOccupied((true));
                    break;
                }
            }
        }

    }
}