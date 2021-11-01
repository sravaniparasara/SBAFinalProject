package com.iiht.training.auction.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.entity.ProductEntity;
import com.iiht.training.auction.entity.SellerEntity;
import com.iiht.training.auction.exceptions.ProductNotFoundException;
import com.iiht.training.auction.exceptions.SellerNotFoundException;
import com.iiht.training.auction.repository.ProductRepository;
import com.iiht.training.auction.repository.SellerRepository;
import com.iiht.training.auction.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private static final String NO_SELLER_ERROR_MESSAGE = "Seller Not found for the ID:: ";
	private static final String NO_PROUCT_ERROR_MESSAGE = "Product Not found for the ID:: ";
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SellerRepository sellerRepository;

	@Override
	public ProductDto saveProduct(ProductDto productDto) {

		Optional<SellerEntity> seller = sellerRepository.findById(productDto.getSellerId());

		if (seller.isPresent()) {

			SellerEntity sellerEntity = seller.get();// getting existing seller 

			ProductEntity productEntity = new ProductEntity(productDto.getProductId(), productDto.getSellerId(),
					productDto.getName(), productDto.getshortDescription(), productDto.getDetailedDescription(),
					productDto.getQuantity(), productDto.getPrice(), productDto.getStartingBidAmount(),
					productDto.getLastDateOfBidding(), productDto.getCategory(), sellerEntity);

			productRepository.save(productEntity);
			return productDto;
		} else {
			throw new SellerNotFoundException(NO_SELLER_ERROR_MESSAGE + productDto.getSellerId());
		}
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto) {
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(productDto, productEntity);
		return productDto;
	}

	@Override
	public Boolean deleteProduct(Long productId) {	

		Optional<ProductEntity> product = productRepository.findById(productId);
		if (product.isPresent()) {
			ProductEntity productEntity=product.get();
			productRepository.delete(productEntity);
			return true;
								
		} else {
			throw new ProductNotFoundException(NO_PROUCT_ERROR_MESSAGE + productId);
		}
	}
	/*
	 * @Override public Boolean deleteProduct(Long productId) { ProductDto
	 * productById = getProductById(productId); ProductEntity productEntity = new
	 * ProductEntity(); BeanUtils.copyProperties(productById, productEntity);
	 * productRepository.delete(productEntity); return true; }
	 */

	@Override
	public ProductDto getProductById(Long productId) {
		Optional<ProductEntity> findById = productRepository.findById(productId);
		if (!findById.isPresent()) {
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(findById, productDto);
			return productDto;
		} else {
			throw new ProductNotFoundException("Product with id " + productId + " does not exists");
		}
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<ProductEntity> products = productRepository.findAll();
		List<ProductDto> productDtos = new ArrayList<>();
		for (ProductEntity entity : products) {
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(entity, productDto);
			
		}
		return productDtos;
	}

	@Override
	public List<ProductDto> getProductsBySeller(Long sellerId) {
		List<ProductEntity> products = productRepository.findAll();
		List<ProductDto> productDtos = new ArrayList<>();
		for (ProductEntity entity : products) {
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(entity, productDto);
			productDtos.add(productDto);
		}
		return productDtos;
	}

	@Override
	public List<ProductDto> getProductsByCategory(String category) {
		List<ProductEntity> products = productRepository.findByCategory(category);
		List<ProductDto> productDtos = new ArrayList<>();
		for (ProductEntity entity : products) {
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(entity, productDto);
			productDtos.add(productDto);
		}
		return productDtos;
	}

}
