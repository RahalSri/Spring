package com.rahal;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rahal.model.Person;
import com.rahal.model.PersonAddress;
import com.rahal.service.PersonService;

public class TransactionTest {
	
	static Logger log = Logger.getLogger(TransactionTest.class.getName());
	
	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com\\rahal\\config.xml");
		
		//Create person object
		Person p = new Person();
		p.setId(1);
		p.setName("Aravinda de Silva");
		p.setAge(45);
		
		//Create address object
		PersonAddress address = new PersonAddress();
		address.setStreet("xxxxxxxx xxxxxxxxxxxxx xxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxx xxxxxxxxxxxx xxxxxxxxxxxxxxxx xxxxxxxxxxxxxxx xxxxxxxxxxxxxxxx xxxxxxxxxxxxxx");
		address.setCity("Maradana");
		address.setCountry("Sri Lanka");
		
		p.setAddress(address);
		
		// Start: Not transaction.
		PersonService personService = (PersonService)context.getBean("personService");
		personService.save(p);
		// End: Not transaction.
		
		//Start: transaction.
		PersonService personServiceTrans = (PersonService)context.getBean("personServiceProxy");
		personServiceTrans.save(p);
		//End: transaction.
	}

}
