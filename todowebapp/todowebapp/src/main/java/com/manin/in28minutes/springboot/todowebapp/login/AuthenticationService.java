package com.manin.in28minutes.springboot.todowebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username, String password) {
		boolean isValidUsername = username.equalsIgnoreCase("in28minutes");
		boolean isValidPassword = password.contentEquals("dummy");
		return isValidUsername && isValidPassword;
	}
}
