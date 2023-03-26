package com.manin.in28minutes.spring.aop.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspects {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	//Do somethind before and after method call
	@Around("com.manin.in28minutes.spring.aop.learnspringaop.aopexample.aspects.CommonPointcutConfig.specificMethodCall()")
	public Object trackingTimer(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
		long startTimeMillis = System.currentTimeMillis();
		
		Object resultValue = proceedJoinPoint.proceed();
		long endTimeMillis = System.currentTimeMillis();
		long duration = endTimeMillis-startTimeMillis;
		log.info("Around Aspect {} and executed in {} ms",proceedJoinPoint,duration);
		return resultValue;
	}
}
