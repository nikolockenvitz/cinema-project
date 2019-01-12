package com.fallstudie.kinobuchungssystem.common.transferobject;

public class EmployeeTo
{
    private long   id;
    private String firstname;
    private String lastname;
    private int    age;
    private String email;

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

    public int getAge ( )
    {
        return age;
    }

    public void setAge ( int age )
    {
        this.age = age;
    }

    public String getEmail ( )
    {
        return email;
    }

    public void setEmail ( String email )
    {
        this.email = email;
    }

}
