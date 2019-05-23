package ch.hevs.businessobject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Departure")
public class Departure extends Airport{
	
	private String gate;
	
	// relations	
	@OneToMany(mappedBy = "departure", cascade= CascadeType.MERGE)
	private List<Flight> flights;


	public List<Flight> getDepartureFlights() {
		return flights;
	}
	public void setDepartureFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	
	
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
	// constructors
	public Departure() {
	}
	public Departure(String gate, String iata, String city, String country) {
		super(iata, city, country);
		this.gate = gate;
	}
	
	
	
}
