package com.iiht.training.auction.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.auction.dto.BidsDto;
import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.dto.SellerDto;
import com.iiht.training.auction.exceptions.InvalidDataException;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.SellerService;

@RestController
@RequestMapping("/bids")

public class BidsController {	

	/*
	 * @Autowired private SellerService sellerService;
	 */
		
		@Autowired
		private BidsService bidsService;

		@PostMapping("/place-bid")
		public ResponseEntity<?> registerSeller(@Valid @RequestBody BidsDto bidsDto, BindingResult result) {
			if (result.hasErrors()) {
				throw new InvalidDataException("bids placed were not Valid!");
			}
			return ResponseEntity.ok(bidsDto);
		}
		
		@PutMapping("/update-bid/{productId}/{buyerEmailId}/{newBidAmount}")
		public ResponseEntity<?> addproduct(@Valid @RequestBody BidsDto bidsDto, BindingResult result) {
			if (!result.hasErrors()) {
				throw new InvalidDataException("Bid Amount was not updated!");
			}
			return ResponseEntity.ok(bidsDto);
		}
	
			
}
