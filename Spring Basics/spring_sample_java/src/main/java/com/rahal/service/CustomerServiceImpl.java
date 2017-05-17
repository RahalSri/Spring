package com.rahal.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rahal.model.Customer;
import com.rahal.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository ;

	public CustomerServiceImpl(){
		
	}
	
	public CustomerServiceImpl(CustomerRepository customerRepository){
		System.out.println("Calling constructor injection");
		this.customerRepository = customerRepository;
	}
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("Calling Setter injection");
		this.customerRepository = customerRepository;
	}


	@Override
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
}
