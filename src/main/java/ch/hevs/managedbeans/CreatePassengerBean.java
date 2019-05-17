package ch.hevs.managedbeans;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ch.hevs.businessobject.Passenger;
import ch.hevs.travelservice.Travel;

/**
 * TransferBean.java
 * 
 */

public class CreatePassengerBean
{

	private String firstname;
	private String lastname;	
	private String city;
	private String zipcode;
    private String creationResult;
	private Travel travel;

    
    @PostConstruct
    public void initialize() throws NamingException {
    	    	
    	// use JNDI to inject reference to bank EJB
    	InitialContext ctx = new InitialContext();
    	travel = (Travel) ctx.lookup("java:global/TRAVEL-0.0.1-SNAPSHOT/TravelBean!ch.hevs.travelservice.Travel");    	
			
	
		// initialize account descriptions
		this.firstname = "mon prénom";
		this.lastname = "mon nom de famille";
		this.city = "mon adresse";
		this.zipcode = "mon zip code";
    }
    
    public String createPassenger() {
    	
    	try {
    		Passenger p = new Passenger();
    		p.setFirstname(firstname);
    		p.setLastname(lastname);
    		p.setcity(city);
    		p.setZipcode(zipcode);
    		

    		
    		
    		
    		//customerDirectory.createPassenger(p);
    		this.creationResult ="Success!";
    		travel.createPassenger(p);
    		

    	} catch (Exception e) {
    		e.printStackTrace();
    	}

		return "showCreatePassengerResult"; //  the String value returned represents the outcome used by the navigation handler to determine what page to display next.
	} 
    
    // Getter and Setter
    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String address) {
		this.city = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCreationResult() {
		return creationResult;
	}

	public void setCreationResult(String creationResult) {
		this.creationResult = creationResult;
	}
    
	
	
}