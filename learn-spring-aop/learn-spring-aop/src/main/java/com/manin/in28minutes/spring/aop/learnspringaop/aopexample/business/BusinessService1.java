package com.manin.in28minutes.spring.aop.learnspringaop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.manin.in28minutes.spring.aop.learnspringaop.aopexample.annotation.TrackTime;
import com.manin.in28minutes.spring.aop.learnspringaop.aopexample.data.DataService1;

@Service
public class BusinessService1 {
	
	private DataService1 dataService1;

	public BusinessService1(DataService1 dataService1) {
		this.dataService1 = dataService1;
	}
	
	@TrackTime
	public int calculateMax() {
		int[] data= dataService1.retrieveNumber();
		//throw new RuntimeException("Something went wrong.");
		return Arrays.stream(data).max().orElse(0);
	}

}
