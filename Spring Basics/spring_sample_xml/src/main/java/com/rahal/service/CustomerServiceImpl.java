package com.rahal.service;



import java.util.List;

import com.rahal.model.Customer;
import com.rahal.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(){
		
	}
	
    public CustomerServiceImpl(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}
	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}


	@Override
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
}
