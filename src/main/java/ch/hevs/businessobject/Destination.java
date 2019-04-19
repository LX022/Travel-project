package ch.hevs.businessobject;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Destination")
public class Destination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String city;
	private String country;
	private String airport;
	
	@OneToMany(mappedBy = "destinationFrom")
	private List<Flight> flightsFrom;
	
	@OneToMany(mappedBy = "destinationTo")
	private List<Flight> flightsTo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	public List<Flight> getFlightsFrom() {
		return flightsFrom;
	}
	public void setFlightsFrom(List<Flight> flightsFrom) {
		this.flightsFrom = flightsFrom;
	}
	public List<Flight> getFlightsTo() {
		return flightsTo;
	}
	public void setFlightsTo(List<Flight> flightsTo) {
		this.flightsTo = flightsTo;
	}
	

}
