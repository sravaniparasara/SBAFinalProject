package com.iiht.training.auction.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String email;
	private Long phoneNumber;
	private String address;	
	private String FirstName;
	private String LastName;
	private String city;
	private String state;
	private Long pin;
	
	
	
	@ManyToOne
	@JoinColumn(name = "bid",nullable = false)
	private BidsEntity bid;
	
	public CustomerEntity() {
		super();
		
	}
	
	
	public CustomerEntity(Long id, String username, String password, String email, Long phoneNumber, String address,
			String FirstName, String LastName, String city, String state, Long pin, BidsEntity bid) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.bid = bid;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
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


	public Long getPin() {
		return pin;
	}


	public void setPin(Long pin) {
		this.pin = pin;
	}


	public BidsEntity getBid() {
		return bid;
	}


	public void setBid(BidsEntity bid) {
		this.bid = bid;
	}
	
	

}
