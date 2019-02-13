package com.rahal.autorizationserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.rahal.autorizationserver.entities.Permission;
import com.rahal.autorizationserver.entities.Role;
import com.rahal.autorizationserver.repository.PermissionRepository;
import com.rahal.autorizationserver.repository.RoleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest {

	@Autowired
	RoleRepository rep;
	@Autowired
	PermissionRepository permRep;
	
	@Test
	public void testCreateRoles() {
		Role r1 = new Role();
		r1.setRefId(UUID.randomUUID().toString());
		r1.setName("oauth_admin");
		r1.setDescription("A role can perform oauth server related actions.");
		
		Role r2 = new Role();
		r2.setRefId(UUID.randomUUID().toString());
		r2.setName("manager");
		r2.setDescription("A role can perform management related actions.");
		
		List<Role> roles = new ArrayList<>();
		roles.add(r1);
		roles.add(r2);
		rep.saveAll(roles);
	}
	
	@Test
	public void testCreateRolePermissions() {
		Role r = rep.findById(4L).get();
		Iterable<Long> ids = Arrays.asList(5l, 6l, 7l, 8l);
		Iterable<Permission> permissions = permRep.findAllById(ids);
		Set<Permission> permSet = new HashSet<>();
		for (Permission perm : permissions) {
			permSet.add(perm);
		}
		r.setPermissions(permSet);
		rep.save(r);
	}
}
