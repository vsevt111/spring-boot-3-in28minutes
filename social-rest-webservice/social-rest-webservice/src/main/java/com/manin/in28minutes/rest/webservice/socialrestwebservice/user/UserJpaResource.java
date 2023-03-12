package com.manin.in28minutes.rest.webservice.socialrestwebservice.user;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.manin.in28minutes.rest.webservice.socialrestwebservice.jpa.PostRepository;
import com.manin.in28minutes.rest.webservice.socialrestwebservice.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	
	
	private UserRepository repository;
	private PostRepository postRepository;

	public UserJpaResource(UserRepository repository,PostRepository postRepository) {
		this.repository=repository;
		this.postRepository = postRepository;
	}
	
	@GetMapping("/jpa/users")
	public List<User> retreiveAllUser(){
		return repository.findAll();
	}
	
	@GetMapping("/jpa/user/{id}")
	public EntityModel<User> retreiveUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		//hypermedia as the engine of application state
		//HATEOAS
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retreiveAllUser());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	@DeleteMapping("/jpa/user/{id}")
	public void DeleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	//use responseEntity to return response status
	@PostMapping("/jpa/user")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		URI location =ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(savedUser.getId())
					.toUri();
		return ResponseEntity.created(location ).build();
	}
	
	@GetMapping("/jpa/user/{id}/posts")
	public List<Post> retreivePostForUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		return user.get().getPost();
	}
	
	@PostMapping("/jpa/user/{id}/posts")
	public ResponseEntity<Post> createPostForUser(@PathVariable int id,
			@Valid @RequestBody Post post) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);
		URI location =ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location ).build();
	}
}
