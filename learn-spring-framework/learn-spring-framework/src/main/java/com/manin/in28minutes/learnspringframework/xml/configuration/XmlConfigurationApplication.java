package com.manin.in28minutes.learnspringframework.xml.configuration;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manin.in28minutes.learnspringframework.game.GameRunner;

public class XmlConfigurationApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(var context = new ClassPathXmlApplicationContext("ContextConfiguration.xml")){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			
			context.getBean(GameRunner.class).run();
		}
	}

}
