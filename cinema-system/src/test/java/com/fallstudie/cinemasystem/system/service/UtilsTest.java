package com.fallstudie.cinemasystem.system.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import com.fallstudie.cinemasystem.common.transferobject.CategoryTo;
import com.fallstudie.cinemasystem.common.transferobject.SeatTo;
import com.fallstudie.cinemasystem.common.transferobject.TicketTo;
import com.fallstudie.cinemasystem.common.utils.Utils;

public class UtilsTest
{

    @Test
    public void convertDateToString ( )
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 17);

        Date date = cal.getTime();
        String convertedDate = Utils.convertDateToString(date);

        String toProof = "17.01.2019";
        assertEquals(convertedDate, toProof);
    }

    @Test
    public void getWeekDay ( )
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 17);

        Date date = cal.getTime();

        String s = Utils.getWeekDay(date);
        assertThat(s, containsString("Donnerstag"));
    }

    @Test
    public void getTimeOfDate ( )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 20);
        calendar.set(Calendar.MINUTE, 15);

        String s = Utils.convertDateToTime(calendar.getTime());
        assertEquals("20:15", s);
    }

    @Test
    public void convertStringToDate ( )
    {
        String date = "21.01.2019";
        Date convertedDate = Utils.convertStringToDate(date);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 0, 21, 0, 0, 0);

        assertEquals(DateUtils.truncate(calendar.getTime(), Calendar.DATE), convertedDate);
    }

    @Test
    public void checkIfSeatIsBlocked ( )
    {
        SeatTo seatTo = new SeatTo();
        seatTo.setRow("A");
        seatTo.setNumber("10");
        seatTo.setId(1L);
        seatTo.setCategory(new CategoryTo());

        SeatTo seatTo2 = new SeatTo();
        seatTo2.setRow("A");
        seatTo2.setNumber("11");
        seatTo2.setId(2L);
        seatTo2.setCategory(new CategoryTo());

        List<TicketTo> ticketTos = new ArrayList<>();
        TicketTo ticketTo = new TicketTo();
        ticketTo.setId(1L);
        ticketTo.setReducedPrice(false);
        ticketTo.setReservation(null);
        ticketTo.setSeat(seatTo);

        ticketTos.add(ticketTo);

        assertEquals(true, Utils.checkIfSeatIsBlocked(ticketTos, seatTo.getId()));
        assertEquals(false, Utils.checkIfSeatIsBlocked(ticketTos, seatTo2.getId()));
    }

}
