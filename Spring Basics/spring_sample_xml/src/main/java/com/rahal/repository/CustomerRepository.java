package com.rahal.repository;

import java.util.List;

import com.rahal.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}