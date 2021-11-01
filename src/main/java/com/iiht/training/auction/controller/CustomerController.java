
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
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.auction.dto.BidsDto;
import com.iiht.training.auction.dto.CustomerDto;
import com.iiht.training.auction.dto.SellerDto;
import com.iiht.training.auction.exceptions.InvalidDataException;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.CustomerService;


@RestController
@RequestMapping("/buyers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private BidsService bidsService;

	
	/*
	 * @PostMapping("/register") public ResponseEntity<?>
	 * registerCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult
	 * result) { if (result.hasErrors()) { throw new
	 * InvalidDataException("Customer data is not Valid!"); }
	 * customerService.registerCustomer(customerDto); return
	 * ResponseEntity.ok(customerDto); }
	 */
	
	@PostMapping("/register")
	public ResponseEntity<?> registerCustomer(@RequestBody CustomerDto customerDto) {
		/*
		 * if (result.hasErrors()) { throw new
		 * InvalidDataException("Customer data is not Valid!"); }
		 */
		customerService.registerCustomer(customerDto);
		return ResponseEntity.ok(customerDto);
	}
	
	@PostMapping("/place-bid")
	public ResponseEntity<BidsDto> placeBid(@Valid @RequestBody BidsDto bidsDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Bid is not placed");
		}
		customerService.placeBid(bidsDto);
		return ResponseEntity.ok(bidsDto);
	}
	
	@PostMapping("/update-bid/{productId}/{buyerEmailsId}/{newBidAmount}")
	public ResponseEntity<BidsDto> updateBid(@Valid @RequestBody BidsDto bidsDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Bid is not placed");
		}
		customerService.updateBid(bidsDto);
		return ResponseEntity.ok(bidsDto);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult result) {
		return null;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		return null;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
		return null;
	}

	@GetMapping("/get/all")
	public ResponseEntity<?> getAllCustomers() {
		return null;
	}


	@GetMapping("/get/all-bids-on-product/{productId}")
	public ResponseEntity<?> getBidsByProductId(@PathVariable Long productId) {
		return null;
	}

}
