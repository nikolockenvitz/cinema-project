package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", orphanRemoval = true)
    private List<Reservation> reservations;

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

    public List<Reservation> getReservations ( )
    {
        return reservations;
    }

    public void setReservations ( List<Reservation> reservations )
    {
        this.reservations = reservations;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateofbirth == null) ? 0 : dateofbirth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + isadmin;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((pwhash == null) ? 0 : pwhash.hashCode());
		result = prime * result + ((reservations == null) ? 0 : reservations.hashCode());
		result = prime * result + ((sessiontoken == null) ? 0 : sessiontoken.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (dateofbirth == null) {
			if (other.dateofbirth != null)
				return false;
		} else if (!dateofbirth.equals(other.dateofbirth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id != other.id)
			return false;
		if (isadmin != other.isadmin)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (pwhash == null) {
			if (other.pwhash != null)
				return false;
		} else if (!pwhash.equals(other.pwhash))
			return false;
		if (reservations == null) {
			if (other.reservations != null)
				return false;
		} else if (!reservations.equals(other.reservations))
			return false;
		if (sessiontoken == null) {
			if (other.sessiontoken != null)
				return false;
		} else if (!sessiontoken.equals(other.sessiontoken))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
