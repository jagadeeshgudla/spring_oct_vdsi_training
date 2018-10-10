package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(value=2)
public class Audience {
	
	@Pointcut(value = "execution(* com.demo.spring.Performer.perform(..))")
	public void pCut() {}

	@Before("pCut()")
	@Order(value=1)
	public void takeSeat() {
		System.out.println("Audience taking seats");
	}
	
	@Before("pCut()")
	@Order(value=2)
	public void switchOffMobile() {
		System.out.println("Audience Switching off mobiles  ");
	}
	
	@AfterReturning("pCut()")
	public void applaud() {
		System.out.println("Clapss.. Viseles...  ");
	}
	
	
}
