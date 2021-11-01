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
import com.iiht.training.auction.dto.SellerDto;
import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.exceptions.InvalidDataException;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private BidsService bidsService;

	@PostMapping("/register")
	public ResponseEntity<?> registerSeller(@Valid @RequestBody SellerDto sellerDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Seller data is not Valid!");
		}
		sellerService.registerSeller(sellerDto);
		return ResponseEntity.ok(sellerDto);
	}
	
	
	  @PostMapping("/add-product")
	  public ResponseEntity<ProductDto> addproduct(@Valid @RequestBody ProductDto productDto, BindingResult result) {
	  if (result.hasErrors()) { 
		  throw new InvalidDataException("Product Data has issues"); 
		  }
	  sellerService.registerProduct(productDto); 
	  return ResponseEntity.ok(productDto); }
	 
	
	@GetMapping("/show-bids/{productId}")
	public ResponseEntity<BidsDto> showbids(@Valid @RequestBody BidsDto bidsDto, BindingResult result) {
		if (!result.hasErrors()) {
			throw new InvalidDataException("No Bids for the Product ID!");
		}
		return ResponseEntity.ok(bidsDto);
	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<?> deleteProductID(@RequestParam Long sellerId) {
		sellerService.deleteSeller(sellerId);
		return ResponseEntity.ok(true);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateSeller(SellerDto sellerDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Seller data is not Valid!");
		}
		sellerService.updateSeller(sellerDto);
		return ResponseEntity.ok(sellerDto);
	}

	@DeleteMapping("/delete/{sellerId}")
	public ResponseEntity<?> deleteSeller(@RequestParam Long sellerId) {
		sellerService.deleteSeller(sellerId);
		return ResponseEntity.ok(true);
	}

	@GetMapping("/get/{sellerId}")
	public ResponseEntity<?> getSellerById(@RequestParam Long sellerId) {
		SellerDto seller = sellerService.getSellerById(sellerId);
		return ResponseEntity.ok(seller);
	}

	@PostMapping("/get/all")
	public ResponseEntity<?> getAllSellers() {
		List<SellerDto> sellers = sellerService.getAllSellers();
		return ResponseEntity.ok(sellers);
	}
	
	@DeleteMapping("/get/bids-on-product/{productId}")
	public ResponseEntity<?> getBidsByProductId(@PathVariable Long productId) {
		List<BidsDto> allBidsOnProduct = bidsService.getAllBidsOnProduct(productId);
		return ResponseEntity.ok(allBidsOnProduct);
	}

}
