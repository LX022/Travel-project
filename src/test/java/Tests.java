import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import ch.hevs.businessobject.Passenger;
import ch.hevs.travelservice.Travel;


public class Tests {
	
	
	@Test
	public void test() throws NamingException {
		
		InitialContext ctx = new InitialContext();
		Travel travel = (Travel) ctx.lookup("java:global/Travel project/TravelBean!ch.hevs.travelservice.Travel");
		
		try {
			Passenger p3 = new Passenger("Alexandre", "Berclaz", "St-Maurice", "1890");

			travel.createPassenger(p3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
