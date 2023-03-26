package com.manin.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldBean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//try with resources 
		//error occur it will automatically closed this context(context.close())
		try(var context = 
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class))
		{
			System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("address2"));
		System.out.println(context.getBean("person2MethodCall"));
		System.out.println(context.getBean("person3Parameters"));
		System.out.println(context.getBean("person5Qualifier"));
		//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		System.out.println(context.getBean(Address.class));
		}
	}

}
