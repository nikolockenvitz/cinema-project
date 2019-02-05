package com.fallstudie.cinemasystem.common.urlhelper;

public interface URLS
{

    public final String SERVER = "http://localhost:8080/";

    public final String APPNAME = "cinema-data/";

    public final String CINEMASYSTEM_DATA_MOVIE = SERVER + APPNAME + "movie/";

    public final String GETALLMOVIES = "getAllMovies/";

    public final String CINEMASYSTEM_DATA_SHOW = SERVER + APPNAME + "show/";

    public final String GETSHOW = "getShow/";

    public final String GETALLSHOWS = "getAllShows/";

    public final String CINEMASYSTEM_DATA_RESERVATION = SERVER + APPNAME + "reservation/";

    public final String BOOK = "book/";

    public final String DELETE = "delete/";

    public final String BLOCK = "block/";

    public final String CINEMASYSTEM_DATA_EMPLOYEE = SERVER + APPNAME + "employee/";

    public final String GETALLEMPLOYEES = "getAllEmployees/";

}
