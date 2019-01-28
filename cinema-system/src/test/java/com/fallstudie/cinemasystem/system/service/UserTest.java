package com.fallstudie.cinemasystem.system.service;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

import com.fallstudie.cinemasystem.common.json.JSONConverter;
import com.fallstudie.cinemasystem.common.transferobject.CustomerTo;
import com.fallstudie.cinemasystem.system.ToCreator;

public class UserTest
{

    @Test
    public void CustomerToJSON ( ) throws Exception
    {
        CustomerTo customerTo = ToCreator.createCustomer();
        String rqJson = JSONConverter.toJSON(customerTo);
        assertThat(rqJson, not(containsString("sessiontoken")));
        assertThat(rqJson, not(containsString("pwhash")));
        assertThat(rqJson, containsString("1"));
    }

}
