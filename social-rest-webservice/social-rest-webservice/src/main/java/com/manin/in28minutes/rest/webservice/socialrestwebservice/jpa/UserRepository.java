package com.manin.in28minutes.rest.webservice.socialrestwebservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manin.in28minutes.rest.webservice.socialrestwebservice.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
