package com.iiht.training.auction.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.dto.SellerDto;
import com.iiht.training.auction.entity.SellerEntity;
import com.iiht.training.auction.exceptions.SellerNotFoundException;
import com.iiht.training.auction.repository.ProductRepository;
import com.iiht.training.auction.repository.SellerRepository;
import com.iiht.training.auction.service.ProductService;
import com.iiht.training.auction.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
	@Override
	public SellerDto registerSeller(SellerDto sellerDto) {
		SellerEntity sellerEntity = new SellerEntity();
		BeanUtils.copyProperties(sellerDto, sellerEntity);
		sellerRepository.save(sellerEntity);
		return sellerDto;
	}

	@Override
	public SellerDto updateSeller(SellerDto sellerDto) {
		SellerEntity sellerEntity = new SellerEntity();
		BeanUtils.copyProperties(sellerDto, sellerEntity);
		sellerRepository.save(sellerEntity);
		return sellerDto;
	}

	@Override
	public Boolean deleteSeller(Long sellerId) {
		
		return null;
	}

	@Override
	public SellerDto getSellerById(Long sellerId) {
		Optional<SellerEntity> seller = sellerRepository.findById(sellerId);
		if (!seller.isPresent()) {
			SellerDto sellerDto = new SellerDto();
			BeanUtils.copyProperties(seller, sellerDto);
			return sellerDto;
		} else {
			throw new SellerNotFoundException("Seller with id " + sellerId + " does not exists");
		}
	}

	@Override
	public List<SellerDto> getAllSellers() {
		List<SellerEntity> sellers = sellerRepository.findAll();
		List<SellerDto> sellerDtos = new ArrayList<>();
		for (SellerEntity entity : sellers) {
			SellerDto sellerDto = new SellerDto();
			BeanUtils.copyProperties(entity, sellerDto);
			
		}
		return sellerDtos;
	}

	@Override
	public ProductDto registerProduct(ProductDto productDto) {
		
		return productService.saveProduct(productDto);
	}

	@Override
	public Boolean deleteProduct(Long productId) {
		 	 	
		return productService.deleteProduct(productId);
	}

}
