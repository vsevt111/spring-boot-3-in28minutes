package com.manin.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.manin.in28minutes.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	public Course findById(long id) {
		return entityManager.find(Course.class,id);
	}
	
	public void deleteById(long id) {
		Course delCour = entityManager.find(Course.class, id);
		entityManager.remove(delCour);
	}
	

}
