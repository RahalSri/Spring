package com.rahal.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rahal.model.Customer;

@Repository("hibernateRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {
	/* (non-Javadoc)
	 * @see com.pluralsight.repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<>();
		Customer customer1 = new Customer();
		customer1.setFirstName("Rahal from hibernate");
		customer1.setLastName("Prabudda from hibernate");
		
		customers.add(customer1);
		return customers;
	}
}
