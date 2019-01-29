package com.rahal.resourceserver.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.rahal.resourceserver.model.UserModel;

@Repository
public class UserResourceRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	public void createUser(UserModel user) {
		jdbcTemplate.update("insert into users(country, first_name, last_name, mobile, email_id, password, user_type "
				+ "values (?, ?, ?, ?, ?, ?, ?)", new Object[] {user.getCountry(), user.getFirst_name(), user.getLast_name(),
						user.getMobile(), user.getEmail_id(), passwordEncoder.encode(user.getPassword()), user.getUser_type() });
	}
}
