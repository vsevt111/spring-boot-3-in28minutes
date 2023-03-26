package com.in28minutes.spring.security.learnspringsecurity.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource01 {
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

}
