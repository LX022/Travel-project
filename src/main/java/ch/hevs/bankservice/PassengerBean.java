package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PassengerBean implements Passenger{
	
	private EntityManager em;
	@PersistenceContext(name = "PassengerPU")

	@Override
	public List<Passenger> getPassengers() {
		// TODO Auto-generated method stub
		return null;
	}


}
