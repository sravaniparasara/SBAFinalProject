package com.iiht.training.auction.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseDto {
	
	
	private String shortDescription;
	
	private String detailedDescription;
	
	private Double price;
	
	private String name;
	
	private LocalDate lastDateOfBidding;
	private String category;
	
	private Long id;

	
	
	public ResponseDto() {
		super();
		
	}
	
	

	public ResponseDto(String category,String detailedDescription,LocalDate lastDateOfBidding, String name,Double price,
			String shortDescription, Long id) {
		super();
		
		this.shortDescription = shortDescription;
		this.detailedDescription = detailedDescription;
		
		this.price = price;
		this.name = name;
		
		this.lastDateOfBidding = lastDateOfBidding;
		this.category = category;
		this.id = id;
	}

	
	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetailedDescription() {
		return detailedDescription;
	}

	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}

	

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}