package com.fallstudie.kinobuchungssystem.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "USER_ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
    private long id;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;
    @Column(name = "isadmin")
    private int    isAdmin;
    @Column(name = "name", columnDefinition = "VARCHAR(30)")
    private String name;
    @Column(name = "pwhash", columnDefinition = "VARCHAR(255)")
    private String pwhash;
    @Column(name = "sessiontoken", columnDefinition = "VARCHAR(255)")
    private String sessiontoken;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = false)
    // bi-directional many-to-many association to Rating
    @OneToMany(mappedBy = "user", targetEntity = Rating.class)
    private List<Rating> ratings;

    public User( )
    {
    }

    public long getId ( )
    {
        return this.id;
    }

    public void setId ( long id )
    {
        this.id = id;
    }

    public Date getBirthday ( )
    {
        return this.birthday;
    }

    public void setBirthday ( Date birthday )
    {
        this.birthday = birthday;
    }

    public String getEmail ( )
    {
        return this.email;
    }

    public void setEmail ( String email )
    {
        this.email = email;
    }

    public int getIsAdmin ( )
    {
        return isAdmin;
    }

    public void setIsAdmin ( int isAdmin )
    {
        this.isAdmin = isAdmin;
    }

    public String getName ( )
    {
        return name;
    }

    public void setName ( String name )
    {
        this.name = name;
    }

    public String getPwhash ( )
    {
        return pwhash;
    }

    public void setPwhash ( String pwhash )
    {
        this.pwhash = pwhash;
    }

    public String getSessiontoken ( )
    {
        return sessiontoken;
    }

    public void setSessiontoken ( String sessiontoken )
    {
        this.sessiontoken = sessiontoken;
    }

    public List<Rating> getRatings ( )
    {
        return ratings;
    }

    public void setRatings ( List<Rating> ratings )
    {
        this.ratings = ratings;
    }

}