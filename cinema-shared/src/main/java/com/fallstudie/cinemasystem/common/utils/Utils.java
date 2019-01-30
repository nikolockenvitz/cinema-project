package com.fallstudie.cinemasystem.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.fallstudie.cinemasystem.common.transferobject.SeatTo;
import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.common.transferobject.TicketTo;

public class Utils
{
    public static String convertDateToString ( Date date )
    {
        if ( null != date )
        {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            String convertedDate = df.format(date);
            return convertedDate;
        } else
            return null;
    }

    public static String getWeekDay ( Date date )
    {
        if ( null != date )
        {
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
            return sdf.format(date);
        } else
        {
            return null;
        }
    }

    public static String convertDateToTime ( Date date )
    {
        if ( null != date )
        {
            DateFormat df = new SimpleDateFormat("HH:mm");
            String convertedTime = df.format(date);
            return convertedTime;
        } else
        {
            return null;
        }
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

    public static Date convertStringToDate ( String date )
    {
        try
        {
            if ( null != date )
            {
                Date convertedDate = new SimpleDateFormat("dd.MM.yyyy").parse(date);
                return convertedDate;
            }
        } catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private static Calendar convertStringToCalendarDate ( String date )
    {
        try
        {
            if ( null != date )
            {
                Calendar calendar = new GregorianCalendar();
                Date convertedDate = new SimpleDateFormat("dd.MM.yyyy").parse(date);
                calendar.setTime(convertedDate);
                return calendar;
            }
        } catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static Date convertStringToTime ( String date )
    {
        try
        {
            if ( null != date )
            {
                Date convertedDate = new SimpleDateFormat("HH:mm").parse(date);
                return convertedDate;
            }
        } catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private static Calendar convertStringToCalendarTime ( String date )
    {
        try
        {
            if ( null != date )
            {
                Date convertedDate = new SimpleDateFormat("HH:mm").parse(date);
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(convertedDate);
                return calendar;
            }
        } catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static boolean checkIfShowIsReservable ( ShowTo showTo )
    {
        Calendar calendarNow = Calendar.getInstance();
        Calendar c = Utils.convertStringToCalendarTime(showTo.getTime());
        Calendar calendarShow = Utils.convertStringToCalendarDate(showTo.getDate());
        calendarShow.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY));
        calendarShow.set(Calendar.MINUTE, c.get(Calendar.MINUTE));
        calendarShow.set(Calendar.SECOND, c.get(Calendar.SECOND));

        final int milliseconds30minutes = 1000 * 60 * 30;
        if ( calendarShow.getTimeInMillis() - calendarNow.getTimeInMillis() > milliseconds30minutes )
        {
            return true;
        } else
        {
            return false;
        }
    }
}
