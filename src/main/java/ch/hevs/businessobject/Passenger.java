package ch.hevs.businessobject;


import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Passenger")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String firstname;
	private String lastname;	
	private String address;
	private String zipcode;

	// relations
	@ManyToMany(mappedBy="passengers")
	private List<Flight> flights;

	
	// constructors
	public Passenger() {
		this.flights = new ArrayList<Flight>();
	}
	
	public Passenger(Long id, String firstname, String lastname, String address, String zipcode) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.zipcode = zipcode;
	}
	
	// helper methods
	public void addFlight(Flight f) {
		flights.add(f);
		f.addPassenger(this);
	}
	// getters setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
