package com.fallstudie.cinemasystem.common.responsebuilder;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;

import com.fallstudie.cinemasystem.common.exception.NoMatchException;
import com.fallstudie.cinemasystem.common.exception.NullInputException;

public class ResponseBuilder
{

    public Response buildResponse ( MediaType mediaType, String message )
    {
        return Response.status(Status.OK).type(mediaType).entity(message).build();
    }

    public Response buildResponse ( Status status, MediaType mediaType, String message )
    {
        return Response.status(status).type(mediaType).entity(message).build();
    }

    public Response buildResponse ( MediaType mediaType, String message, Throwable throwable )
    {
        Status status = Status.INTERNAL_SERVER_ERROR;
        if ( throwable instanceof NoMatchException )
        {
            status = Status.NOT_ACCEPTABLE;
        } else if ( throwable instanceof NullInputException )
        {
            status = Status.BAD_REQUEST;
        } else if ( throwable instanceof Throwable )
        {
            if ( StringUtils.isBlank(message) )
            {
                message = throwable.toString();
            }
        }
        return Response.status(status).type(mediaType).entity(message).build();
    }
}
