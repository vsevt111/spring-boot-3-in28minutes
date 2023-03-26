package com.manin.in28minutes.learnspringframework.cdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.inject.Inject;
import jakarta.inject.Named;
//spring implementation for cdi 
//cdi jakarta context and dependency injection
//cdi is a specification(interface)
//@Component
@Named //cdi annotation alternative for @Component (Jakarta EE, javaEE,j2ee)
class BusinessService{
	private DataService dataService;

	public DataService getDataService() {
		return dataService;
	}

//	@Autowired
	@Inject // cdi annotation alternative for @Autowired
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	
}

//@Component
@Named
class DataService{
	
}


@Configuration
@ComponentScan
public class CdiContextAppLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(var context = 
				new AnnotationConfigApplicationContext
				(CdiContextAppLauncher.class)){
			
			System.out.println(context.getBean(BusinessService.class).getDataService());
		}
	}

}
