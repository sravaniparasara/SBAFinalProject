package com.iiht.training.auction.dto;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iiht.training.auction.entity.CustomerEntity;
import com.iiht.training.auction.entity.ProductEntity;

public class BidsDto {

	private Long id;
	@NotNull
	
	private Double bidAmount;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate biddingDate;
	@NotNull
	private Long productId;
	//@NotNull
	//private Long customerId;
	
private ProductDto product;

private CustomerDto customer;

	
	

	public BidsDto() {
	super();
	}
//@NotNull Long customerId,
	public BidsDto(Long id, @NotNull Double bidAmount, @NotNull LocalDate biddingDate, @NotNull Long productId,
		 ProductDto product, CustomerDto customer) {
	super();
	this.id = id;
	this.bidAmount = bidAmount;
	this.biddingDate = biddingDate;
	this.productId = productId;
	//this.customerId = customerId;
	this.product = product;
	this.customer = customer;
}

	public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Double getBidAmount() {
	return bidAmount;
}

public void setBidAmount(Double bidAmount) {
	this.bidAmount = bidAmount;
}

public LocalDate getBiddingDate() {
	return biddingDate;
}

public void setBiddingDate(LocalDate biddingDate) {
	this.biddingDate = biddingDate;
}

public Long getProductId() {
	return productId;
}

public void setProductId(Long productId) {
	this.productId = productId;
}

/*
public Long getCustomerId() {
	return customerId;
}

public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}
*/

public ProductDto getProduct() {
	return product;
}

public void setProduct(ProductDto product) {
	this.product = product;
}

public CustomerDto getCustomer() {
	return customer;
}

public void setCustomer(CustomerDto customer) {
	this.customer = customer;
}

	@Override
	public int hashCode() {
		return Objects.hash(bidAmount, biddingDate, id, productId); //customerId && Objects.equals(customerId, other.customerId)
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BidsDto other = (BidsDto) obj;
		return Objects.equals(bidAmount, other.bidAmount) && Objects.equals(biddingDate, other.biddingDate)
				 && Objects.equals(id, other.id)
				&& Objects.equals(productId, other.productId);
	}
	
	
}
