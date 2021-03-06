package com.rahal.autorizationserver;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rahal.autorizationserver.entities.Role;
import com.rahal.autorizationserver.entities.User;
import com.rahal.autorizationserver.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutorizationserverApplicationTests {
	
	@Autowired
	UserRepository rep;

	@Test
	public void testCreateEmployee() {
		User u = new User();
		u.setRefId(UUID.randomUUID().toString());
		u.setFirstName("Rahal");
		rep.save(u);
	}
	
	@Test
	public void testm2mCreateUserWithRole() {
		User u = new User();
		u.setRefId(UUID.randomUUID().toString());
		u.setEmail("test@gmail.com");
		u.setFirstName("Rahal");
		u.setLastName("Ekanayaka");
		u.setPassword("$2a$10$0/GZ27JvaY.j8Nz4rwJRD.IAmSberbdEXXKdXgUmSmyzFWHYB2wKW");
		
		Role r = new Role();
		r.setRefId(UUID.randomUUID().toString());
		r.setName("oauth_admin");
		r.setDescription("A role can perform oauth server related actions.");

		Set<Role> roles = new HashSet<>();
		roles.add(r);
		u.setRoles(roles);
		
		rep.save(u);

	}

	@Test
	@Transactional
	public void loadUser() {
		User u = rep.findById(1L).get();
		System.out.println(u.getFirstName());
		System.out.println(u.getRoles());
	}
}

