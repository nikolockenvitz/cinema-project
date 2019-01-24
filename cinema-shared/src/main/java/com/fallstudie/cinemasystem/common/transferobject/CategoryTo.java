package com.fallstudie.cinemasystem.common.transferobject;

public class CategoryTo
{
    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((category == null) ? 0 : category.hashCode());
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
        CategoryTo other = (CategoryTo) obj;
        if ( category == null )
        {
            if ( other.category != null )
                return false;
        } else if ( !category.equals(other.category) )
            return false;
        if ( id != other.id )
            return false;
        return true;
    }

    private long   id;
    private String category;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getCategory ( )
    {
        return category;
    }

    public void setCategory ( String category )
    {
        this.category = category;
    }

}
