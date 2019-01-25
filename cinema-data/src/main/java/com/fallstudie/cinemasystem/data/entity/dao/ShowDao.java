package com.fallstudie.cinemasystem.data.entity.dao;

import java.util.List;

import javax.persistence.Query;

import com.fallstudie.cinemasystem.data.entity.Show;
import com.fallstudie.cinemasystem.data.entity.Ticket;
import com.fallstudie.cinemasystem.data.entity.query.MovieQuery;
import com.fallstudie.cinemasystem.data.entity.query.QueryParam;
import com.fallstudie.cinemasystem.data.entity.query.ShowQuery;

public class ShowDao extends BaseDao<Show>
{

    @Override
    public int count ( Show crsRequest )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Show find ( long id )
    {
        Show show = getEm().find(Show.class, id);
        return show;
    }

    @SuppressWarnings("unchecked")
    public List<Ticket> getAllTicketsForShow ( Long showId )
    {
        List<Ticket> resultList = null;
        Query query = getEm().createNamedQuery(MovieQuery.FIND_TICKETS_BY_SHOW_ID);
        query.setParameter(QueryParam.SHOW_ID, showId);
        resultList = query.getResultList();
        return resultList;
    }

    @SuppressWarnings("unchecked")
    public List<Show> getAllShowsByMovieId ( Long movieId )
    {
        List<Show> resultList = null;
        Query query = getEm().createNamedQuery(ShowQuery.FIND_SHOWS_BY_MOVIE_ID);
        query.setParameter(QueryParam.MOVIE_ID, movieId);
        resultList = query.getResultList();
        return resultList;
    }

}
