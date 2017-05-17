package com.rahal.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rahal.model.Customer;

@Repository("jdbcRepository")
public class JdbcTemplateCustomerRepositoryImpl implements CustomerRepository {

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<>();
		Customer customer1 = new Customer();
		customer1.setFirstName("Rahal from jdbc template");
		customer1.setLastName("Prabudda from jdbc template");
		
		customers.add(customer1);
		return customers;
	}

}
