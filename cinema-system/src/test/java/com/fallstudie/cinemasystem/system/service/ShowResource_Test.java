package com.fallstudie.cinemasystem.system.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.resource.ShowResource;

public class ShowResource_Test
{

    ShowResource testShowResource = null;
    String       testShowJSON     = null;
    ShowTo       testShowTo       = null;

    @Before
    public void initalize ( )
    {
        testShowResource = new ShowResource();
        testShowJSON = "\"id\":0,\"date\":\"16.02.2019\",\"time\":\"23:00\",\"weekday\":\"Samstag\"";

    }

    @Test
    public void testGetShowById ( )
    {
        assertThat(true, equalTo(testShowResource.getShowById("0").getEntity().toString().contains(testShowJSON)));
    }

    @Test
    public void testGetAllShowsByMovieId ( )
    {
        assertThat(true, equalTo(testShowResource.getAllShowsByMovieID("1").getEntity().toString().contains(testShowJSON)));
    }

}
