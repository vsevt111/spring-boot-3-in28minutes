package com.manin.in28minutes.rest.webservice.socialrestwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	public Post() {
	}

	@Id
	@GeneratedValue
	private int id;
	
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	public Post(int id, String description, User user) {
		this.id = id;
		this.description = description;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public User getUser() {
		return user;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
