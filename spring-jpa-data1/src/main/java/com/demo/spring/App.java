package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.spring.entity.Emp;
import com.demo.spring.service.HrService;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class);
		HrService hr = (HrService) context.getBean("hrService");
		hr.displayEmpInfo(1212);
		
		hr.empInRange(20000, 50000);
 	}

}
