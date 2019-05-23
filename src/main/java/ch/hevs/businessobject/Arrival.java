package ch.hevs.businessobject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Arrival")
public class Arrival extends Airport{
	
	
	// relations	
	@OneToMany(mappedBy = "arrival", cascade= CascadeType.MERGE)
	private List<Flight> flights;


	public List<Flight> getArrivalFlight() {
		return flights;
	}
	public void setArrivalFlight(List<Flight> flights) {
		this.flights = flights;
	}
	
		
	// constructors
	public Arrival() {
	}
	
	public Arrival(String iata, String city, String country) {
		super(iata, city, country);
	}
	
}
