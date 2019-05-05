package ch.hevs.travelservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Arrival;
import ch.hevs.businessobject.Departure;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.Passenger;

@Local
public interface Travel {

	List<Departure> getDepartures();
	
	List<Arrival> getArrivals();
	
	List<Flight> getFlights();
	
	//à supprimer normalement
	List<Flight> getFlightsFromDepartureAndArrival(Departure departure, Arrival arrival);
	
	List<Passenger> getPassengers();
	
	void createPassenger(Passenger newPassenger) throws Exception;
	
	void removePassenger(Passenger deletePassenger) throws Exception;
	
	void createFlight(Flight newFlight) throws Exception;
	
	void createDeparture(Departure newDeparture) throws Exception;
	
	void createArrival(Arrival newArrival) throws Exception;
	
}
