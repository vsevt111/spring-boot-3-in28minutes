package com.manin.in28minutes.rest.webservice.socialrestwebservice.user;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> retreiveAllUser(){
		return service.findAll();
	}
	
	@GetMapping("/user/{id}")
	public EntityModel<User> retreiveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user==null) {
			throw new UserNotFoundException("id:"+id);
		}
		//hypermedia as the engine of application state
		//HATEOAS
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retreiveAllUser());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	@DeleteMapping("/user/{id}")
	public void DeleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
	
	//use responseEntity to return response status
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location =ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(savedUser.getId())
					.toUri();
		return ResponseEntity.created(location ).build();
	}
}
