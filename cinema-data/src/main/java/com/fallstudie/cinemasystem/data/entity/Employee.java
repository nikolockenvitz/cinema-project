package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the employee database table.
 * 
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "@id")
@JsonIdentityReference(alwaysAsId = false)
@Entity
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    @Column(name = "age")
    private int    age;
    @Column(name = "email", columnDefinition = "VARCHAR(60)")
    private String email;
    @Column(name = "firstname", columnDefinition = "VARCHAR(40)")
    private String firstname;
    @Column(name = "lastname", columnDefinition = "VARCHAR(40)")
    private String lastname;

    public Employee( )
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

    public int getAge ( )
    {
        return this.age;
    }

    public void setAge ( int age )
    {
        this.age = age;
    }

    public String getEmail ( )
    {
        return this.email;
    }

    public void setEmail ( String email )
    {
        this.email = email;
    }

    public String getFirstname ( )
    {
        return this.firstname;
    }

    public void setFirstname ( String firstname )
    {
        this.firstname = firstname;
    }

    public String getLastname ( )
    {
        return this.lastname;
    }

    public void setLastname ( String lastname )
    {
        this.lastname = lastname;
    }

}