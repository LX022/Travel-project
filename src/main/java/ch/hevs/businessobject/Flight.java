package ch.hevs.businessobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
	private int numberOfPassengers;
	
	// relations
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name = "FK_DEPARTURE")
	private Departure departure;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name = "FK_ARRIVAL")
	private Arrival arrival;
		
	@ManyToMany(cascade= CascadeType.PERSIST)
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
	
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	
	public Departure getDeparture() {
		return departure;
	}

	public void setDeparture(Departure departure) {
		this.departure = departure;
	}

	public Arrival getArrival() {
		return arrival;
	}

	public void setArrival(Arrival arrival) {
		this.arrival = arrival;
	}

	// constructors
	public Flight() {
		this.passengers = new ArrayList<Passenger>();
	}
	
	public Flight(String flightNumber, Date date, String aircraftModel, long price, int numberOfPassengers, Departure departure, Arrival arrival) {
		this.flightNumber=flightNumber;
		this.date=date;
		this.aircraftModel=aircraftModel;
		this.price=price;
		this.numberOfPassengers=numberOfPassengers;
		this.arrival=arrival;
		this.departure=departure;
		passengers = new ArrayList<Passenger>();
	}
	
	// Helper methods
	public void addPassenger(Passenger p) {
		passengers.add(p);
		p.getFlights().add(this);
		
	}
}
