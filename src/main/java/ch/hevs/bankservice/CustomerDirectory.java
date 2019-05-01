package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Account;
import ch.hevs.businessobject.Passenger;


@Local
public interface CustomerDirectory {
	
	List<CustomerDirectory> getPassengers();
	
	void createPassenger(Passenger newPassenger) throws Exception;

}
