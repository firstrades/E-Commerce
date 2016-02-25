package ecom.model;

import java.io.Serializable;

public class DeliveryAddress implements Serializable {
	private static final long serialVersionUID = 5311964106164519056L;

	private long   id;
	private long   userId;
	private String fName;
	private String lName;
	private String contact;
	private String address;
	private String city;
	private String state;
	private String pin;
	private String email;
	
	private boolean exits;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public boolean isExits() {
		return exits;
	}
	public void setExits(boolean exits) {
		this.exits = exits;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
