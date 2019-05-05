package ch.hevs.businessobject;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Passenger")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String firstname;
	private String lastname;	
	private String city;
	private String zipcode;

	// relations
	@ManyToMany(mappedBy="passengers", cascade= CascadeType.PERSIST)
	private List<Flight> flights;

	// getters setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setcity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
		
	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	// constructors
	public Passenger() {
		this.flights = new ArrayList<Flight>();
	}
	
	public Passenger(String firstname, String lastname, String city, String zipcode) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
		this.zipcode = zipcode;
		this.flights = new ArrayList <Flight>();
	}
	
	// helper methods
	public void addFlight(Flight f) {
		flights.add(f);
		f.getPassengers().add(this);
	}

}
