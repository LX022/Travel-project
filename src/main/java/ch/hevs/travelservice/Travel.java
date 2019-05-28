package ch.hevs.travelservice;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Airport;
import ch.hevs.businessobject.Arrival;
import ch.hevs.businessobject.Departure;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.Passenger;

@Local
public interface Travel {

	List<Departure> getDepartures();
	
	List<Arrival> getArrivals();
	
	List<Flight> getFlights();
	
	List<Flight> getFlightsFromDepartureAndArrival(Departure departure, Arrival arrival, Date date);
	
	List<Passenger> getPassengers();
	
	void createPassenger(Passenger newPassenger) throws Exception;
	
	void removePassenger(Passenger deletePassenger) throws Exception;
	
	void createFlight(Flight newFlight) throws Exception;
	
	void createDeparture(Departure newDeparture) throws Exception;
	
	void createArrival(Arrival newArrival) throws Exception;
	
	void deleteDepartureFromIataArrivalAirport(String iata);
	
	Flight getFlightFromNumber(String number);
	
	Passenger getPassengerFromFirstAndLastName(String firstname, String lastname);
	
	Departure getDepartureAirportByIATA(String iata);
	
	Arrival getArrivalAirportByIATA(String iata);
	
}
