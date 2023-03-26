package com.manin.in28minutes.spring.aop.learnspringaop.aopexample.data;

import org.springframework.stereotype.Repository;

import com.manin.in28minutes.spring.aop.learnspringaop.aopexample.annotation.TrackTime;

@Repository
public class DataService2 {

	@TrackTime
	public int[] retrieveNumber() {
		return new int[] {111,222,333,444,555};
	}
}
