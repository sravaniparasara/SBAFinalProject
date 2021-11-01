package com.iiht.training.auction.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bid")
public class BidsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double bidAmount;
	private LocalDate biddingDate;
	private Long productId;
	//private Long customerId;
	
	
	  @ManyToOne	  
	  @JoinColumn(name = "product",nullable = false)
	  private ProductEntity product;
	 	
	 @OneToMany(mappedBy="bid",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 private Set<CustomerEntity> customer;	 
	 

	
	public BidsEntity() {
		super();
		
	}
//Long customerId,
	public BidsEntity(Long id, Double bidAmount, LocalDate biddingDate, Long productId, 
			ProductEntity product) {
		super();
		this.id = id;
		this.bidAmount = bidAmount;
		this.biddingDate = biddingDate;
		this.productId = productId;
		//this.customerId = customerId;
		this.product = product;
			}
	
	public BidsEntity(Long id, Double bidAmount, LocalDate biddingDate, Long productId, ProductEntity product, Set<CustomerEntity> customer) {
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
	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Set<CustomerEntity> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<CustomerEntity> customer) {
		this.customer = customer;
	}

	
	  
}
