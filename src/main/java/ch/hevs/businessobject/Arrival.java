package ch.hevs.businessobject;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Arrival")
public class Arrival extends Airport{
	
	private boolean finalDestination;
	
	
	// relations	
	@OneToMany(mappedBy = "arrival")
	private List<Flight> flights;


	public List<Flight> getArrivalFlight() {
		return flights;
	}
	public void setArrivalFlight(List<Flight> flights) {
		this.flights = flights;
	}
	
	
	// getters setters
	public boolean isFinalDestination() {
		return finalDestination;
	}
	public void setFinalDestination(boolean finalDestination) {
		this.finalDestination = finalDestination;
	}
	
	// constructors
	public Arrival() {
	}
	
	public Arrival(boolean finalDestination) {
		this.finalDestination = finalDestination;
	}
	
}
