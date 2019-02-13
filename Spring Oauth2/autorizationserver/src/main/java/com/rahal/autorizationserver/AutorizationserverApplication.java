package com.rahal.autorizationserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class AutorizationserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutorizationserverApplication.class, args);
//		int i = 0;
//		while (i < 10) {
//			String password = "123456";
//			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//			String hashedPassword = passwordEncoder.encode(password);
//
//			System.out.println(hashedPassword);
//			i++;
//		}
	}

}

