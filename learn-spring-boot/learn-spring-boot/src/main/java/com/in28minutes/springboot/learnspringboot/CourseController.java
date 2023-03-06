package com.in28minutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	CurrencyServiceConfiguration configurationProperties;
	
	@RequestMapping("/courses")
	public List<Course> retreiveAllCourse(){
		return Arrays.asList(new Course(1,"Learn AWS","in28minutes"),
				new Course(2,"LEarn DevOps","in28minutes"),
				new Course(3,"learn Azure","in28minutes"));
	}
	
	@RequestMapping("/currency-service")
	public CurrencyServiceConfiguration retreiveCurrencyConfig() {
		return configurationProperties;
	}

}
