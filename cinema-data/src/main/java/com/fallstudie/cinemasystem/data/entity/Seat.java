package com.fallstudie.cinemasystem.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 * The persistent class for the seat database table.
 * 
 */
@Entity
@Table(name = "seat")
@CascadeOnDelete
@NamedQuery(name = "Seat.findAll", query = "SELECT s FROM Seat s")
public class Seat implements Serializable, Comparable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number")
    private String number;

    @Column(name = "row")
    private String row;

    @Column(name = "y")
    private int y;

    @Column(name = "x")
    private int x;

    // bi-directional many-to-one association to Ticket
    @OneToMany(mappedBy = "seat", targetEntity = Ticket.class)
    private List<Ticket> tickets;

    // bi-directional many-to-one association to Hall
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Hall.class)
    @JoinColumn(name = "hall_id")
    private Hall hall;

    // bi-directional many-to-one association to Category
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    public Seat( )
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

    public String getNumber ( )
    {
        return number;
    }

    public void setNumber ( String number )
    {
        this.number = number;
    }

    public String getRow ( )
    {
        return row;
    }

    public void setRow ( String row )
    {
        this.row = row;
    }

    public Hall getHall ( )
    {
        return hall;
    }

    public void setHall ( Hall hall )
    {
        this.hall = hall;
    }

    public Category getCategory ( )
    {
        return category;
    }

    public void setCategory ( Category category )
    {
        this.category = category;
    }

    public List<Ticket> getTickets ( )
    {
        return tickets;
    }

    public void setTickets ( List<Ticket> tickets )
    {
        this.tickets = tickets;
    }

    public int getY ( )
    {
        return y;
    }

    public void setY ( int y )
    {
        this.y = y;
    }

    public int getX ( )
    {
        return x;
    }

    public void setX ( int x )
    {
        this.x = x;
    }

	@Override
	public int compareTo(Object o) {
		if(this.getClass() == o.getClass()) {
			Seat compareSeat = (Seat) o;
			if(this.getId()==compareSeat.getId() &&
			   this.getX()==compareSeat.getX() &&
			   this.getY()==compareSeat.getY() &&
			   this.getNumber() != null && this.getNumber().equals(compareSeat.getNumber()) &&
			   this.getRow() != null && this.getRow().equals(compareSeat.getRow()) &&
			   (this.getHall() != null && this.getHall().compareTo(compareSeat.getHall()) == 0) &
			   this.getCategory() != null && this.getCategory().compareTo(compareSeat.getCategory()) == 0) {
				return 0;
			}
		}
		return 1;
	}

//    public Ticket addTicket ( Ticket ticket )
//    {
//        getTickets().add(ticket);
//        ticket.setSeat(this);
//        return ticket;
//    }
//
//    public Ticket removeTicket ( Ticket ticket )
//    {
//        getTickets().remove(ticket);
//        ticket.setSeat(null);
//        return ticket;
//    }
//
//    @Override
//    public int hashCode ( )
//    {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((category == null) ? 0 : category.hashCode());
//        result = prime * result + ((hall == null) ? 0 : hall.hashCode());
//        result = prime * result + (int) (id ^ (id >>> 32));
//        result = prime * result + ((number == null) ? 0 : number.hashCode());
//        result = prime * result + ((row == null) ? 0 : row.hashCode());
//        result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
//        result = prime * result + x;
//        result = prime * result + y;
//        return result;
//    }
//
//    @Override
//    public boolean equals ( Object obj )
//    {
//        if ( this == obj )
//            return true;
//        if ( obj == null )
//            return false;
//        if ( getClass() != obj.getClass() )
//            return false;
//        Seat other = (Seat) obj;
//        if ( category == null )
//        {
//            if ( other.category != null )
//                return false;
//        } else if ( !category.equals(other.category) )
//            return false;
//        if ( hall == null )
//        {
//            if ( other.hall != null )
//                return false;
//        } else if ( !hall.equals(other.hall) )
//            return false;
//        if ( id != other.id )
//            return false;
//        if ( number == null )
//        {
//            if ( other.number != null )
//                return false;
//        } else if ( !number.equals(other.number) )
//            return false;
//        if ( row == null )
//        {
//            if ( other.row != null )
//                return false;
//        } else if ( !row.equals(other.row) )
//            return false;
//        if ( tickets == null )
//        {
//            if ( other.tickets != null )
//                return false;
//        } else if ( !tickets.equals(other.tickets) )
//            return false;
//        if ( x != other.x )
//            return false;
//        if ( y != other.y )
//            return false;
//        return true;
//    }

}