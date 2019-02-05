package com.fallstudie.cinemasystem.service;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.exception.GeneralException;
import com.fallstudie.cinemasystem.common.json.JSONConverter;
import com.fallstudie.cinemasystem.common.transferobject.BlockTo;
import com.fallstudie.cinemasystem.common.transferobject.BlockToWithSessiontoken;
import com.fallstudie.cinemasystem.common.transferobject.BookingTo;
import com.fallstudie.cinemasystem.common.transferobject.ReservationTo;
import com.fallstudie.cinemasystem.common.urlhelper.URLS;
import com.fallstudie.cinemasystem.common.urlhelper.UrlCallHelper;

public class ReservationService
{

    private static final Logger LOGGER        = LoggerFactory.getLogger(ReservationService.class);
    private UrlCallHelper       urlCallHelper = new UrlCallHelper();

    public ReservationService( )
    {

    }

    public ReservationTo getReservationById ( String id ) throws IOException, GeneralException
    {
        Map<String, String> parameters = new HashMap<>();
        String json = urlCallHelper.sendGet(URLS.CINEMASYSTEM_DATA_RESERVATION + id, parameters, MediaType.TEXT_PLAIN);
        ReservationTo reservationTo = (ReservationTo) JSONConverter.fromJSON(json, ReservationTo.class);
        return reservationTo;
    }

    public ReservationTo createReservation ( BookingTo bookingTo ) throws IOException, GeneralException
    {
        URL url = new URL(URLS.CINEMASYSTEM_DATA_RESERVATION + URLS.BOOK);
        Map<String, String> parameters = new HashMap<>();
        String rqJson = JSONConverter.toJSON(bookingTo);
        parameters.put("book", rqJson);
        String json = urlCallHelper.sendPost(url, parameters, MediaType.APPLICATION_JSON);
        ReservationTo savedReservationTo = (ReservationTo) JSONConverter.fromJSON(json, ReservationTo.class);
        return savedReservationTo;
    }

    public ReservationTo deleteReservation ( String reservationId ) throws IOException, GeneralException
    {
        URL url = new URL(URLS.CINEMASYSTEM_DATA_RESERVATION + URLS.DELETE + reservationId);
        Map<String, String> parameters = new HashMap<>();
        String json = urlCallHelper.sendDelete(url, parameters, MediaType.TEXT_PLAIN);
        ReservationTo reservationTo = (ReservationTo) JSONConverter.fromJSON(json, ReservationTo.class);
        return reservationTo;
    }

    public BlockTo blockSeat ( BlockToWithSessiontoken blockToWithSessiontoken ) throws IOException, GeneralException
    {
        URL url = new URL(URLS.CINEMASYSTEM_DATA_RESERVATION + URLS.BLOCK);
        Map<String, String> parameters = new HashMap<>();
        String rqJson = JSONConverter.toJSON(blockToWithSessiontoken);
        parameters.put("block", rqJson);
        String json = urlCallHelper.sendPost(url, parameters, MediaType.APPLICATION_JSON);
        BlockTo createdblockTo = (BlockTo) JSONConverter.fromJSON(json, BlockTo.class);
        return createdblockTo;
    }

    public BlockTo deblockSeat ( BlockToWithSessiontoken blockToWithSessiontoken ) throws IOException, GeneralException
    {
        URL url = new URL(URLS.CINEMASYSTEM_DATA_RESERVATION + URLS.BLOCK);
        Map<String, String> parameters = new HashMap<>();
        String rqJson = JSONConverter.toJSON(blockToWithSessiontoken);
        parameters.put("block", rqJson);
        String json = urlCallHelper.sendDelete(url, parameters, MediaType.APPLICATION_JSON);
        BlockTo createdblockTo = (BlockTo) JSONConverter.fromJSON(json, BlockTo.class);
        return createdblockTo;
    }

}
