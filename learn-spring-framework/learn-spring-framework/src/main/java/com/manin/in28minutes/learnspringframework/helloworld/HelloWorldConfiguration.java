package com.manin.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//improved from class 
//don't have to create getter , setter, constructor, toString, equals hashcode method
record Person(String name, int age, Address address) {}
//record release in JDK16
record Address(String firstLine,String city) {}

//multiple bean use @Primary or @Qualifier
//pojo = plain old java object , any object is pojo
//spring context = spring container = IOC container manage spring bean
//spring bean any java object that managed by spring

@Configuration
public class HelloWorldConfiguration {
	@Bean
	public String name() {
		return "Manin";
	}
	
	@Bean
	public int age() {
		return 25;
	}
	
	@Bean
	public Person person() {
		return new Person("Alex",22,new Address("Ramintra","Phrae"));
	}
	
	@Bean 
	Person person2MethodCall() {
		return new Person(name(),age(),address());
	}
	
	@Bean 
	Person person3Parameters(String name, int age , Address address3) {
		return new Person(name,age,address3);
	}
	
	@Bean 
	Person person4Parameters(String name, int age , Address address) {
		return new Person(name,age,address);
	}
	
	@Bean 
	Person person5Qualifier(String name, int age ,@Qualifier("address3Qualifier") Address address) {
		return new Person(name,age,address);
	}
	
	@Bean(name="address2")
	@Primary
	public Address address() {
		return new Address("Krubon","Bangkok");
	}
	
	@Bean(name="address3")
	@Qualifier("address3Qualifier")
	public Address address3() {
		return new Address("Baker Street","London");
	}
	

}
