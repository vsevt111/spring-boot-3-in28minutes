package com.manin.in28minutes.spring.aop.learnspringaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
	
	@Pointcut("execution(* com.manin.in28minutes.spring.aop.learnspringaop.aopexample.*.*.*(..))")
	public void businessAndDataPackageConfig() {}
	
	@Pointcut("execution(* com.manin.in28minutes.spring.aop.learnspringaop.aopexample.business.*.*(..))")
	public void businessPackageConfig() {}
	
	@Pointcut("execution(* com.manin.in28minutes.spring.aop.learnspringaop.aopexample.data.*.*(..))")
	public void dataPackageConfig() {}
	
	//beanName = dataService
	@Pointcut("bean(*dataService*)")
	public void dataPackageConfigUsingBean() {}
	
	@Pointcut("@annotation(com.manin.in28minutes.spring.aop.learnspringaop.aopexample.annotation.TrackTime)")
	public void specificMethodCall() {}
}
