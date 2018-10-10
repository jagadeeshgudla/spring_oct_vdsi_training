package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
			ApplicationContext context= new ClassPathXmlApplicationContext("context.xml");
			
			Mail mail= (Mail)context.getBean("mail");
			
			System.out.println("Body is :"+mail.getMessage().getBody());
			
			
			Mail mail1=(Mail) context.getBean("mail");
			System.out.println("Are they same?"+(mail==mail1));
	}

}
