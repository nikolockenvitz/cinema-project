package com.fallstudie.cinemasystem.common.transferobject;

public class ActorTo
{
    private long   id;
    private String firstname;
    private String lastname;
    private String birthdate;

    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
        ActorTo other = (ActorTo) obj;
        if ( birthdate == null )
        {
            if ( other.birthdate != null )
                return false;
        } else if ( !birthdate.equals(other.birthdate) )
            return false;
        if ( firstname == null )
        {
            if ( other.firstname != null )
                return false;
        } else if ( !firstname.equals(other.firstname) )
            return false;
        if ( id != other.id )
            return false;
        if ( lastname == null )
        {
            if ( other.lastname != null )
                return false;
        } else if ( !lastname.equals(other.lastname) )
            return false;
        return true;
    }

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getFirstname ( )
    {
        return firstname;
    }

    public void setFirstname ( String firstname )
    {
        this.firstname = firstname;
    }

    public String getLastname ( )
    {
        return lastname;
    }

    public void setLastname ( String lastname )
    {
        this.lastname = lastname;
    }

    public String getBirthdate ( )
    {
        return birthdate;
    }

    public void setBirthdate ( String birthdate )
    {
        this.birthdate = birthdate;
    }

}
