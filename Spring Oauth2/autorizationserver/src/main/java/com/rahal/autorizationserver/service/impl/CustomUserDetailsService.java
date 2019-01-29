package com.rahal.autorizationserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Service;

import com.rahal.autorizationserver.entities.CustomUser;
import com.rahal.autorizationserver.entities.UserEntity;
import com.rahal.autorizationserver.repository.OAuthRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private OAuthRepository oauthRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity userEntity = null;
		try {
			userEntity = oauthRepo.getUserDetails(username);
			if(userEntity != null && userEntity.getId() != null) {
				CustomUser c = new CustomUser(userEntity);
				return c;
			} else {
				throw new UsernameNotFoundException("User " + username +" Not found in the database.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("User " + username +" Not found in the database.");
		}
	}

}
