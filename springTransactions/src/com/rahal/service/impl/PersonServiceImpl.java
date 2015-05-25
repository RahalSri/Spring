package com.rahal.service.impl;


import com.rahal.dao.PersonAddressDAO;
import com.rahal.dao.PersonDAO;
import com.rahal.model.Person;
import com.rahal.service.PersonService;

public class PersonServiceImpl implements PersonService{
	
	PersonDAO personDAO = null;
	PersonAddressDAO addressDAO = null;
		
	public PersonDAO getPersonDAO() {
		return personDAO;
	}
	
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public PersonAddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(PersonAddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	public boolean save(Person person){
				
		//PersonDAO personDAO = (PersonDAO)context.getBean("personDAO");
		personDAO.insert(person);
		
		//PersonAddressDAO addressDAO = (PersonAddressDAO)context.getBean("personAddressDAO");
		addressDAO.insert(person);
		
		return true;
	}

}
