package com.fallstudie.kinobuchungssystem.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "@id")
@JsonIdentityReference(alwaysAsId = false)
@Entity
@Table(name = "customer")
public class Customer implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private long   id;
    @Column(name = "firstname", columnDefinition = "varchar(40)")
    private String firstname;
    @Column(name = "lastname", columnDefinition = "varchar(40)")
    private String lastname;
    @Column(name = "username", columnDefinition = "varchar(40)")
    private String username;
    @Temporal(TemporalType.DATE)
    @Column(name = "dateofbirth")
    private Date   dateofbirth;
    @Column(name = "email", columnDefinition = "varchar(80)")
    private String email;
    private String pwhash;
    private int    isadmin;
    private String sessiontoken;

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

    public Date getDateofbirth ( )
    {
        return dateofbirth;
    }

    public void setDateofbirth ( Date dateofbirth )
    {
        this.dateofbirth = dateofbirth;
    }

    public String getEmail ( )
    {
        return email;
    }

    public void setEmail ( String email )
    {
        this.email = email;
    }

    public String getPwhash ( )
    {
        return pwhash;
    }

    public void setPwhash ( String pwhash )
    {
        this.pwhash = pwhash;
    }

    public int getIsadmin ( )
    {
        return isadmin;
    }

    public void setIsadmin ( int isadmin )
    {
        this.isadmin = isadmin;
    }

    public String getSessiontoken ( )
    {
        return sessiontoken;
    }

    public void setSessiontoken ( String sessiontoken )
    {
        this.sessiontoken = sessiontoken;
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
