package com.fallstudie.kinobuchungssystem.common.transferobject;

import java.util.Date;

public class ActorTo
{
    private long   id;
    private String firstname;
    private String lastname;
    private Date   birthdate;

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

    public Date getBirthdate ( )
    {
        return birthdate;
    }

    public void setBirthdate ( Date birthdate )
    {
        this.birthdate = birthdate;
    }

}
