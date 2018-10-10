package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(AopConfig.class);
		Performer permfromer= (Performer)ctx.getBean("singer");
		permfromer.perform();
	}
}
