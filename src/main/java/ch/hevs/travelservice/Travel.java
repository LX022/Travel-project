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
	
	Boolean isAdmin();
	
	Boolean isAgent();
	
	void createPassenger(String firstname, String lastname, String city, String zipcode,String creditCardNumber,String creditCardDate, String creditCardType) throws Exception;
	
	void removePassenger(Passenger deletePassenger) throws Exception;
	
	void createFlight(String flightNumber,Date date,String  aircraftModel,long price,int numberOfPassengers,Departure departure,Arrival arrival) throws Exception;
	
	void createDeparture(String iata, String city, String country, String gate) throws Exception;
	
	void createArrival(String iata, String city, String country) throws Exception;
		
	void bookFlight(Passenger passenger,Flight flight) throws Exception;
	
	void updateNumberOfPassengers( Flight flight);
	
	
	Flight getFlightFromNumber(String number);
	
	Flight getFlightFromId(Long id);
	
	Passenger getPassengerFromFirstAndLastName(String firstname, String lastname);
	
	Departure getDepartureAirportByIATA(String iata);
	
	Arrival getArrivalAirportByIATA(String iata);
	
}
