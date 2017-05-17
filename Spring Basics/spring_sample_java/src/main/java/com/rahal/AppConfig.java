package com.rahal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.rahal.repository.CustomerRepository;
import com.rahal.repository.HibernateCustomerRepositoryImpl;
import com.rahal.service.CustomerService;
import com.rahal.service.CustomerServiceImpl;

@Configuration //replacement of applicationContext
@ComponentScan({"com.rahal"}) // To scan @autowired 
public class AppConfig {
	
	@Bean(name="customerServiceSetterInj")
	public CustomerService getCustomerServiceSetterInj(){
		CustomerServiceImpl service = new CustomerServiceImpl();
		//setter injection
		service.setCustomerRepository(getCustomerRepository());
		return service;
	}
	
	@Bean(name="customerServiceConstInj")
	public CustomerService getCustomerServiceConstInj(){
		// Constructor injection
		CustomerServiceImpl service = new CustomerServiceImpl(getCustomerRepository());	
		return service;
	}
	
	@Bean(name="customerServiceAutowired")
	public CustomerService getCustomerServiceAutowired(){
		// Autowired
		CustomerServiceImpl service = new CustomerServiceImpl();	
		return service;
	}
	
	@Bean(name="customerRepository")
	public CustomerRepository getCustomerRepository(){
		return new HibernateCustomerRepositoryImpl();
	}
}
