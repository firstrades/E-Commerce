package ecom.model;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String address;
	private String city;
	private String state;	
	private String pin;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
}
