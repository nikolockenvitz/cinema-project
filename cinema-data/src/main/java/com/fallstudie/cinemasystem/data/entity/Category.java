package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the category database table.
 * 
 */

@Entity
@Table(name = "category")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "category", columnDefinition = "VARCHAR(15)")
    private String category;

    // bi-directional many-to-one association to Seat
    @OneToMany(mappedBy = "category", targetEntity = Seat.class)
    private List<Seat> seats;

    public Category( )
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

    public String getCategory ( )
    {
        return category;
    }

    public void setCategory ( String category )
    {
        this.category = category;
    }

    public List<Seat> getSeats ( )
    {
        return seats;
    }

    public void setSeats ( List<Seat> seats )
    {
        this.seats = seats;
    }

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((category == null) ? 0 : category.hashCode());
//		result = prime * result + (int) (id ^ (id >>> 32));
//		result = prime * result + ((seats == null) ? 0 : seats.hashCode());
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
//		Category other = (Category) obj;
//		if (category == null) {
//			if (other.category != null)
//				return false;
//		} else if (!category.equals(other.category))
//			return false;
//		if (id != other.id)
//			return false;
//		if (seats == null) {
//			if (other.seats != null)
//				return false;
//		} else if (!seats.equals(other.seats))
//			return false;
//		return true;
//	}

}