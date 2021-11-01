package com.iiht.training.auction.dto;

import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.iiht.training.auction.entity.ProductEntity;

public class SellerDto {
	
	private Long sellerId;
	@NotBlank
	@Length(min = 5, max = 30)
	private String sellerFirstName;
	@NotBlank
	@Length(min = 3, max = 25)
	private String sellerLastName;
	@NotBlank
	@Email
	@Length(min = 3, max = 100)
	private String sellerEmail;
	@NotBlank
	@Length(min = 3, max = 100)
	private String address;
	@NotBlank
	@Length(min = 3, max = 100)
	private String city;
	@NotBlank
	@Length(min = 3, max = 100)
	private String state;
	@NotNull
	private Long pin;
	@NotNull
	@Min(1000000000)
	@Max(9999999999L)
	private Long phoneNumber;
	
	private Set<ProductDto> products;
	
	public SellerDto() {
		super();
		
	}

	public SellerDto(Long sellerId, @NotBlank @Length(min = 5, max = 30) String sellerFirstName,
			@NotBlank @Length(min = 3, max = 25) String sellerLastName,
			@NotBlank @Email @Length(min = 3, max = 100) String sellerEmail,
			@NotBlank @Length(min = 3, max = 100) String address, @NotBlank @Length(min = 3, max = 100) String city,
			@NotBlank @Length(min = 3, max = 100) String state, @NotNull Long pin,
			@NotNull @Min(1000000000) @Max(9999999999L) Long phoneNumber, Set<ProductDto> products) {
		super();
		this.sellerId = sellerId;
		this.sellerFirstName = sellerFirstName;
		this.sellerLastName = sellerLastName;
		this.sellerEmail = sellerEmail;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.phoneNumber = phoneNumber;
		this.products = products;
	}

	

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerFirstName() {
		return sellerFirstName;
	}

	public void setSellerFirstName(String sellerFirstName) {
		this.sellerFirstName = sellerFirstName;
	}

	public String getSellerLastName() {
		return sellerLastName;
	}

	public void setSellerLastName(String sellerLastName) {
		this.sellerLastName = sellerLastName;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
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

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDto> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, phoneNumber, city, state, pin, sellerEmail, sellerId, sellerFirstName, sellerLastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SellerDto other = (SellerDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(city, other.city) && Objects.equals(state, other.state) && Objects.equals(pin, other.pin)
				&& Objects.equals(sellerEmail, other.sellerEmail) && Objects.equals(sellerId, other.sellerId)
				&& Objects.equals(sellerFirstName, other.sellerFirstName) && Objects.equals(sellerLastName, other.sellerLastName);
	}
	
	

}
