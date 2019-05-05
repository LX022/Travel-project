package ch.hevs.travelservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Departure;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.Passenger;

@Local
public interface Travel {

	List<Departure> getDestinations();
	
	List<Flight> getFlightsFromDepartureAndDestination(Departure from, Departure to);
	
	List<Passenger> getPassengers();
	
	void createPassenger(Passenger newPassenger) throws Exception;
	
}
