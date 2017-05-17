package com.rahal.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rahal.model.Customer;
import com.rahal.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	//Autowiring on properties
	@Autowired
	@Qualifier("hibernateRepository")
	private CustomerRepository customerRepository;
	
	//Aurowiring on construtor
	@Autowired
	public CustomerServiceImpl(@Qualifier("hibernateRepository") CustomerRepository customerJdbcRepository) {
		System.out.println("We are in consturctor injection");
		this.customerRepository = customerJdbcRepository;
	}
	
	//Autowiring on setters
	@Autowired
	@Qualifier("hibernateRepository")
	public void setCustomerJdbcRepository(CustomerRepository customerJdbcRepository) {
		System.out.println("Inside setter injection");
		this.customerRepository = customerJdbcRepository;
	}


	@Override
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
}
