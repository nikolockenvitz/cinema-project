package com.fallstudie.kinobuchungssystem.common.transferobject;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference(alwaysAsId = false)
public class UserTo
{
    private long           id;
    private String         name;
    private String         email;
    private Date           birthday;
    private int            isAdmin;
    private String         sessiontoken;
    private String         pwhash;
    private List<RatingTo> ratings;

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

    public List<RatingTo> getRatings ( )
    {
        return ratings;
    }

    public void setRatings ( List<RatingTo> ratings )
    {
        this.ratings = ratings;
    }

}
