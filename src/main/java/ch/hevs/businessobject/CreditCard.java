package ch.hevs.businessobject;

import javax.persistence.Embeddable;

@Embeddable
public class CreditCard {
	private String creditCardNumber;
	private String creditCardType;
	private String creditCardDate;
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getCreditCardType() {
		return creditCardType;
	}
	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
	public String getCreditCardDate() {
		return creditCardDate;
	}
	public void setCreditCardDate(String creditCardDate) {
		this.creditCardDate = creditCardDate;
	}
	
	
	//Constructor
	public CreditCard() {

	}
	public CreditCard(String creditCardNumber, String creditCardType, String creditCardDate) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.creditCardType = creditCardType;
		this.creditCardDate = creditCardDate;
	}
	
	
	
	
}
