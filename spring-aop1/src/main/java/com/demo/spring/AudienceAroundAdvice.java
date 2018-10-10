package com.demo.spring;

import org.springframework.core.annotation.Order;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class AudienceAroundAdvice {
	
	@Pointcut(value = "execution(* com.demo.spring.Performer.perform(..))")
	public void pCut() {}

	public void buyTickets() {
		System.out.println("Audience purchased tickets");
	}
	
	public void exit() {
		System.out.println("Exit from hall");
	}
	
	@Around("pCut()")
	public void invoke(ProceedingJoinPoint pjp) throws Throwable{
		buyTickets();
		pjp.proceed();
		exit();
	}
	
}
