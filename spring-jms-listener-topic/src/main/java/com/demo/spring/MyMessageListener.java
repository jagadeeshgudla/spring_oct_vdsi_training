package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListener {
	@JmsListener(destination="demotopic",containerFactory="factory")
	public void recevieMessage(Message message) {
		TextMessage msg= (TextMessage)message;
		try {
			System.out.println("Message is :"+msg.getText());
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
	}
}
