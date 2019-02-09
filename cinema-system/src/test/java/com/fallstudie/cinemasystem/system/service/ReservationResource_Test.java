package com.fallstudie.cinemasystem.system.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fallstudie.cinemasystem.common.json.JSONConverter;
import com.fallstudie.cinemasystem.common.transferobject.BlockTo;
import com.fallstudie.cinemasystem.common.transferobject.BlockToWithSessiontoken;
import com.fallstudie.cinemasystem.common.transferobject.BookingTo;
import com.fallstudie.cinemasystem.common.transferobject.CategoryTo;
import com.fallstudie.cinemasystem.common.transferobject.CustomerTo;
import com.fallstudie.cinemasystem.common.transferobject.PriceTo;
import com.fallstudie.cinemasystem.common.transferobject.ReservationTo;
import com.fallstudie.cinemasystem.common.transferobject.SeatTo;
import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.common.utils.Utils;
import com.fallstudie.cinemasystem.resource.ReservationResource;

public class ReservationResource_Test
{

    ReservationResource     testReservationResource   = null;
    String                  testReservationJSON       = null;
    ReservationTo           testReservationTo         = null;
    Calendar                testDate                  = null;
    String                  testDateString            = null;
    ArrayList               emptyList                 = null;
    BookingTo               testBookingTo             = null;
    SeatTo                  testSeatTo                = null;
    List<SeatTo>            testSeatToList            = null;
    PriceTo                 testPriceTo               = null;
    CategoryTo              testCategoryTo            = null;
    CustomerTo              testCustomerTo            = null;
    BlockToWithSessiontoken testBlockWithSessionToken = null;
    ShowTo                  testShowTo                = null;

    @Before
    public void initialize ( )
    {
        testReservationResource = new ReservationResource();

        emptyList = new ArrayList<>();

        // Date
        testDate = Calendar.getInstance();
        testDate.set(Calendar.YEAR, 2019);
        testDate.set(Calendar.MONTH, Calendar.JANUARY);
        testDate.set(Calendar.DAY_OF_MONTH, 17);

        testDateString = Utils.convertDateToString(testDate.getTime());

        // price to
        testPriceTo = new PriceTo();
        testPriceTo.setDefaultPrice(1000);
        testPriceTo.setReducedPrice(800);

        // customer to
        testCustomerTo = new CustomerTo();
        testCustomerTo.setEmail("mail");
        testCustomerTo.setFirstname("firstname");
        testCustomerTo.setLastname("lastname");

        // category to
        testCategoryTo = new CategoryTo();
        testCategoryTo.setCategory("Parkett");
        testCategoryTo.setId(1);

        // seat to
        testSeatTo = new SeatTo();
        testSeatTo.setId(104);
        testSeatTo.setCategory(testCategoryTo);
        testSeatTo.setNumber("14");
        testSeatTo.setRow("6");
        testSeatTo.setX(380);
        testSeatTo.setY(220);
        testSeatTo.setPrice(testPriceTo);

        testSeatToList = new ArrayList<>();
        testSeatToList.add(testSeatTo);

        // booking to
        testBookingTo = new BookingTo();
        testBookingTo.setCustomer(testCustomerTo);
        testBookingTo.setId(1);
        testBookingTo.setPaymentoption("giftcard");
        testBookingTo.setSeats(testSeatToList);
        testBookingTo.setSessiontoken("sessiontoken");
        testBookingTo.setShowId(30);
        testBookingTo.setVerification("4444");

        // show to
        testShowTo = new ShowTo();
        testShowTo.setId(1);

        // block to
        testBlockWithSessionToken = new BlockToWithSessiontoken();
        testBlockWithSessionToken.setId(0);
        testBlockWithSessionToken.setSeat(testSeatTo);
        testBlockWithSessionToken.setSessiontoken("sessiontoken");
        testBlockWithSessionToken.setShow(testShowTo);

    }

    @Test
    public void testCompleteReservation ( )
    {
        // create reservation
        ReservationTo receivedReservationToFromPost = null;
        ReservationTo receivedReservationToFromGet = null;
        ReservationTo receivedReservationToFromDelete = null;
        String receivedAfterPost = null;
        String receivedAfterGet = null;
        String receivedAfterDelete = null;

        try
        {
            receivedAfterPost = testReservationResource.postTickets(JSONConverter.toJSON(testBookingTo)).getEntity().toString();
            receivedReservationToFromPost = (ReservationTo) JSONConverter.fromJSON(receivedAfterPost, ReservationTo.class);

            // check if reservation created is same
            long testReservationId = receivedReservationToFromPost.getId();
            receivedAfterGet = testReservationResource.getReservationById(String.valueOf(testReservationId)).getEntity().toString();
            receivedReservationToFromGet = (ReservationTo) JSONConverter.fromJSON(receivedAfterGet, ReservationTo.class);

            // delete reservation again
            receivedAfterDelete = testReservationResource.deleteReservationById(String.valueOf(testReservationId)).getEntity().toString();
            receivedReservationToFromDelete = (ReservationTo) JSONConverter.fromJSON(receivedAfterDelete, ReservationTo.class);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        assertThat(receivedReservationToFromPost.getId(), equalTo(receivedReservationToFromGet.getId()));
        assertThat(receivedReservationToFromPost.getCustomer(), equalTo(receivedReservationToFromGet.getCustomer()));
        assertThat(receivedReservationToFromPost.getTickets(), equalTo(receivedReservationToFromGet.getTickets()));

        assertThat(receivedReservationToFromGet.getId(), equalTo(receivedReservationToFromDelete.getId()));
        assertThat(receivedReservationToFromGet.getCustomer(), equalTo(receivedReservationToFromDelete.getCustomer()));
        assertThat(receivedReservationToFromGet.getTickets(), equalTo(receivedReservationToFromDelete.getTickets()));
    }

    @Test
    public void testBlockAndDeblockSeat ( )
    {
        BlockTo receivedBlockFromPost = null;
        BlockTo receivedBlockFromDelete = null;
        String receivedFromPost = null;
        String receivedFromDelete = null;

        try
        {
            // block seats
            receivedFromPost = testReservationResource.blockseat(JSONConverter.toJSON(testBlockWithSessionToken)).getEntity().toString();
            receivedBlockFromPost = (BlockTo) JSONConverter.fromJSON(receivedFromPost, BlockTo.class);

            // deblock seats
            receivedFromDelete = testReservationResource.deblockseat(JSONConverter.toJSON(testBlockWithSessionToken)).getEntity().toString();
            receivedBlockFromDelete = (BlockTo) JSONConverter.fromJSON(receivedFromDelete, BlockTo.class);
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assertThat(receivedBlockFromPost.getId(), equalTo(receivedBlockFromDelete.getId()));
        assertThat(receivedBlockFromPost.getSeat(), equalTo(receivedBlockFromDelete.getSeat()));
    }
}
