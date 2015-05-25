package com.rahal.dao.impl;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rahal.dao.PersonDAO;
import com.rahal.model.Person;


public class PersonDAOJDBCImpl implements PersonDAO{
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean insert(Person person) {
		
		String sqlStmt = "INSERT INTO Person(id, name, age) VALUES (?, ?, ?)";
		jdbcTemplate.update(sqlStmt, new Object[]{person.getId(), person.getName(), person.getAge()});
		
		return true;
	}
	
	

}
