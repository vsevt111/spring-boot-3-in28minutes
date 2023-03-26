package com.manin.in28minutes.learnspringframework.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{
	
}

@Component
@Lazy //initialize when classB is called
//default is eagerly : initalize when launch spring context
class ClassB{
	private ClassA classA;

	public ClassB(ClassA classA) {
		System.out.println("Some initalization logic");
		this.classA = classA;
	}
	
}


@Configuration
@ComponentScan
public class LazyInitializationAppLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(var context = 
				new AnnotationConfigApplicationContext
				(LazyInitializationAppLauncher.class)){
			System.out.println("ready to call bean");
			
			//it will initialize from below line if add @Lazy on class
			context.getBean(ClassB.class);
		}
	}

}
