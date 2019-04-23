package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Local;

@Local
public interface Destination {
	
	List<Destination> getDestinations();

}
