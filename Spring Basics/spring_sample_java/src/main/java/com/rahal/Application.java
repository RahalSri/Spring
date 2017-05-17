package com.rahal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rahal.service.CustomerService;
import com.rahal.service.CustomerServiceImpl;

public class Application {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		//CustomerService service = appContext.getBean("customerServiceSetterInj", CustomerService.class);
		//CustomerService service = appContext.getBean("customerServiceConstInj", CustomerService.class);
		CustomerService service = appContext.getBean("customerServiceAutowired", CustomerService.class);
		System.out.println(service.findAll().get(0).getFirstName());

	}

}
