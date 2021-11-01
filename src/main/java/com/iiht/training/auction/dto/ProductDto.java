package com.iiht.training.auction.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.Valid;

public class ProductDto {
	private Long productId;
	@NotBlank
	@Length(min = 3, max = 100,message="Name should be between 5 and 100 in length")
	private String name;
	@NotNull
	private Long sellerId;
	@NotBlank
	@Length(min = 3, max = 100, message="Short Description should be between 3 and 100 in length")
	private String shortDescription;
	@NotBlank
	@Length(min = 3, max = 100, message="Detailed Description should be between 5 and 100 in length")
	private String detailedDescription;
	@NotNull
	private Integer quantity;
	@NotNull
	@Digits(integer = 10, fraction=0,message="Price should be number")
	private Double price;
	@NotNull
	private Double startingBidAmount;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Future
	private LocalDate lastDateOfBidding;
	@NotBlank
	@Length(min = 3, max = 100)
	@Pattern(regexp = "Painting|Sculptor|Ornament", flags = Flag.CASE_INSENSITIVE) 
	private String category;

	@Valid private SellerDto seller;
	
	@Valid private BidsDto bid;

	
	public ProductDto() {
		super();
		
	}
	

	public ProductDto(Long productId, @NotBlank @Length(min = 3, max = 100) String name, @NotNull Long sellerId,
			@NotBlank @Length(min = 3, max = 100) String shortDescription,
			@NotBlank @Length(min = 3, max = 100) String detailedDescription, @NotNull Integer quantity,
			@NotNull @Digits(integer = 10, fraction = 0) Double price, @NotNull Double startingBidAmount,
			@NotNull @Future LocalDate lastDateOfBidding,
			@NotBlank @Length(min = 3, max = 100) @NotBlank @Pattern(regexp="Painting|Sculptor|Ornament", flags = Pattern.Flag.CASE_INSENSITIVE) String category,
			SellerDto seller, BidsDto bid) {
		super();
		this.productId = productId;
		this.name = name;
		this.sellerId = sellerId;
		this.shortDescription = shortDescription;
		this.detailedDescription = detailedDescription;
		this.quantity = quantity;
		this.price = price;
		this.startingBidAmount = startingBidAmount;
		this.lastDateOfBidding = lastDateOfBidding;
		this.category = category;
		this.seller = seller;
		this.bid = bid;
	}



	public SellerDto getSeller() {
		return seller;
	}

	public void setSeller(SellerDto seller) {
		this.seller = seller;
	}
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getshortDescription() {
		return shortDescription;
	}

	public void setshortDescription(String description) {
		this.shortDescription = description;
	}

	public String getDetailedDescription() {
		return detailedDescription;
	}

	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
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

	@Override
	public int hashCode() {
		return Objects.hash(category, shortDescription,detailedDescription, lastDateOfBidding, name, price, productId, quantity, sellerId,
				startingBidAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDto other = (ProductDto) obj;
		return Objects.equals(category, other.category) && Objects.equals(shortDescription, other.shortDescription 
				
				 )
				&& Objects.equals(detailedDescription, other.detailedDescription)
				&& Objects.equals(lastDateOfBidding, other.lastDateOfBidding) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price) && Objects.equals(productId, other.productId)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(sellerId, other.sellerId)
				&& Objects.equals(startingBidAmount, other.startingBidAmount);
	}

	
}