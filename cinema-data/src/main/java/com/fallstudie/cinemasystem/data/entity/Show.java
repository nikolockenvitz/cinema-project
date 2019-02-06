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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import com.fallstudie.cinemasystem.data.entity.query.ShowQuery;

/**
 * The persistent class for the show database table.
 * 
 */
@Entity
@Table(name = "show")
@CascadeOnDelete
@NamedQueries({ @NamedQuery(name = "Show.findAll", query = "SELECT s FROM Show s"),
        @NamedQuery(name = ShowQuery.FIND_SHOWS_BY_MOVIE_ID_QNAME, query = ShowQuery.FIND_SHOWS_BY_MOVIE_ID) })
public class Show implements Serializable, Comparable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;

    @Column(name = "is3d")
    private boolean is3D;

    // bi-directional one-to-many association to Ticket
    @OneToMany(mappedBy = "show", fetch = FetchType.LAZY, targetEntity = Ticket.class)
    private List<Ticket> tickets;

    // bi-directional many-to-one association to Movie
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Movie.class)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    // bi-directional many-to-one association to Hall
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Hall.class)
    @JoinColumn(name = "hall_id")
    private Hall hall;

    // bi-directional one-to-many association to Block
    @OneToMany(mappedBy = "show", fetch = FetchType.LAZY, targetEntity = Block.class)
    private List<Block> blocks;

    public Show( )
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

    public List<Ticket> getTickets ( )
    {
        return tickets;
    }

    public void setTickets ( List<Ticket> tickets )
    {
        this.tickets = tickets;
    }

    public Movie getMovie ( )
    {
        return movie;
    }

    public void setMovie ( Movie movie )
    {
        this.movie = movie;

    }

    public Hall getHall ( )
    {
        return hall;
    }

    public void setHall ( Hall hall )
    {
        this.hall = hall;
    }

    public boolean is3D ( )
    {
        return is3D;
    }

    public void setIs3D ( boolean is3d )
    {
        is3D = is3d;
    }

    public Date getDate ( )
    {
        return date;
    }

    public void setDate ( Date date )
    {
        this.date = date;
    }

    public Date getTime ( )
    {
        return time;
    }

    public void setTime ( Date time )
    {
        this.time = time;
    }

    public Ticket addTicket ( Ticket ticket )
    {
        getTickets().add(ticket);
        ticket.setShow(this);
        return ticket;
    }

    public Ticket removeTicket ( Ticket ticket )
    {
        getTickets().remove(ticket);
        ticket.setShow(null);
        return ticket;
    }
    
	@Override
	public int compareTo(Object compareObject) {
		if(this.getClass() == compareObject.getClass()) {
			Show compareShow = (Show) compareObject;
			if(this.getId() == compareShow.getId()) {
				if(this.getDate().equals(compareShow.getDate())) {
					if(this.getTime().equals(compareShow.getTime())) {
						if(this.getHall().equals(compareShow.getHall())) {
							if(this.getMovie().equals(compareShow.getMovie())) {
								return 0;
							}
						}
					}
				}
			}
		}
		return 1;
	}
//
//    @Override
//    public int hashCode ( )
//    {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((date == null) ? 0 : date.hashCode());
//        result = prime * result + ((hall == null) ? 0 : hall.hashCode());
//        result = prime * result + (int) (id ^ (id >>> 32));
//        result = prime * result + (is3D ? 1231 : 1237);
//        result = prime * result + ((movie == null) ? 0 : movie.hashCode());
//        result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
//        result = prime * result + ((time == null) ? 0 : time.hashCode());
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
//        Show other = (Show) obj;
//        if ( date == null )
//        {
//            if ( other.date != null )
//                return false;
//        } else if ( !date.equals(other.date) )
//            return false;
//        if ( hall == null )
//        {
//            if ( other.hall != null )
//                return false;
//        } else if ( !hall.equals(other.hall) )
//            return false;
//        if ( id != other.id )
//            return false;
//        if ( is3D != other.is3D )
//            return false;
//        if ( movie == null )
//        {
//            if ( other.movie != null )
//                return false;
//        } else if ( !movie.equals(other.movie) )
//            return false;
//        if ( tickets == null )
//        {
//            if ( other.tickets != null )
//                return false;
//        } else if ( !tickets.equals(other.tickets) )
//            return false;
//        if ( time == null )
//        {
//            if ( other.time != null )
//                return false;
//        } else if ( !time.equals(other.time) )
//            return false;
//        return true;
//    }

}