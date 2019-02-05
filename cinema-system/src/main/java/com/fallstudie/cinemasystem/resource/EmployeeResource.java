package com.fallstudie.cinemasystem.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import com.fallstudie.cinemasystem.service.EmployeeService;

@Path("/employee")
public class EmployeeResource
{
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeResource.class);

    private static final MediaType errorMedia = MediaType.TEXT_PLAIN_TYPE;

    private static final MediaType media = MediaType.APPLICATION_JSON_TYPE;

    private EmployeeService employeeService;

    private ResponseBuilder responseBuilder;

    public EmployeeResource( )
    {
        this.employeeService = new EmployeeService();
        this.responseBuilder = new ResponseBuilder();
    }

    @GET
    @Path("{id}")
    @Propagate
    @Description(value = "Method to get an employee by id!")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response getEmployeeById ( @PathParam("id") String id )
    {
        String json = "";
        try
        {
            EmployeeTo employeeTo = employeeService.getEmployeeById(id);
            json = JSONConverter.toJSON(employeeTo);
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(errorMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(media, json);
    }

    @GET
    @Path("getAllEmployees")
    @Propagate
    @Description(value = "Method to get all employees!")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response getAllEmployees ( )
    {
        String json = "";
        try
        {
            List<EmployeeTo> employeeTos = employeeService.getAllEmployees();
            json = JSONConverter.toJSON(employeeTos);
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return responseBuilder.buildResponse(errorMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(media, json);
    }

    @POST
    @Propagate
    @Description(value = "Method to save an employee!")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public Response saveEmployee ( @FormParam("employee") String employeeJson )
    {
        String json = null;
        try
        {
            EmployeeTo employeeToToSave = (EmployeeTo) JSONConverter.fromJSON(employeeJson, EmployeeTo.class);
            EmployeeTo savedEmployee = employeeService.save(employeeToToSave);
            json = JSONConverter.toJSON(savedEmployee);
        } catch (Throwable e)
        {
            return responseBuilder.buildResponse(errorMedia, e.getMessage(), e);
        }
        return responseBuilder.buildResponse(media, json);
    }
}
