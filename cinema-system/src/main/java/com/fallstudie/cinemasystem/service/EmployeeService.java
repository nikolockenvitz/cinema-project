package com.fallstudie.cinemasystem.service;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.exception.GeneralException;
import com.fallstudie.cinemasystem.common.json.JSONConverter;
import com.fallstudie.cinemasystem.common.transferobject.EmployeeTo;
import com.fallstudie.cinemasystem.common.urlhelper.URLS;
import com.fallstudie.cinemasystem.common.urlhelper.UrlCallHelper;

public class EmployeeService
{

    private static final Logger LOGGER        = LoggerFactory.getLogger(EmployeeService.class);
    private UrlCallHelper       urlCallHelper = new UrlCallHelper();

    public EmployeeService( )
    {

    }

    @SuppressWarnings("unchecked")
    public List<EmployeeTo> getAllEmployees ( ) throws IOException, GeneralException
    {
        Map<String, String> parameters = new HashMap<>();
        String json = urlCallHelper.sendGet(URLS.CINEMASYSTEM_DATA_EMPLOYEE + URLS.GETALLEMPLOYEES, parameters, MediaType.TEXT_PLAIN);
        List<EmployeeTo> employeeTos = (List<EmployeeTo>) JSONConverter.fromJSONList(json, EmployeeTo.class);
        return employeeTos;
    }

    public EmployeeTo getEmployeeById ( String id ) throws IOException, GeneralException
    {
        Map<String, String> parameters = new HashMap<>();
        String json = urlCallHelper.sendGet(URLS.CINEMASYSTEM_DATA_EMPLOYEE + id, parameters, MediaType.TEXT_PLAIN);
        EmployeeTo employeeTo = (EmployeeTo) JSONConverter.fromJSON(json, EmployeeTo.class);
        return employeeTo;
    }

    public EmployeeTo save ( EmployeeTo employeeTo ) throws IOException, GeneralException
    {
        URL url = new URL(URLS.CINEMASYSTEM_DATA_EMPLOYEE);
        Map<String, String> parameters = new HashMap<>();
        String rqJson = JSONConverter.toJSON(employeeTo);
        parameters.put("employee", rqJson);
        String json = urlCallHelper.sendPost(url, parameters, MediaType.APPLICATION_JSON);
        EmployeeTo savedMovieTo = (EmployeeTo) JSONConverter.fromJSON(json, EmployeeTo.class);
        return savedMovieTo;
    }

}
