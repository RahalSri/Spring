package com.rahal.repository;

import java.util.ArrayList;
import java.util.List;

import com.rahal.model.Customer;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {
	/* (non-Javadoc)
	 * @see com.pluralsight.repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<>();
		Customer customer1 = new Customer();
		customer1.setFirstName("Rahal");
		customer1.setLastName("Prabudda");
		
		customers.add(customer1);
		return customers;
	}
}
