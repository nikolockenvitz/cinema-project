package com.fallstudie.cinemasystem.system.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.fallstudie.cinemasystem.common.json.JSONConverter;
import com.fallstudie.cinemasystem.common.transferobject.MovieTo;
import com.fallstudie.cinemasystem.common.transferobject.ShowTo;
import com.fallstudie.cinemasystem.resource.ShowResource;

public class ShowResource_Test {

    ShowResource  testShowResource  = null;
    String        testShowJSON     = null;
    String        testShowJSONPost = null;
    ShowTo        testShowTo        = null;
    MovieTo       testMovieTo       = null;
    ArrayList     emptyList         = null;
    
	@Before
	public void initalize() {
		testShowResource = new ShowResource();
		testShowJSON = "{\"id\":100,\"date\":\"16.02.2019\",\"time\":\"23:00\",\"weekday\":\"Samstag\",\"movie\":null,\"hall\":null,\"3D\":true}";
		emptyList = new ArrayList<>();
		
		testShowTo = new ShowTo();
		testShowTo.setId(100);
		testShowTo.setDate("16.02.2019");
		testShowTo.setHall(null);
		testShowTo.setWeekday("Samstag");
		testShowTo.setMovie(null);
		testShowTo.setIs3D(true);
		testShowTo.setTime("23:00");
		
				
	}
	
	@Test
	public void testGetShowId() {
        assertThat(testShowJSON, equalTo(testShowResource.getShowById("0").getEntity()));
	}
	
	@Test
	public void testGetAllShowsByMovieId() {
        assertThat(true, equalTo(testShowResource.getAllShowsByMovieID("0").getEntity().toString().contains(testShowJSON)));
	}
	
}
