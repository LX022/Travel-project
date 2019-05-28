package ch.hevs.managedbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Arrival;
import ch.hevs.businessobject.Departure;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.Passenger;
import ch.hevs.travelservice.Travel;

public class FlightManagerBean {

	private List<Departure> allDeparture;
	private List<Arrival> allArrival;
	private List<String> allDepartureIata;
	private List<String> allArrivalIata;

	private List<Passenger> passengers;
	private List<String> passengersNames;
	private String passengerSelected;
	private Passenger passenger;
	
	private List<String> allChoiceFlightsDesignation;
	private List<Flight> allChoiceFlights;
	private String flightSelected;
	private Flight flight;

	private String departureIataSelected;
	private String arrivalIataSelected;

	private Travel travel;
	private String selectionState;

	private String flightNumber;
	private Date date;
	private String dateInString;

	private String aircraftModel;
	private long price;
	private int numberOfPassengers;
	private Departure departure;
	private Arrival arrival;
	private String creationResult;
	
	private String firstname;
	private String lastname;
	private int space;
	
	@PostConstruct
	public void initialize() throws NamingException {

		// use JNDI to inject reference to bank EJB
		InitialContext ctx = new InitialContext();
		travel = (Travel) ctx.lookup("java:global/TRAVEL-0.0.1-SNAPSHOT/TravelBean!ch.hevs.travelservice.Travel");

		this.flightNumber = "flightNumber";
		this.dateInString = "27/05/2019";
		this.aircraftModel = "aircraftModel";
		this.price = 1000;
		this.numberOfPassengers = 300;

		allChoiceFlightsDesignation = new ArrayList<String>();
		allChoiceFlights = new ArrayList<Flight>();

		// initialize airport choices
		this.allDeparture = travel.getDepartures();
		this.allDepartureIata = new ArrayList<String>();
		for (Departure d : allDeparture) {
			this.allDepartureIata.add(d.getIata());
		}

		this.allArrival = travel.getArrivals();
		this.allArrivalIata = new ArrayList<String>();
		for (Arrival a : allArrival) {
			this.allArrivalIata.add(a.getIata());
		}

		this.passengers = travel.getPassengers();
		this.passengersNames = new ArrayList<String>();
		for (Passenger p : passengers){
			this.passengersNames.add(p.getFirstname() +" "+p.getLastname());
		}
		
	}

	public String flightSelection() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		departure = travel.getDepartureAirportByIATA(departureIataSelected);
		arrival = travel.getArrivalAirportByIATA(arrivalIataSelected);

		try {
			date = formatter.parse(dateInString);
		} catch (Exception e) {
			return "dateError";
		}

		allChoiceFlights = travel.getFlightsFromDepartureAndArrival(departure, arrival, date);
		for (Flight f : allChoiceFlights) {
			this.allChoiceFlightsDesignation.add(f.getFlightNumber());
		}

		return "bookFlySelectFlight";
	}
	
	
	public String passengerSelection() {
		
		space = passengerSelected.indexOf(" ");
		System.out.println("space : " + space);
		
		firstname = passengerSelected.substring(0, space);		
		
		lastname = passengerSelected.substring(space+1);
						
		try {
			flight=travel.getFlightFromNumber(flightSelected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		passenger=travel.getPassengerFromFirstAndLastName(firstname, lastname);
		
		flight.addPassenger(passenger);
		
		return "flightBooked";
	}
	
	public String createFlight() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			return "dateError";
		}

		departure = travel.getDepartureAirportByIATA(departureIataSelected);
		arrival = travel.getArrivalAirportByIATA(arrivalIataSelected);

		try {
			Flight f = new Flight();
			f.setFlightNumber(flightNumber);
			f.setDate(date);
			f.setAircraftModel(aircraftModel);
			f.setPrice(price);
			f.setNumberOfPassengers(numberOfPassengers);

			// Probl�me pour ajouter les FK
			f.setDeparture(departure);
			f.setArrival(arrival);

			this.creationResult = "Success!";
			travel.createFlight(f);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "showCreateFlightResult";

	}

	// Getter and Setter

	public List<Departure> getAllDeparture() {
		return allDeparture;
	}

	public void setAllDeparture(List<Departure> allDeparture) {
		this.allDeparture = allDeparture;
	}

	public List<Arrival> getAllArrival() {
		return allArrival;
	}

	public void setAllArrival(List<Arrival> allArrival) {
		this.allArrival = allArrival;
	}

	public List<String> getAllDepartureIata() {
		return allDepartureIata;
	}

	public void setAllDepartureIata(List<String> allDepartureIata) {
		this.allDepartureIata = allDepartureIata;
	}

	public List<String> getAllArrivalIata() {
		return allArrivalIata;
	}

	public void setAllArrivalIata(List<String> allArrivalIata) {
		this.allArrivalIata = allArrivalIata;
	}

	public String getDepartureIataSelected() {
		return departureIataSelected;
	}

	public void setDepartureIataSelected(String departureIataSelected) {
		this.departureIataSelected = departureIataSelected;
	}

	public String getArrivalIataSelected() {
		return arrivalIataSelected;
	}

	public void setArrivalIataSelected(String arrivalIataSelected) {
		this.arrivalIataSelected = arrivalIataSelected;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public String getSelectionState() {
		return selectionState;
	}

	public void setSelectionState(String selectionState) {
		this.selectionState = selectionState;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDateInString() {
		return dateInString;
	}

	public void setDateInString(String dateInString) {
		this.dateInString = dateInString;
	}

	public String getAircraftModel() {
		return aircraftModel;
	}

	public void setAircraftModel(String aircraftModel) {
		this.aircraftModel = aircraftModel;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public Departure getDeparture() {
		return departure;
	}

	public void setDeparture(Departure departure) {
		this.departure = departure;
	}

	public Arrival getArrival() {
		return arrival;
	}

	public void setArrival(Arrival arrival) {
		this.arrival = arrival;
	}

	public String getCreationResult() {
		return creationResult;
	}

	public void setCreationResult(String creationResult) {
		this.creationResult = creationResult;
	}

	public List<String> getAllChoiceFlightsDesignation() {
		return allChoiceFlightsDesignation;
	}

	public void setAllChoiceFlightsDesignation(List<String> allChoiceFlightsDesignation) {
		this.allChoiceFlightsDesignation = allChoiceFlightsDesignation;
	}

	public List<Flight> getAllChoiceFlights() {
		return allChoiceFlights;
	}

	public void setAllChoiceFlights(List<Flight> allChoiceFlights) {
		this.allChoiceFlights = allChoiceFlights;
	}

	public String getFlightSelected() {
		return flightSelected;
	}

	public void setFlightSelected(String flightSelected) {
		this.flightSelected = flightSelected;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public List<String> getPassengersNames() {
		return passengersNames;
	}

	public void setPassengersNames(List<String> passengersNames) {
		this.passengersNames = passengersNames;
	}

	public String getPassengerSelected() {
		return passengerSelected;
	}

	public void setPassengerSelected(String passengerSelected) {
		this.passengerSelected = passengerSelected;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getSpace() {
		return space;
	}

	public void setSpace(int space) {
		this.space = space;
	}
		
}