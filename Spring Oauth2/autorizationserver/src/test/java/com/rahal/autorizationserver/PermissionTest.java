package com.rahal.autorizationserver;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rahal.autorizationserver.entities.Permission;
import com.rahal.autorizationserver.repository.PermissionRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionTest {

	@Autowired
	PermissionRepository rep;
	
	@Test
	public void testCreatePermissions() {
		Permission p1 = new Permission();
		p1.setName("oauth_create_user");
		
		Permission p2 = new Permission();
		p2.setName("oauth_modify_user");
		
		Permission p3 = new Permission();
		p3.setName("oauth_delete_user");
		
		Permission p4 = new Permission();
		p4.setName("oauth_read_user");
		
		List<Permission> permissions = new ArrayList<>();
		permissions.add(p1);
		permissions.add(p2);
		permissions.add(p3);
		permissions.add(p4);
		
		rep.saveAll(permissions);
	}
	
	@Test
	public void getPermissionsByUser() {
		List<Permission> permissions = rep.getPermissionsByUser("test@gmail.com");
		System.out.println(permissions);
	}
}
