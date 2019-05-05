package ch.hevs.travelservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.hevs.businessobject.Departure;
import ch.hevs.businessobject.Flight;
import ch.hevs.businessobject.Passenger;


public class TravelBean implements Travel{
	
	private EntityManager em;
	@PersistenceContext(name = "TravelPU")

	@Override
	public List<Departure> getDestinations() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT FROM Destination").getResultList();
	}

	@Override
	public List<Flight> getFlightsFromDepartureAndDestination(Departure from, Departure to) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT d.destinations FROM Destination d where d.country=:from AND d.country=:to");
		query.setParameter("from", from).getResultList();
		query.setParameter("to", to).getResultList();
		
		return (List<Flight>) query.getSingleResult();
	}

	@Override
	public List<Passenger> getPassengers() {
		// TODO Auto-generated method stub
		return em.createQuery("FROM Passenger").getResultList();
	}

	@Override
	public void createPassenger(Passenger newPassenger) throws Exception {
		// TODO Auto-generated method stub
		em.persist(newPassenger);
	}
	


}
