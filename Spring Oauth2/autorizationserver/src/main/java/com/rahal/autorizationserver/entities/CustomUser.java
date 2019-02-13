package com.rahal.autorizationserver.entities;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String first_name;
	private String last_name;

	public CustomUser(com.rahal.autorizationserver.entities.User user,
			Collection<GrantedAuthority> grantedAuthorities) {
		super(user.getEmail(), user.getPassword(), grantedAuthorities);
		this.id = user.getId();
		this.first_name = user.getFirstName();
		this.last_name = user.getLastName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}
