package com.fallstudie.cinemasystem.system.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Before;
import org.junit.Test;

import com.fallstudie.cinemasystem.common.transferobject.PriceTo;
import com.fallstudie.cinemasystem.common.transferobject.SeatTo;
import com.fallstudie.cinemasystem.common.transferobject.TicketTo;
import com.fallstudie.cinemasystem.common.utils.Utils;

public class UtilsTest
{

    Calendar       testCalendar               = null;
    Calendar       testCalendarTime           = null;
    Calendar       testCalendarProof          = null;
    Calendar       testCalendarTomorrow       = null;
    Calendar       testCalendarXMinAgo        = null;
    Date           testDate                   = null;
    Date           testTime                   = null;
    String         testDateString             = null;
    String         testDateWeekdayProof       = null;
    String         testDateTimeProof          = null;
    SeatTo         testSeatTo1                = null;
    SeatTo         testSeatTo2                = null;
    TicketTo       testTicketTo               = null;
    List<TicketTo> testTicketToList           = null;
    String         testShowDateStringToday    = null;
    String         testShowDateStringTomorrow = null;
    String         testShowTimeString         = null;
    PriceTo        testPriceToDefault         = null;
    PriceTo        testPriceToSofa            = null;
    PriceTo        testPriceToLoge            = null;
    String         testCategoryStringDefault  = null;
    String         testCategoryStringLoge     = null;
    String         testCategoryStringSofa     = null;
    int            testMinuteDifference;

    @Before
    public void initialize ( )
    {
        // calendar
        testCalendar = Calendar.getInstance();
        testCalendar.set(Calendar.YEAR, 2019);
        testCalendar.set(Calendar.MONTH, Calendar.JANUARY);
        testCalendar.set(Calendar.DAY_OF_MONTH, 17);
        testCalendar.set(Calendar.HOUR_OF_DAY, 20);
        testCalendar.set(Calendar.MINUTE, 15);

        testCalendarProof = new GregorianCalendar();
        testCalendarProof.set(2019, 0, 17, 0, 0, 0);
        testCalendarProof.set(Calendar.MILLISECOND, 0);

        testCalendarTime = new GregorianCalendar();
        testCalendarTime.set(1970, 0, 1, 20, 15, 0);
        testCalendarTime.set(testCalendarTime.MILLISECOND, 0);

        testMinuteDifference = 5;
        testCalendarXMinAgo = Calendar.getInstance();
        testCalendarXMinAgo.set(Calendar.MINUTE, testCalendarXMinAgo.get(Calendar.MINUTE) - testMinuteDifference);

        // date
        testDate = testCalendar.getTime();
        testDateString = "17.01.2019";
        testDateWeekdayProof = "Donnerstag";
        testDateTimeProof = "20:15";
        testTime = testCalendarTime.getTime();

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

        // show date and time strings for reservable test
        testShowDateStringToday = Utils.convertDateToString(Calendar.getInstance().getTime());
        testShowTimeString = "00:00";

        testCalendarTomorrow = Calendar.getInstance();
        testCalendarTomorrow.add(Calendar.DAY_OF_MONTH, 1);
        testShowDateStringTomorrow = Utils.convertDateToString(testCalendarTomorrow.getTime());

        // price tos
        testPriceToDefault = new PriceTo();
        testPriceToDefault.setDefaultPrice(1000);
        testPriceToDefault.setReducedPrice(800);

        testPriceToLoge = new PriceTo();
        testPriceToLoge.setDefaultPrice(1200);
        testPriceToLoge.setReducedPrice(1000);

        testPriceToSofa = new PriceTo();
        testPriceToSofa.setDefaultPrice(2000);
        testPriceToSofa.setReducedPrice(1600);

        testCategoryStringDefault = "Default";
        testCategoryStringLoge = "Loge";
        testCategoryStringSofa = "Sofa";
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
    public void testConvertStringToTime ( )
    {
        assertThat(testTime, equalTo(Utils.convertStringToTime(testDateTimeProof)));
    }

    @Test
    public void testConvertStringToCalendarDate ( )
    {
        assertThat(testCalendarProof, equalTo(Utils.convertStringToCalendarDate(testDateString)));
    }

    @Test
    public void testConvertStringToCalendarTime ( )
    {
        assertThat(testCalendarTime, equalTo(Utils.convertStringToCalendarTime(testDateTimeProof)));
    }

    @Test
    public void testCheckIfShowIsReservable ( )
    {
        assertThat(false, equalTo(Utils.checkIfShowIsReservable(testShowDateStringToday, testShowTimeString)));
        assertThat(true, equalTo(Utils.checkIfShowIsReservable(testShowDateStringTomorrow, testShowTimeString)));
    }

    @Test
    public void testGetDateTimeDifference ( )
    {
        assertThat(testCalendarXMinAgo.getTime(), equalTo(Utils.getDateTimeDifference(testMinuteDifference)));
    }

    @Test
    public void testGetPriceForCategory ( )
    {
        assertThat(testPriceToDefault, equalTo(Utils.getPriceForCategory(testCategoryStringDefault)));
        assertThat(testPriceToLoge, equalTo(Utils.getPriceForCategory(testCategoryStringLoge)));
        assertThat(testPriceToSofa, equalTo(Utils.getPriceForCategory(testCategoryStringSofa)));
    }

    @Test
    public void testToNull ( )
    {
        assertThat(null, equalTo(Utils.convertStringToDate(null)));
        assertThat(null, equalTo(Utils.convertDateToString(null)));
        assertThat(null, equalTo(Utils.getWeekDay(null)));
        assertThat(null, equalTo(Utils.convertDateToTime(null)));
        assertThat(null, equalTo(Utils.convertStringToCalendarDate(null)));
        assertThat(null, equalTo(Utils.convertStringToTime(null)));
        assertThat(null, equalTo(Utils.convertStringToCalendarTime(null)));

    }

}
