package com.fallstudie.cinemasystem.common.transferobject;

public class ActorTo
{
    private long   id;
    private String firstname;
    private String lastname;
    private String birthdate;

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
