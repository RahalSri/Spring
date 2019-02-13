package com.rahal.autorizationserver.config;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.StreamUtils;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.rahal.autorizationserver.service.impl.CustomUserDetailsService;

@Configuration
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter{

//	@Value("${security.oauth2.client.client-id}")
//	private String clientId;
//	@Value("${security.oauth2.client.client-secret}")
//	private String clientSecret;
	@Value("${spring.datasource.url}")
    private String datasourceUrl;
    
    @Value("${spring.datasource.driver-class-name}")
    private String dbDriverClassName;
    
    @Value("${spring.datasource.username}")
    private String dbUsername;
    
    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Autowired
    private DataSource dataSource;
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	CustomUserDetailsService customDetailsService;

	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtCustomTokenEnhancer();
		converter.setSigningKey(loadKeyFromFile("private.cert"));
		converter.setVerifierKey(loadKeyFromFile("public.cert"));
		return converter;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(tokenEnhancer());
	}
	
	
	@Bean
    public ApprovalStore approvalStore() {
        return new JdbcApprovalStore(dataSource);
    }
	
	@Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(dataSource);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
			.tokenStore(tokenStore())
			.accessTokenConverter(tokenEnhancer())
			.approvalStore(approvalStore())
			.authorizationCodeServices(authorizationCodeServices())
			.userDetailsService(customDetailsService);
	}

	private String loadKeyFromFile(String fileName) {
		
		 Resource resource = new ClassPathResource(fileName);
		 String key = null;
		 try {
			 key = StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
		} catch (IOException e) {
			System.out.println(e);
		}
		return key;
	}
	
}
