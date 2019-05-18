package ch.hevs.managedbeans;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Arrival;
import ch.hevs.businessobject.Departure;
import ch.hevs.businessobject.Passenger;
import ch.hevs.travelservice.Travel;

public class CreateAirportBean {

	private String iata;
	private String city;
	private String country;
	private String gate;
	private Travel travel;
	private String creationResult;

	@PostConstruct
	public void initialize() throws NamingException {
		// use JNDI to inject reference to bank EJB
		InitialContext ctx = new InitialContext();
		travel = (Travel) ctx.lookup("java:global/TRAVEL-0.0.1-SNAPSHOT/TravelBean!ch.hevs.travelservice.Travel");

		// initialize account descriptions
		this.iata = "iata";
		this.city = "city";
		this.country = "country";
		this.gate = "gate";
	}

	public String createDepartureAirport() {

		try {
			Departure d = new Departure();
			d.setIata(iata);
			d.setCity(city);
			d.setCountry(country);
			d.setGate(gate);

			this.creationResult = "Success!";
			travel.createDeparture(d);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "showCreateAirportResult";
	}

	public String createArrivalAirport() {

		try {
			Arrival a = new Arrival();
			a.setIata(iata);
			a.setCity(city);
			a.setCountry(country);

			this.creationResult = "Success!";
			travel.createArrival(a);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "showCreateAirportResult";
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public String getCreationResult() {
		return creationResult;
	}

	public void setCreationResult(String creationResult) {
		this.creationResult = creationResult;
	}
	
	
	
	

}
