package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class FlightBean implements Flight{
	
	private EntityManager em;
	@PersistenceContext(name = "FlightPU")

	@Override
	public List<Flight> getFlightsFromDepartureAndDestination(Destination from, Destination to) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT d.destinations FROM Destination d where d.country=:from AND d.country=:to");
		query.setParameter("from", from).getResultList();
		query.setParameter("to", to).getResultList();
		
		return (List<Flight>) query.getSingleResult();
	}

}
