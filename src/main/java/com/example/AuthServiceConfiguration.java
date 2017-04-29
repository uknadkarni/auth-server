package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthServiceConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override // [2]
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
         endpoints.authenticationManager(authenticationManager);
    }

    @Override // [3]
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
         // @formatter:off
         clients.inMemory()
         .withClient("html5")
         .secret("password")
         .authorizedGrantTypes("password")
         .scopes("openId");
    }
    
	public AuthServiceConfiguration(AuthenticationManager authenticationManager) {
		// TODO Auto-generated constructor stub
		this.authenticationManager=authenticationManager;
	}

}
