package com.in28minutes.spring.security.learnspringsecurity.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
public class ToDosResource {
	
	private static final List<Todo> TODOS_LIST = List.of(new Todo("in28minutes","Get AWS"),
			new Todo("in28minutes","Get Full Stack Developer"));
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/todos")
	public List<Todo> retreiveAllTodos() {
		return TODOS_LIST;
	}
	
	@GetMapping("/users/{username}/todos")
	@PreAuthorize("hasRole('USER') and #username == authentication.name")
	//returnObject mean TODOS_LIST.get(0)
	@PostAuthorize("returnObject.username == 'in28minutes'")
	//jsr250enabled = true
	@RolesAllowed({"ADMIN", "USER"})
	//securedEnabled = true in @EnableMethodSecurity
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public Todo retreiveOneTodos() {
		return TODOS_LIST.get(0);
	}
	
	@PostMapping("/users/{username}/todos")
	public void createTodoList(@PathVariable String username, 
			@RequestBody Todo todo) {
		logger.info("create {} for {} completed",todo,username);
	}

}

record Todo(String username,String description) {}