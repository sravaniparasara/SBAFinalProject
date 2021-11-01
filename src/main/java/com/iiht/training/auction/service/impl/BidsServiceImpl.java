package com.iiht.training.auction.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.BidsDto;
import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.entity.BidsEntity;
import com.iiht.training.auction.entity.CustomerEntity;
import com.iiht.training.auction.entity.ProductEntity;
import com.iiht.training.auction.entity.SellerEntity;
import com.iiht.training.auction.exceptions.CustomerNotFoundException;
import com.iiht.training.auction.exceptions.SellerNotFoundException;
import com.iiht.training.auction.repository.BidsRepository;
import com.iiht.training.auction.repository.CustomerRepository;
import com.iiht.training.auction.repository.ProductRepository;
import com.iiht.training.auction.repository.SellerRepository;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.ProductService;

@Service
public class BidsServiceImpl implements BidsService {

	private static final String NO_CUSTOMER_ERROR_MESSAGE = "Customer Not found for the ID:: ";
	//private static final String NO_PROUCT_ERROR_MESSAGE = "Product Not found for the ID:: ";
	@Autowired
	private BidsRepository bidsRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	
	@Override
	public BidsDto placeBid(BidsDto bidsDto) {

		//Optional<CustomerEntity> customer = customerRepository.findById(bidsDto.getCustomerId());
		Optional<ProductEntity> product = productRepository.findById(bidsDto.getProductId());
		
		if (product.isPresent()) {
			//CustomerEntity customerEntity = customer.get();// getting existing customer 
			ProductEntity productEntity = product.get();
			BidsEntity bidsEntity = new BidsEntity(bidsDto.getId(),bidsDto.getBidAmount(),bidsDto.getBiddingDate(),
					bidsDto.getProductId(),productEntity);
						//bidsDto.getCustomerId(),
			//Long id, Double bidAmount, LocalDate biddingDate, Long productId, Long customerId,
			//ProductEntity product)
			
			//Date date = new Date();  
			 //if(bidsDto.getBiddingDate() is greaterthan date) { else }
			
			bidsRepository.save(bidsEntity);			
			return bidsDto;
		} else {
			return bidsDto;
			//throw new CustomerNotFoundException(NO_CUSTOMER_ERROR_MESSAGE + bidsDto.getCustomerId());
		}
	}

	@Override
	public List<BidsDto> getAllBidsOnProduct(Long porductId) {
		List<BidsEntity> bids = bidsRepository.getBidsByProductId(porductId);
		List<BidsDto> bidsDtos = new ArrayList<>();
		for (BidsEntity entity : bids) {
			BidsDto bidsDto = new BidsDto();
			BeanUtils.copyProperties(entity, bidsDto);
			
		}
		return bidsDtos;
	}

	@Override
	public List<BidsDto> getAllBidsAfterProductBiddingEndDate(Long porductId) {
		List<BidsEntity> bids = bidsRepository.getBidsByProductId(porductId);
		List<BidsDto> bidsDtos = new ArrayList<>();
		Optional<ProductEntity> productDto = productRepository.findById(porductId);
		System.out.println("My Product===>" + productDto.get().getLastDateOfBidding());
		for (BidsEntity entity : bids) {
			if (entity.getBiddingDate().isBefore(productDto.get().getLastDateOfBidding())
					|| productDto.get().getLastDateOfBidding().isBefore(LocalDate.now())) {
				BidsDto bidsDto = new BidsDto();
				BeanUtils.copyProperties(entity, bidsDto);
				bidsDtos.add(bidsDto);
			}
		}
		return bidsDtos;
	}

	
}
