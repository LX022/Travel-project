package ch.hevs.travelservice;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ch.hevs.businessobject.Airport;
import ch.hevs.businessobject.Arrival;
import ch.hevs.businessobject.Departure;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.Passenger;


@Stateless
public class TravelBean implements Travel{
	
	
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
	public void createPassenger(Passenger newPassenger) throws Exception {
		// TODO Auto-generated method stub
		em.persist(newPassenger);
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
	public void createFlight(Flight newFlight) throws Exception {
		// TODO Auto-generated method stub
		em.persist(newFlight);
	}

	@Override
	public void createDeparture(Departure newDeparture) throws Exception {
		// TODO Auto-generated method stub
		em.persist(newDeparture);
	}

	@Override
	public void createArrival(Arrival newArrival) throws Exception {
		// TODO Auto-generated method stub
		em.persist(newArrival);
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

	@Override
	public void deleteDepartureFromIataArrivalAirport(String iata) {
		// TODO Auto-generated method stub
		em.createQuery("DELETE FROM Departure d where d.iata = :iata").setParameter("iata", iata).executeUpdate();
	
	}

	@Override
	public void bookFlight(Flight f) throws Exception {
		// TODO Auto-generated method stub
		Flight realFlight = em.merge(f);

		
	}

	@Override
	public Flight getFlightFromId(Long id) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT f FROM Flight f where f.id = :id");
		query.setParameter("id", id).getResultList();
		
		return (Flight) query.getSingleResult();
	}
	
}
