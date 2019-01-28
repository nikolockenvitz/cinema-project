package com.fallstudie.cinemasystem.common.transferobject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerTo
{
    @Override
    public int hashCode ( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateofbirth == null) ? 0 : dateofbirth.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + isAdmin;
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + ((pwhash == null) ? 0 : pwhash.hashCode());
        result = prime * result + ((sessiontoken == null) ? 0 : sessiontoken.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
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
        CustomerTo other = (CustomerTo) obj;
        if ( dateofbirth == null )
        {
            if ( other.dateofbirth != null )
                return false;
        } else if ( !dateofbirth.equals(other.dateofbirth) )
            return false;
        if ( email == null )
        {
            if ( other.email != null )
                return false;
        } else if ( !email.equals(other.email) )
            return false;
        if ( firstname == null )
        {
            if ( other.firstname != null )
                return false;
        } else if ( !firstname.equals(other.firstname) )
            return false;
        if ( id != other.id )
            return false;
        if ( isAdmin != other.isAdmin )
            return false;
        if ( lastname == null )
        {
            if ( other.lastname != null )
                return false;
        } else if ( !lastname.equals(other.lastname) )
            return false;
        if ( pwhash == null )
        {
            if ( other.pwhash != null )
                return false;
        } else if ( !pwhash.equals(other.pwhash) )
            return false;
        if ( sessiontoken == null )
        {
            if ( other.sessiontoken != null )
                return false;
        } else if ( !sessiontoken.equals(other.sessiontoken) )
            return false;
        if ( username == null )
        {
            if ( other.username != null )
                return false;
        } else if ( !username.equals(other.username) )
            return false;
        return true;
    }

    private long   id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String dateofbirth;
    private int    isAdmin;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String sessiontoken;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

    public String getDateofbirth ( )
    {
        return dateofbirth;
    }

    public void setDateofbirth ( String dateofbirth )
    {
        this.dateofbirth = dateofbirth;
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
