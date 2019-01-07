package com.fallstudie.kinobuchungssystem.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.kinobuchungssystem.common.transferobject.MovieTo;

public class MovieService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

    public MovieService( )
    {

    }

    public List<MovieTo> getAllMovies ( )
    {
        List<MovieTo> movieTos = new ArrayList<>();

        return movieTos;
    }

}
