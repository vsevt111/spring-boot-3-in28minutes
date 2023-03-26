package com.manin.in28minutes.spring.aop.learnspringaop;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.manin.in28minutes.spring.aop.learnspringaop.aopexample.business.BusinessService1;
import com.manin.in28minutes.spring.aop.learnspringaop.aopexample.business.BusinessService2;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private BusinessService1 businessService1;
	private BusinessService2 businessService2;
	
	public LearnSpringAopApplication(BusinessService1 businessService1,
			BusinessService2 businessService2) {
		this.businessService1 = businessService1;
		this.businessService2 = businessService2;
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("max value is {}",businessService1.calculateMax());
		logger.info("max value is {}",businessService2.calculateMin());
	}

}
