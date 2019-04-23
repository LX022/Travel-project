package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DestinationBean implements Destination {
	
	private EntityManager em;
	@PersistenceContext(name = "DestinationPU")

	@Override
	public List<Destination> getDestinations() {
		// TODO Auto-generated method stub
		return em.createQuery("FROM Destination").getResultList();
	}

}
