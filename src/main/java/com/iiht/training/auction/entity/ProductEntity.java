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
@Table(name = "product")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private Long sellerId;
	private String name;
	private String shortdescription;
	private String detaileddescription;
	private Integer quantity;
	private Double price;
	private Double startingBidAmount;
	private LocalDate lastDateOfBidding;
	private String category;
	
	
	@ManyToOne
	@JoinColumn(name = "seller",nullable = false)
	private SellerEntity seller;
    
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<BidsEntity> bid;
	
	
	public ProductEntity() {
		super();
		
	}

	public ProductEntity(Long productId, Long sellerId, String name, String shortdescription,
			String detaileddescription, Integer quantity, Double price, Double startingBidAmount,
			LocalDate lastDateOfBidding, String category, SellerEntity seller) {
		super();
		this.productId = productId;
		this.sellerId = sellerId;
		this.name = name;
		this.shortdescription = shortdescription;
		this.detaileddescription = detaileddescription;
		this.quantity = quantity;
		this.price = price;
		this.startingBidAmount = startingBidAmount;
		this.lastDateOfBidding = lastDateOfBidding;
		this.category = category;
		this.seller = seller;
		this.bid = bid;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Long getSellerId() {
		return sellerId;
	}


	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getShortdescription() {
		return shortdescription;
	}


	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}


	public String getDetaileddescription() {
		return detaileddescription;
	}


	public void setDetaileddescription(String detaileddescription) {
		this.detaileddescription = detaileddescription;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Double getStartingBidAmount() {
		return startingBidAmount;
	}


	public void setStartingBidAmount(Double startingBidAmount) {
		this.startingBidAmount = startingBidAmount;
	}


	public LocalDate getLastDateOfBidding() {
		return lastDateOfBidding;
	}


	public void setLastDateOfBidding(LocalDate lastDateOfBidding) {
		this.lastDateOfBidding = lastDateOfBidding;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public SellerEntity getSeller() {
		return seller;
	}


	public void setSeller(SellerEntity seller) {
		this.seller = seller;
	}


	public Set<BidsEntity> getBid() {
		return bid;
	}


	public void setBid(Set<BidsEntity> bid) {
		this.bid = bid;
	}

	

}
