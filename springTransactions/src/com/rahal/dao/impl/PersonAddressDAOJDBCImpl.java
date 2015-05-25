package com.rahal.dao.impl;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rahal.dao.PersonAddressDAO;
import com.rahal.model.Person;
import com.rahal.model.PersonAddress;

public class PersonAddressDAOJDBCImpl implements PersonAddressDAO{
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean insert(Person person) {
		// TODO Auto-generated method stub
		PersonAddress address = person.getAddress();
		
		String sqlStmt = "INSERT INTO PersonAddress(id, street, city, country) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sqlStmt, new Object[]{person.getId(), address.getStreet(), address.getCity(), address.getCountry()});
		
		return false;
	}

}
