package com.rahal.autorizationserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rahal.autorizationserver.entities.Permission;

public interface PermissionRepository extends CrudRepository<Permission, Long>{

	@Query(value="SELECT p.* FROM user u "
				+"INNER JOIN user_role u_r on u.id = u_r.user_id "
				+"INNER JOIN role r on u_r.role_id = r.id "
				+"INNER JOIN role_permission r_p on r_p.role_id=r.id " 
				+"INNER JOIN permission p on p.id = r_p.permission_id "
				+ "WHERE u.email = :email", 
			
			nativeQuery= true)
	List<Permission> getPermissionsByUser(@Param("email") String email);
}
