package com.iiht.training.auction.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.BidsDto;
import com.iiht.training.auction.dto.CustomerDto;
import com.iiht.training.auction.dto.SellerDto;
import com.iiht.training.auction.entity.CustomerEntity;
import com.iiht.training.auction.entity.SellerEntity;
import com.iiht.training.auction.exceptions.CustomerNotFoundException;
import com.iiht.training.auction.repository.CustomerRepository;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.CustomerService;
import com.iiht.training.auction.service.ProductService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BidsService bidsService;

	@Override
	public CustomerDto registerCustomer(CustomerDto customerDto) {
		CustomerEntity customerEntity = new CustomerEntity();
		BeanUtils.copyProperties(customerDto, customerEntity);
		customerRepository.save(customerEntity);
		return customerDto;
	}
	

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) {
		return null;
	}

	@Override
	public Boolean deleteCustomer(Long id) {
		return null;
	}

	@Override
	public CustomerDto getCustomerById(Long id) {
		return null;
	}

	@Override
	public List<CustomerDto> getAllCustomers() {

		return null;
	}

	@Override
	public BidsDto placeBid(BidsDto bidsDto) {
		//return null;
		return bidsService.placeBid(bidsDto);
	}

	@Override
	public BidsDto updateBid(BidsDto bidsDto) {
		
		return null;
	}

}
