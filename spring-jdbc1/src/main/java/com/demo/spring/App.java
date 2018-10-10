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
		System.out.println("EMP Details from DB for display()"+hr.displayEmpInfo(1));
		System.out.println("All Employees:"+hr.getALlEmployees());
		hr.removeEmployee(13);
		Emp e= new Emp(1012,"Testing","My System",1);
		System.out.println(hr.registerEmployee(e));
 	}

}
