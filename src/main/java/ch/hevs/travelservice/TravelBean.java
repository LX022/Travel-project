package ch.hevs.travelservice;

import static java.lang.Math.toIntExact;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.hevs.businessobject.Arrival;
import ch.hevs.businessobject.CreditCard;
import ch.hevs.businessobject.Departure;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.Passenger;


@Stateless

public class TravelBean implements Travel{
	
	@Resource
	private SessionContext ctx;

	
	@PersistenceContext(name = "TravelPU")
	private EntityManager em;

	@Override
	public List<Departure> getDepartures() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT d FROM Departure AS d").getResultList();
	}

	@Override
	public List<Flight> getFlightsFromDepartureAndArrival(Departure departure, Arrival arrival, Date date) {
		// TODO Auto-generated method stub
		
		Query query = em.createQuery("SELECT f FROM Flight f where f.departure = :departure and f.arrival = :arrival and f.date = :date and f.numberOfPassengers > '0'");
		query.setParameter("departure", departure).setParameter("arrival", arrival).setParameter("date", date).getResultList();
		
		return query.getResultList();		
		
	}

	@Override
	public List<Passenger> getPassengers() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT p FROM Passenger AS p").getResultList();
	}

	@Override
	public void createPassenger(String firstname, String lastname, String city, String zipcode, String creditCardNumber,String creditCardDate, String creditCardType) throws Exception {
		// TODO Auto-generated method stub
		Passenger p = new Passenger();
		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setcity(city);
		p.setZipcode(zipcode);
		p.setMiles(0);
		p.setCreditCard(new CreditCard());
		p.getCreditCard().setCreditCardDate(creditCardDate);
		p.getCreditCard().setCreditCardNumber(creditCardNumber);
		p.getCreditCard().setCreditCardType(creditCardType);
		em.persist(p);
	}

	@Override
	public List<Arrival> getArrivals() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM Arrival AS a").getResultList();
	}

	@Override
	public List<Flight> getFlights() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT f FROM Flight AS f").getResultList();
	}
	

	@Override
	public void removePassenger(Passenger deletePassenger) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createFlight(String flightNumber,Date date,String  aircraftModel,long price,int numberOfPassengers,Departure departure,Arrival arrival) throws Exception {
		// TODO Auto-generated method stub
		Flight f = new Flight();
		f.setFlightNumber(flightNumber);
		f.setDate(date);
		f.setAircraftModel(aircraftModel);
		f.setPrice(price);
		f.setNumberOfPassengers(numberOfPassengers);

		f.setDeparture(departure);
		f.setArrival(arrival);
		
		em.persist(f);
	}

	@Override
	public void createDeparture(String iata, String city, String country, String gate) throws Exception {
		// TODO Auto-generated method stub

			Departure d = new Departure();
			d.setIata(iata);
			d.setCity(city);
			d.setCountry(country);
			d.setGate(gate);
						
			em.persist(d);	

	}

	@Override
	public void createArrival(String iata, String city, String country) throws Exception {
		// TODO Auto-generated method stub
		Arrival a = new Arrival();
		a.setIata(iata);
		a.setCity(city);
		a.setCountry(country);
		
		
		em.persist(a);
	}

	@Override
	public Departure getDepartureAirportByIATA(String iata) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT d FROM Departure d where d.iata = :iata");
		query.setParameter("iata", iata).getResultList();
		
		return (Departure) query.getSingleResult();
	}

	@Override
	public Arrival getArrivalAirportByIATA(String iata) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT a FROM Arrival a where a.iata = :iata");
		query.setParameter("iata", iata).getResultList();
		
		return (Arrival) query.getSingleResult();
	}

	@Override
	public Flight getFlightFromNumber(String flightnumber) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT f FROM Flight f where f.flightNumber = :flightnumber");
		query.setParameter("flightnumber", flightnumber).getResultList();
		
		return (Flight) query.getSingleResult();
	}

	@Override
	public Passenger getPassengerFromFirstAndLastName(String firstname, String lastname) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT p FROM Passenger p where p.firstname = :firstname and p.lastname = :lastname");
		query.setParameter("firstname", firstname).setParameter("lastname", lastname).getResultList();
		
		return (Passenger) query.getSingleResult();
	}


	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	@Override
	public void bookFlight(Passenger passenger,Flight flight) throws Exception {
		// TODO Auto-generated method stub

		int numbOfPassengers = flight.getNumberOfPassengers();
		
		//Correction des miles
		
		int currentMiles = passenger.getMiles();
		long milesAdded = flight.getPrice() / 2;
		int newMiles = currentMiles + toIntExact(milesAdded);
		passenger.setMiles(newMiles);
		
		
		flight.addPassenger(passenger);
		flight.setNumberOfPassengers(numbOfPassengers-1);

		em.merge(flight);	
		updateNumberOfPassengers(flight);
		
	}

	@Override
	public Flight getFlightFromId(Long id) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT f FROM Flight f where f.id = :id");
		query.setParameter("id", id).getResultList();
		
		return (Flight) query.getSingleResult();
	}

	@Override
	public Boolean isAdmin() {
		// TODO Auto-generated method stub
		if(ctx.isCallerInRole("admin"))
			return true;
		else
			return false;
		
	}
	
	@Override
	public Boolean isAgent() {
		// TODO Auto-generated method stub
		if(ctx.isCallerInRole("agent"))
			return true;
		else
			return false;
	}

	@Override
	public void updateNumberOfPassengers(Flight f) {
		// TODO Auto-generated method stub
		int value = f.getNumberOfPassengers() -1;
		Query query = em.createQuery("UPDATE Flight f SET f.numberOfPassengers = :value WHERE f.id = :id").setParameter("id", f.getId()).setParameter("value", value);
			   
	}
	

	
}
