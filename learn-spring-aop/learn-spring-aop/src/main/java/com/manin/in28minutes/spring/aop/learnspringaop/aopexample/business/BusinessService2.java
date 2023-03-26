package com.manin.in28minutes.spring.aop.learnspringaop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.manin.in28minutes.spring.aop.learnspringaop.aopexample.data.DataService2;

@Service
public class BusinessService2 {
	
	private DataService2 dataService2;

	public BusinessService2(DataService2 dataService2) {
		this.dataService2 = dataService2;
	}
	
	public int calculateMin() {
		int[] data= dataService2.retrieveNumber();
		//throw new RuntimeException("Something went wrong.");
		return Arrays.stream(data).min().orElse(0);
	}

}
