package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Local;


@Local
public interface Passenger {
	
	List<Passenger> getPassengers();

}
