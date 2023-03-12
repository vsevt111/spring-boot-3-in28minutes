package com.manin.in28minutes.rest.webservice.socialrestwebservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manin.in28minutes.rest.webservice.socialrestwebservice.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
