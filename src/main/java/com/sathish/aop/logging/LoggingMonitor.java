package com.sathish.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;
/**
*
* @author Sathish Kariyanna
*/

@Aspect
@Component
public class LoggingMonitor {

	@Before("execution(* com..*Service.*(..))")
	public void logServiceAccessEntering(JoinPoint joinPoint) {
		System.out.println("Before: " + joinPoint + "starting...");
	}
	
	@After("execution(* com..*Service.*(..))")
	public void logServiceAccessAfter(JoinPoint joinPoint) {
		System.out.println("After: " + joinPoint );
	}
	

	@AfterReturning("execution(* com..*Service.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.println("AfterReturning: " + joinPoint);
	}
	// we can also have @Around, @AfterThrowing advices
}
