package ch.hevs.businessobject;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Departure")
public class Departure extends Airport{
	
	// relations	
	@OneToMany(mappedBy = "departure")
	private List<Flight> flights;


	public List<Flight> getDepartureFlights() {
		return flights;
	}
	public void setDepartureFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	// constructors
	public Departure() {
	}
	
}
