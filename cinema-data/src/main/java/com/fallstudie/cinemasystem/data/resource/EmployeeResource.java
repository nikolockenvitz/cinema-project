package com.fallstudie.cinemasystem.data.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.annotation.Description;
import com.fallstudie.cinemasystem.common.annotation.Propagate;
import com.fallstudie.cinemasystem.common.json.JSONConverter;
import com.fallstudie.cinemasystem.common.responsebuilder.ResponseBuilder;
import com.fallstudie.cinemasystem.common.transferobject.EmployeeTo;
import com.fallstudie.cinemasystem.data.service.EmployeeService;

@Path("/employee")
public class EmployeeResource
{

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeResource.class);

    private static final MediaType textMedia = MediaType.TEXT_PLAIN_TYPE;

    private static final MediaType jsonMedia = MediaType.APPLICATION_JSON_TYPE;

    private EmployeeService employeeService;

    private ResponseBuilder responseBuilder;

    public EmployeeResource( )
    {
        this.employeeService = new EmployeeService();
        this.responseBuilder = new ResponseBuilder();
    }

    @GET
    @Path("{id}")
    @Propagate()
    @Description(value = "Method to get an employee via id!")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response getEmployeeByID ( @PathParam("id") String id )
    {
        String json = null;
        try
        {
            EmployeeTo employeeTo = employeeService.getEmployee(id);
            json = JSONConverter.toJSON(employeeTo);
        } catch (Throwable e)
        {
            return responseBuilder.buildResponse(textMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(jsonMedia, json);
    }

    @GET
    @Path("getAllEmployees")
    @Propagate()
    @Description(value = "Method to get all employees!")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response getAllEmployees ( )
    {
        String json = null;
        try
        {
            List<EmployeeTo> employeeTos = employeeService.getAllEmployees();
            json = JSONConverter.toJSON(employeeTos);
        } catch (Throwable e)
        {
            return responseBuilder.buildResponse(textMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(jsonMedia, json);
    }
}
