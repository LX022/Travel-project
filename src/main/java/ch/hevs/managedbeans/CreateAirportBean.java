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

		return "showCreateDepartureAirportResult";
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

		return "showCreateArrivalAirportResult";
	}

}
