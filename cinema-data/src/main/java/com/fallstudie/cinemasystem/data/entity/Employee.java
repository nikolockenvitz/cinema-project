package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Column(name = "dateofbirth")
    @Temporal(TemporalType.DATE)
    private Date   dateofbirth;
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

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((dateofbirth == null) ? 0 : dateofbirth.hashCode());
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
//		result = prime * result + (int) (id ^ (id >>> 32));
//		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Employee other = (Employee) obj;
//		if (dateofbirth == null) {
//			if (other.dateofbirth != null)
//				return false;
//		} else if (!dateofbirth.equals(other.dateofbirth))
//			return false;
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
//		if (firstname == null) {
//			if (other.firstname != null)
//				return false;
//		} else if (!firstname.equals(other.firstname))
//			return false;
//		if (id != other.id)
//			return false;
//		if (lastname == null) {
//			if (other.lastname != null)
//				return false;
//		} else if (!lastname.equals(other.lastname))
//			return false;
//		return true;
//	}

}