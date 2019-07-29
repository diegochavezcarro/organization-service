package com.diego.microdemo.organization.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private DefaultTokenServices tokenServices;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/v1/organizations/**").hasRole("ADMIN").anyRequest()
		//		.authenticated();
		http.authorizeRequests().anyRequest().hasRole("ADMIN");
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenServices(tokenServices);
		resources.resourceId("account");
	}
}
