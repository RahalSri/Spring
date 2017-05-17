package com.rahal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rahal.service.CustomerService;
import com.rahal.service.CustomerServiceImpl;

public class Application {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context.xml");
		
		CustomerService service = appContext.getBean("customerServiceAutowire", CustomerService.class);
		//CustomerService service = appContext.getBean("customerServicePropInjection", CustomerService.class);
		//CustomerService service = appContext.getBean("customerServiceConsInjection", CustomerService.class);
		System.out.println(service.findAll().get(0).getFirstName());
		

	}

}
