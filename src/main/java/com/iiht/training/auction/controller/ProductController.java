package com.iiht.training.auction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.exceptions.InvalidDataException;
import com.iiht.training.auction.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/register")
	public ResponseEntity<?> registerProduct(ProductDto productDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Product data is not Valid!");
		}
		productService.saveProduct(productDto);
		return ResponseEntity.ok(productDto);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateProduct(ProductDto productDto, BindingResult result) {
		if (!result.hasErrors()) {
			throw new InvalidDataException("Product data is not Valid!");
		}
		productService.updateProduct(productDto);
		return ResponseEntity.ok(productDto);
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@RequestParam Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok(true);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getProductById(@RequestParam Long id) {
		ProductDto product = productService.getProductById(id);
		return ResponseEntity.ok(product);
	}

	@GetMapping("/get/all")
	public ResponseEntity<?> getAllProducts() {
		List<ProductDto> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/get/by-seller/{sellerId}")
	public ResponseEntity<?> getAllProductsBySeller(@RequestParam Long sellerId) {
		List<ProductDto> products = productService.getProductsBySeller(sellerId);
		return ResponseEntity.ok(products);
	}

	@GetMapping("/get/by-category/{category}")
	public ResponseEntity<?> getAllProductsByCategory(@PathVariable String category) {
		List<ProductDto> products = productService.getProductsByCategory(category);
		return ResponseEntity.ok(products);
	}

}
