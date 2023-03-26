package com.manin.in28minutes.spring.aop.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
//combination of Advice and Pointcut
//Weaver is spring aop or AspectJ (implementation of aop)
@Aspect
public class LoggerAspects {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	//PointCut - when do you want to execute piece of code(advice)
	//Join Point - a specific instance of an advice, 
	//get detail of this execution
	@Before("com.manin.in28minutes.spring.aop.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
	public void logMethodCall(JoinPoint joinPoint) {
		logger.info("Before call Method {} , args {}",joinPoint,joinPoint.getArgs()); 
		//Advice what you want to do
	}
	
	//do something after successful or throwing method call
	//combination of @AfterThrowing and @AfterReturning
	@After("com.manin.in28minutes.spring.aop.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()")
	public void logMethodCallAfterExecution(JoinPoint joinPoint) {
		logger.info("After call Method {} ",joinPoint); 
		//Advice what you want to do
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.manin.in28minutes.spring.aop.learnspringaop.aopexample.*.*.*(..))",
			throwing = "exception"
			)
	public void logMethodCallAfterException(JoinPoint joinPoint,Exception exception) {
		logger.info("After call Method {} has throw {}",joinPoint,exception); 
		//Advice what you want to do
	}
	
	@AfterReturning(
			pointcut = "com.manin.in28minutes.spring.aop.learnspringaop.aopexample.aspects.CommonPointcutConfig.dataPackageConfig()",
			returning = "resultValue"
			)
	public void logMethodCallAfterException(JoinPoint joinPoint,Object resultValue) {
		logger.info("After call Method {} and get {}",joinPoint,resultValue); 
		//Advice what you want to do
	}
}
