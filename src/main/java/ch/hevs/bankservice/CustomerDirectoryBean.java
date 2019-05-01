package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.hevs.businessobject.Passenger;

@Stateless
public class CustomerDirectoryBean implements CustomerDirectory{
	
	private EntityManager em;
	@PersistenceContext(name = "PassengerPU")

	@Override
	public List<CustomerDirectory> getPassengers() {
		// TODO Auto-generated method stub
		return em.createQuery("FROM Passenger").getResultList();
		 
	}
	@Override
	public void createPassenger(Passenger newPassenger) throws Exception {
		// TODO Auto-generated method stub
		em.persist(newPassenger);
	}


}
