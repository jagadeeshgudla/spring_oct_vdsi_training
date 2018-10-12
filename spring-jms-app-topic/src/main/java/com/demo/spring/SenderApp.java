package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SenderApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JmsConfig.class);
		JmsTemplate jt =(JmsTemplate) ctx.getBean("jtPubSub");

		for (int i = 0; i <= 10; i++) {
			 final int count=i;
			jt.send("demotopic", new MessageCreator() {
				
				public Message createMessage(Session session) throws JMSException {
					TextMessage tm = session.createTextMessage();
					tm.setText("Hello Spring Message "+count);
					return tm;
				}
			});
		}

		System.out.println("Message sent.....");

	}

}
