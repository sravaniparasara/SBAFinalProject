package com.iiht.training.auction.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "seller")
public class SellerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sellerId;
	private String sellerFirstName;
	private String sellerLastName;
	private String sellerEmail;
	private String address;
	private Long phoneNumber;
	private String city;
	private String state;
	private Long pin;
	
	@OneToMany(mappedBy="seller",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<ProductEntity> products;
	
	
	public SellerEntity() {
		super();
		
	}

	public SellerEntity(Long sellerId, String sellerFirstName, String sellerLastName, String sellerEmail,
			String address, Long phoneNumber, String city, String state, Long pin, Set<ProductEntity> products) {
		super();
		this.sellerId = sellerId;
		this.sellerFirstName = sellerFirstName;
		this.sellerLastName = sellerLastName;
		this.sellerEmail = sellerEmail;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.state = state;
		this.pin = pin;
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



	public Long getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
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



	public Set<ProductEntity> getProducts() {
		return products;
	}



	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}
	
}