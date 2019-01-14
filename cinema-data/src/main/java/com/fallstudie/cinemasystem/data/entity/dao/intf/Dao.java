package com.fallstudie.cinemasystem.data.entity.dao.intf;

public interface Dao<T>
{

    T persist ( T request );

    int count ( T crsRequest );

    T find ( long id );

    boolean contains ( T crsRequest );

    T merge ( T object );

}
