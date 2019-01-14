package com.fallstudie.cinemasystem.common.transferobject;

import java.util.Date;

public class CustomerTo
{
    private long   id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private Date   birthday;
    private int    isAdmin;
    private String sessiontoken;
    private String pwhash;

    public long getId ( )
    {
        return id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public String getEmail ( )
    {
        return email;
    }

    public void setEmail ( String email )
    {
        this.email = email;
    }

    public Date getBirthday ( )
    {
        return birthday;
    }

    public void setBirthday ( Date birthday )
    {
        this.birthday = birthday;
    }

    public int getIsAdmin ( )
    {
        return isAdmin;
    }

    public void setIsAdmin ( int isAdmin )
    {
        this.isAdmin = isAdmin;
    }

    public String getSessiontoken ( )
    {
        return sessiontoken;
    }

    public void setSessiontoken ( String sessiontoken )
    {
        this.sessiontoken = sessiontoken;
    }

    public String getPwhash ( )
    {
        return pwhash;
    }

    public void setPwhash ( String pwhash )
    {
        this.pwhash = pwhash;
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

    public String getUsername ( )
    {
        return username;
    }

    public void setUsername ( String username )
    {
        this.username = username;
    }

}
