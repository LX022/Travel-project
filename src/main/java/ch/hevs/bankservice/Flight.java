package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Local;

@Local
public interface Flight {
	
	List<Flight> getFlightsFromDepartureAndDestination(Destination from, Destination to);

}
