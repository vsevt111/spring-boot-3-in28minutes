package com.manin.in28minutes.learnspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//injection or wiring means initialize object to dependency
@Configuration
@ComponentScan
public class DepInjectGameSpringBean {
	
	@Component
	class YourBusinessClass{
		
		//@Autowired //this is field injection
		private Dependency1 dependency1;
		
		//@Autowired
		private Dependency2 dependency2;

		//this is constructor injection/wiring
		//this approach recommend by spring team
		//because all intialization happen in one method when initialize is done
		//bean is ready to use
		public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
			System.out.println("constructor injection");
			this.dependency1 = dependency1;
			this.dependency2 = dependency2;
		}


		@Override
		public String toString() {
			return "YourBusinessClass [dependency1=" + dependency1 + ", dependency2=" + dependency2 + "]";
		}

//		@Autowired // this is a setter injection
//		public void setDependency1(Dependency1 dependency1) {
//			this.dependency1 = dependency1;
//		}
//
//		@Autowired
//		public void setDependency2(Dependency2 dependency2) {
//			this.dependency2 = dependency2;
//		}
		
		
	}
	
	@Component
	class Dependency1{
		
	}
	
	@Component
	class Dependency2{
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(var context = 
				new AnnotationConfigApplicationContext(DepInjectGameSpringBean.class)){
//			context.getBean(GamingConsole.class).up();
//			context.getBean(GameRunner.class).run();
		}
	}

}
