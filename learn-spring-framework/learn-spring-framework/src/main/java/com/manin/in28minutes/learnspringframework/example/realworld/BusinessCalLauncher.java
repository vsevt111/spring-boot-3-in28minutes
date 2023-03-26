package com.manin.in28minutes.learnspringframework.example.realworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BusinessCalLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(var context = 
				new AnnotationConfigApplicationContext
				(BusinessCalLauncher.class)){
			
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		}
	}

}
