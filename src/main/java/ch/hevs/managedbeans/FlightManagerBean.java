package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Arrival;
import ch.hevs.businessobject.Departure;
import ch.hevs.travelservice.Travel;

/**
 * TransferBean.java
 * 
 */

public class FlightManagerBean
{

    private List<Departure> allDeparture;
    private List<Arrival> allArrival;
    private List<String> allDepartureIata;
    private List<String> allArrivalIata;
    
	
	private String departureIataSelected;
	private String arrivalIataSelected;
	
	private Travel travel;
	private String selectionState;

    
    @PostConstruct
    public void initialize() throws NamingException {
    	System.out.println("#########################################################");    	
    	System.out.println("#########################################################");
    	System.out.println("#########################################################");    	
    	System.out.println("#########################################################");
    	
    	    	
    	// use JNDI to inject reference to bank EJB
    	InitialContext ctx = new InitialContext();
    	travel = (Travel) ctx.lookup("java:global/TRAVEL-0.0.1-SNAPSHOT/TravelBean!ch.hevs.travelservice.Travel");
    
    	
	
		// initialize account descriptions
    	this.allDeparture = travel.getDepartures();
    	
    	System.out.println("#########################################################");
    	System.out.println("#########################################################");
		for (Departure d : allDeparture) {
			System.out.println(d.getIata());
		}
    	
    	System.out.println("#########################################################");    	
    	System.out.println("#########################################################");
    	
		this.allDepartureIata = new ArrayList<String>();
		for (Departure d : allDeparture) {
			this.allDepartureIata.add(d.getIata());
		}
    	
    	this.allArrival = travel.getArrivals();
		this.allArrivalIata = new ArrayList<String>();
		for (Arrival a : allArrival) {
			this.allArrivalIata.add(a.getIata());
		}
    	
    	

    }
    
    public String selectDeparture() {
    	
    	try {

    		//customerDirectory.createPassenger(p);
    		this.selectionState ="Success!";
    		

    	} catch (Exception e) {
    		e.printStackTrace();
    	}

		return "showCreatePassengerResult"; //  the String value returned represents the outcome used by the navigation handler to determine what page to display next.
	}
    
    
    // Getter and Setter

	public List<Departure> getAllDeparture() {
		return allDeparture;
	}

	public void setAllDeparture(List<Departure> allDeparture) {
		this.allDeparture = allDeparture;
	}

	public List<Arrival> getAllArrival() {
		return allArrival;
	}

	public void setAllArrival(List<Arrival> allArrival) {
		this.allArrival = allArrival;
	}

	public List<String> getAllDepartureIata() {
		return allDepartureIata;
	}

	public void setAllDepartureIata(List<String> allDepartureIata) {
		this.allDepartureIata = allDepartureIata;
	}

	public List<String> getAllArrivalIata() {
		return allArrivalIata;
	}

	public void setAllArrivalIata(List<String> allArrivalIata) {
		this.allArrivalIata = allArrivalIata;
	}

	public String getDepartureIataSelected() {
		return departureIataSelected;
	}

	public void setDepartureIataSelected(String departureIataSelected) {
		this.departureIataSelected = departureIataSelected;
	}

	public String getArrivalIataSelected() {
		return arrivalIataSelected;
	}

	public void setArrivalIataSelected(String arrivalIataSelected) {
		this.arrivalIataSelected = arrivalIataSelected;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public String getSelectionState() {
		return selectionState;
	}

	public void setSelectionState(String selectionState) {
		this.selectionState = selectionState;
	} 
    

    

    
	
	
}