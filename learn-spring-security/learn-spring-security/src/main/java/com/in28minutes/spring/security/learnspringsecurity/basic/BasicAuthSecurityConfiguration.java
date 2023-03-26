package com.in28minutes.spring.security.learnspringsecurity.basic;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(jsr250Enabled = true, securedEnabled = true)
public class BasicAuthSecurityConfiguration {
	enum Roles {
		  USER,
		  ADMIN
		}
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(
				auth-> auth
				.requestMatchers("/users").hasRole("USER")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest()
				.authenticated());
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		//http.formLogin();
		http.httpBasic();
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();
		return http.build();
	}
	
//	@Bean
//	public UserDetailsService userDetailService() {
//		var user = User.withUsername("in28minutes")
//			.password("{noop}dummy")
//			.roles(String.valueOf(Roles.USER))
//			.build();
//		
//		var admin = User.withUsername("admin")
//				.password("{noop}dummy")
//				.roles(String.valueOf(Roles.ADMIN))
//				.build();
//		return new InMemoryUserDetailsManager(user,admin);
//	}
	
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
				.build();
	}
	
	@Bean
	public UserDetailsService userDetailService(DataSource dataSource) {
		var user = User.withUsername("in28minutes")
			.password("dummy")
			.passwordEncoder(str -> passwordEncoder().encode(str))
			.roles(String.valueOf(Roles.USER))
			.build();
		
		var admin = User.withUsername("admin")
				.password("dummy")
				.passwordEncoder(str -> passwordEncoder().encode(str))
				.roles(String.valueOf(Roles.ADMIN))
				.build();
		var jdbcUserDetail = new JdbcUserDetailsManager(dataSource);
		jdbcUserDetail.createUser(user);
		jdbcUserDetail.createUser(admin);
		return jdbcUserDetail;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
