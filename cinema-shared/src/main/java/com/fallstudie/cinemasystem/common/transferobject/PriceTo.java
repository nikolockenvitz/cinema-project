package com.fallstudie.cinemasystem.common.transferobject;

public class PriceTo
{
    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + defaultPrice;
        result = prime * result + reducedPrice;
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
        PriceTo other = (PriceTo) obj;
        if ( defaultPrice != other.defaultPrice )
            return false;
        if ( reducedPrice != other.reducedPrice )
            return false;
        return true;
    }

    int reducedPrice;
    int defaultPrice;

    public int getReducedPrice ( )
    {
        return reducedPrice;
    }

    public void setReducedPrice ( int reducedPrice )
    {
        this.reducedPrice = reducedPrice;
    }

    public int getDefaultPrice ( )
    {
        return defaultPrice;
    }

    public void setDefaultPrice ( int defaultPrice )
    {
        this.defaultPrice = defaultPrice;
    }

}
