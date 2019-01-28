package com.fallstudie.cinemasystem.common.transferobject;

public class GenreTo
{
    private long   id;
    private String genre;

    public long getId ( )
    {
        return id;
    }

    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals ( Object obj )
    {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        GenreTo other = (GenreTo) obj;
        if ( genre == null )
        {
            if ( other.genre != null )
                return false;
        } else if ( !genre.equals(other.genre) )
            return false;
        if ( id != other.id )
            return false;
        return true;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getGenre ( )
    {
        return genre;
    }

    public void setGenre ( String genre )
    {
        this.genre = genre;
    }

}
