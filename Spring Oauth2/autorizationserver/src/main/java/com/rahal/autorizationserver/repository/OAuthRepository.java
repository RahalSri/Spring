package com.rahal.autorizationserver.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import com.rahal.autorizationserver.entities.UserEntity;

@Repository
public class OAuthRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserEntity getUserDetails(String email){
		Collection<GrantedAuthority> gratedAuthorities = new ArrayList<>();
		String query = "select * from users where email_id=?";
		
		List<UserEntity> list = jdbcTemplate.query(query, new String[]{email},
				(ResultSet rs, int rowNum) -> {
					UserEntity user = new UserEntity();
					user.setCountry(rs.getString("country"));
					user.setEmail_id(rs.getString("email_id"));
					user.setFirst_name(rs.getString("first_name"));
					user.setLast_name(rs.getString("last_name"));
					user.setMobile(rs.getString("mobile"));
					user.setId(rs.getString("id"));
					user.setUser_type(rs.getString("user_type"));
					user.setPassword(rs.getString("password"));
					return user;
				});
					
		if(!list.isEmpty()) {
			UserEntity userEntity = list.get(0);
			
			if(userEntity.getUser_type() != null){
				if(!userEntity.getUser_type().trim().equalsIgnoreCase("super_admin")) {
					String permissionQuery = "select p.permission_name from users u "
							+ "inner join role_users r_u on u.id=r_u.user_id "
							+ "inner join role r on r_u.role_id=r.id "
							+ "inner join role_permission r_p on r_p.role_id=r.id "
							+ "inner join permission p on p.id=r_p.permission_id "
							+ "where u.email_id=?";
					List<String> permissions = jdbcTemplate.query(permissionQuery, new String[] {email}, 
							(ResultSet rs, int rowNum) -> {
								return "ROLE_" + rs.getString("PERMISSION_NAME");
							});
					if(permissions != null && !permissions.isEmpty()) {
						for(String permission: permissions) {
							GrantedAuthority g = new SimpleGrantedAuthority(permission);
							gratedAuthorities.add(g);
						}
						list.get(0).setGrantedAuthorities(gratedAuthorities);
					}
					return list.get(0);
				} else {
					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
					gratedAuthorities.add(grantedAuthority);
					list.get(0).setGrantedAuthorities(gratedAuthorities);
					return list.get(0);
				}
			}else {
				return null;
			}
		}
		return null;
	} 

}
