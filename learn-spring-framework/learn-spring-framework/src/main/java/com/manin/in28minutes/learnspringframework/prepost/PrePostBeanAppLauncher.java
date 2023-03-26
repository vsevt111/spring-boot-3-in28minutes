package com.manin.in28minutes.learnspringframework.prepost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass{
	private SomeDependency someDependency;

	public SomeClass(SomeDependency someDependency) {
		this.someDependency = someDependency;
		System.out.println("all dependencies is ready/wired in");
	}
	
	@PostConstruct
	public void initialize() {
		System.out.println("some logic initialize");
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("release resources");
	}
	
}

@Component
class SomeDependency{
	
}


@Configuration
@ComponentScan
public class PrePostBeanAppLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(var context = 
				new AnnotationConfigApplicationContext
				(PrePostBeanAppLauncher.class)){
		}
	}

}
