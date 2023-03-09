package com.manin.in28minutes.springboot.todowebapp.security;

import java.util.function.Function;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean 
	public InMemoryUserDetailsManager createUser( ) {
		UserDetails userdetail1 = createNewUser("in28minutes", "dummy");
		UserDetails userdetail2 = createNewUser("ranga", "dummydummy");
		return new InMemoryUserDetailsManager(userdetail1,userdetail2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> encoder = input->passwordEncoder().encode(input);
		
		UserDetails userdetail = User.builder().passwordEncoder(encoder )
								 	.username(username)
								 	.password(password)
								 	.roles("USER","ADMIN")
								 	.build();
		return userdetail;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth->auth.anyRequest().authenticated());
		
	
		http.formLogin(withDefaults());
		//add process below
		//csrf disable
		//frame disable (X-frame-Options) because h2 make use of frame and spring security enable by default
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
	}

}
