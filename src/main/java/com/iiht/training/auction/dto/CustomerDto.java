package com.iiht.training.auction.dto;

import java.util.Objects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.iiht.training.auction.entity.BidsEntity;

public class CustomerDto {

	private Long id;	
	private String username;	
	private String password;	
	@NotNull
	@Email
	private String email;	
	@NotNull(message="mobile no cant be null")
	@Digits(integer=10,fraction=0)
	private Long phoneNumber;	
	private String address;	
	@NotEmpty
	@NotNull
	@Length(min = 5, max = 30,message="FirstName should be between 5 and 30 in length")
	private String FirstName;	
	@NotEmpty
	@NotNull
	@Length(min = 5, max = 30,message="lastName should be between 5 and 30 in length")
	private String LastName;	
	private String city;
	private String state;
	private Long pin;
	
	private BidsDto bid;

	
	public CustomerDto() {
		super();
		
	}

	
	public CustomerDto(Long id, String username, String password, @NotNull @Email String email,
			@NotNull(message = "mobile no cant be null") @Digits(integer = 10, fraction = 0) Long phoneNumber,
			String address,
			@NotEmpty @NotNull @Length(min = 5, max = 30, message = "FirstName should be between 5 and 30 in length") String firstName,
			@NotEmpty @NotNull @Length(min = 5, max = 30, message = "lastName should be between 5 and 30 in length") String lastName,
			String city, String state, Long pin, BidsDto bid) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.FirstName = firstName;
		this.LastName = lastName;
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

	public BidsDto getBid() {
		return bid;
	}

	public void setBid(BidsDto bid) {
		this.bid = bid;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(address, email, id, password, phoneNumber, username,FirstName,LastName,city,state,pin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDto other = (CustomerDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(username, other.username)
				&& Objects.equals(FirstName, other.FirstName) && Objects.equals(LastName, other.LastName)
				&& Objects.equals(city, other.city)&& Objects.equals(state, other.state)&& Objects.equals(pin, other.pin);
	}

	
}
