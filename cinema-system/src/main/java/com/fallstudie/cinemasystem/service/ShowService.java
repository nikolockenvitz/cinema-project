package com.fallstudie.cinemasystem.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.exception.GeneralException;
import com.fallstudie.cinemasystem.common.json.JSONConverter;
import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.common.urlhelper.URLS;
import com.fallstudie.cinemasystem.common.urlhelper.UrlCallHelper;

public class ShowService
{

    private static final Logger LOGGER        = LoggerFactory.getLogger(ShowService.class);
    private UrlCallHelper       urlCallHelper = new UrlCallHelper();

    public ShowService( )
    {

    }

    public ShowTo getShowById ( String id ) throws IOException, GeneralException
    {
        Map<String, String> parameters = new HashMap<>();
        String json = urlCallHelper.sendGet(URLS.KINOBUCHUNGSSYSTEM_DATA_SHOW + id, parameters, MediaType.TEXT_PLAIN);
        ShowTo showTo = (ShowTo) JSONConverter.fromJSON(json, ShowTo.class);
        return showTo;
    }

    public void bookSeats ( ShowTo showTo )
    {
        // TODO Auto-generated method stub

    }

}
