package com.manin.in28minutes.spring.aop.learnspringaop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

	public int[] retrieveNumber() {
		return new int[] {11,22,33,44,55};
	}
}
