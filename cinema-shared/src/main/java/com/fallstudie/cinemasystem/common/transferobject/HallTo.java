package com.fallstudie.cinemasystem.common.transferobject;

public class HallTo
{
    private long   id;
    private String name;
    private int    width;
    private int    length;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getName ( )
    {
        return name;
    }

    public void setName ( String name )
    {
        this.name = name;
    }

    public int getWidth ( )
    {
        return width;
    }

    public void setWidth ( int width )
    {
        this.width = width;
    }

    public int getLength ( )
    {
        return length;
    }

    public void setLength ( int length )
    {
        this.length = length;
    }

}
