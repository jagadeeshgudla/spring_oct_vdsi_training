package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.spring.service.HrService;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		HrService hr = (HrService) context.getBean("hrService");
		System.out.println(hr.registerEmployee(123, "Jagadeesh", "Hyderabad", 1000000));
	}

}
