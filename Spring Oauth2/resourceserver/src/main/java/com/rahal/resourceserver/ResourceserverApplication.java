package com.rahal.resourceserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@SpringBootApplication
//@EnableResourceServer
public class ResourceserverApplication {

    
	public static void main(String[] args) {
		SpringApplication.run(ResourceserverApplication.class, args);
	}

}

