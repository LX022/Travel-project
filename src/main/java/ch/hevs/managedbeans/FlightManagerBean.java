package ch.hevs.managedbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Arrival;
import ch.hevs.businessobject.Departure;
import ch.hevs.businessobject.Flight;
import ch.hevs.travelservice.Travel;

/**
 * TransferBean.java
 * 
 */

public class FlightManagerBean {

	private List<Departure> allDeparture;
	private List<Arrival> allArrival;
	private List<String> allDepartureIata;
	private List<String> allArrivalIata;

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
	private String creationResult;

	@PostConstruct
	public void initialize() throws NamingException {

		// use JNDI to inject reference to bank EJB
		InitialContext ctx = new InitialContext();
		travel = (Travel) ctx.lookup("java:global/TRAVEL-0.0.1-SNAPSHOT/TravelBean!ch.hevs.travelservice.Travel");

		this.flightNumber = "flightNumber";
		this.dateInString = "07/06/2013";
		this.aircraftModel = "aircraftModel";
		this.price = 1000;
		this.numberOfPassengers = 300;

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

	}

	public String selectDeparture() {

		try {

			// customerDirectory.createPassenger(p);
			this.selectionState = "Success!";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "showCreatePassengerResult"; // the String value returned
											// represents the outcome used by
											// the navigation handler to
											// determine what page to display
											// next.
	}

	public String createFlight() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		try {
			Flight f = new Flight();
			f.setFlightNumber(flightNumber);
			f.setDate(date);
			f.setAircraftModel(aircraftModel);
			f.setPrice(price);
			f.setNumberOfPassengers(numberOfPassengers);

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

	public String getCreationResult() {
		return creationResult;
	}

	public void setCreationResult(String creationResult) {
		this.creationResult = creationResult;
	}
	
	

}