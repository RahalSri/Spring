package com.rahal.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.rahal.model.Customer;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {
	/* (non-Javadoc)
	 * @see com.pluralsight.repository.CustomerRepository#findAll()
	 */
	@Value("${dbUsername}")
	private String dbUserName;

	@Override
	public List<Customer> findAll(){
		
		System.out.println("Setting db user name from propertyFile "+ dbUserName);
		
		List<Customer> customers = new ArrayList<>();
		Customer customer1 = new Customer();
		customer1.setFirstName("Rahal");
		customer1.setLastName("Prabudda");
		
		customers.add(customer1);
		return customers;
	}
}
