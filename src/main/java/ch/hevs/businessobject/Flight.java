package ch.hevs.businessobject;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String flightNumber;
	private Date date;
	private String aircraftModel;
	private long price;
	
	// relations
	@ManyToOne
	@JoinColumn(name = "FK_DESTINATION_FROM")
	private Destination destinationFrom;
	
	@ManyToOne
	@JoinColumn(name = "FK_DESTINATION_TO")
	private Destination destinationTo;
	
	@ManyToMany
	private List<Passenger> passengers;

	// getters setters
	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAircraftModel() {
		return aircraftModel;
	}

	public void setAircraftModel(String aircraftModel) {
		this.aircraftModel = aircraftModel;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Destination getDestinationFrom() {
		return destinationFrom;
	}

	public void setDestinationFrom(Destination destinationFrom) {
		this.destinationFrom = destinationFrom;
	}

	public Destination getDestinationTo() {
		return destinationTo;
	}

	public void setDestinationTo(Destination destinationTo) {
		this.destinationTo = destinationTo;
	}
	
	// constructors
	public Flight() {
		
	}
	
	public Flight(String flightNumber, Date date, String aircraftModel, long price) {
		this.flightNumber=flightNumber;
		this.date=date;
		this.aircraftModel=aircraftModel;
		this.price=price;
	}
		
}
