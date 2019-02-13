package com.rahal.autorizationserver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
import com.rahal.autorizationserver.repository.RoleRepository;
import com.rahal.autorizationserver.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Autowired
	UserRepository rep;
	@Autowired
	RoleRepository roleRep;

	@Test
	public void testCreateUser() {
		User u = new User();
		u.setRefId(UUID.randomUUID().toString());
		u.setEmail("test@gmail.com");
		u.setFirstName("Rahal");
		u.setLastName("Ekanayaka");
		u.setPassword("$2a$10$0/GZ27JvaY.j8Nz4rwJRD.IAmSberbdEXXKdXgUmSmyzFWHYB2wKW");
		rep.save(u);
	}
	
	@Test
	public void testAttchRolesToUser() {
		User u = rep.findById(1L).get();
		Iterable<Long> ids = Arrays.asList(4l, 5l);
		Iterable<Role> roles = roleRep.findAllById(ids);
		Set<Role> roleSet = new HashSet<>();
		for (Role r : roles) {
			roleSet.add(r);
		}
		//roles.forEach(roleSet:: add);
		u.setRoles(roleSet);
		rep.save(u);
	}

}
