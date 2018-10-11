package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class BootStrap {

	public static void main(String[] args) throws JMSException {
		System.out.println("Listener STarted");
		ApplicationContext ctx= new AnnotationConfigApplicationContext(JmsConfig.class);
		
	}

}
