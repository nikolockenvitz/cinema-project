package com.fallstudie.cinemasystem.system.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Before;
import org.junit.Test;

import com.fallstudie.cinemasystem.common.transferobject.SeatTo;
import com.fallstudie.cinemasystem.common.transferobject.TicketTo;
import com.fallstudie.cinemasystem.common.utils.Utils;

public class UtilsTest
{

    Calendar       testCal              = null;
    Date           testDate             = null;
    String         testDateString       = null;
    String         testDateWeekdayProof = null;
    String         testDateTimeProof    = null;
    SeatTo         testSeatTo1          = null;
    SeatTo         testSeatTo2          = null;
    TicketTo       testTicketTo         = null;
    List<TicketTo> testTicketToList     = null;

    @Before
    public void initialize ( )
    {
        // calendar
        testCal = Calendar.getInstance();
        testCal.set(Calendar.YEAR, 2019);
        testCal.set(Calendar.MONTH, Calendar.JANUARY);
        testCal.set(Calendar.DAY_OF_MONTH, 17);
        testCal.set(Calendar.HOUR_OF_DAY, 20);
        testCal.set(Calendar.MINUTE, 15);

        // date
        testDate = testCal.getTime();
        testDateString = "17.01.2019";
        testDateWeekdayProof = "Donnerstag";
        testDateTimeProof = "20:15";

        // seat to
        testSeatTo1 = new SeatTo();
        testSeatTo2 = new SeatTo();
        testSeatTo1.setId(1);
        testSeatTo2.setId(2);

        // ticket to
        testTicketTo = new TicketTo();
        testTicketToList = new ArrayList<>();
        testTicketTo.setId(1);
        testTicketTo.setSeat(testSeatTo1);
        testTicketToList.add(testTicketTo);

    }

    @Test
    public void testConvertDateToString ( )
    {
        assertThat(Utils.convertDateToString(testDate), equalTo(testDateString));
    }

    @Test
    public void testGetWeekDay ( )
    {
        assertThat(Utils.getWeekDay(testDate), containsString(testDateWeekdayProof));

    }

    @Test
    public void testConvertDateToTime ( )
    {
        assertThat(testDateTimeProof, equalTo(Utils.convertDateToTime(testDate)));
    }

    @Test
    public void testConvertStringToDate ( )
    {
        assertThat(DateUtils.truncate(testDate, Calendar.DATE), equalTo(Utils.convertStringToDate(testDateString)));
    }

    @Test
    public void testCheckIfSeatIsBlocked ( )
    {
        assertThat(true, equalTo(Utils.checkIfSeatIsBlocked(testTicketToList, testSeatTo1.getId())));
        assertThat(false, equalTo(Utils.checkIfSeatIsBlocked(testTicketToList, testSeatTo2.getId())));
    }

    @Test
    public void testToNull ( )
    {
        assertThat(null, equalTo(Utils.convertStringToDate(null)));
        assertThat(null, equalTo(Utils.convertDateToString(null)));
    }

    @Test
    public void testConvertStringToTime ( )
    {
        assertThat(testDateTimeProof, equalTo(Utils.convertDateToTime(testDate)));
    }

    @Test
    public void testConvertTimeToString ( )
    {
        assertThat(testDate, equalTo(Utils.convertStringToTime(testDateTimeProof)));
    }
}
