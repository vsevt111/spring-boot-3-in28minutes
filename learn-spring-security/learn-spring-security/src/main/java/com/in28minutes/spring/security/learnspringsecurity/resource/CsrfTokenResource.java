package com.in28minutes.spring.security.learnspringsecurity.resource;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CsrfTokenResource {
	
	@GetMapping("/csrf")
	public CsrfToken helloWorld(HttpServletRequest request) {
		return (CsrfToken)request.getAttribute("_csrf");
	}

}
