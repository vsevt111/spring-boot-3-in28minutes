package com.manin.in28minutes.google.drive.learnoauth.oauth;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

	@GetMapping("/")
	public String test(Authentication auth) {
		System.out.println(auth);
		System.out.println(auth.getPrincipal());
		return "Hello World";
	}
}
