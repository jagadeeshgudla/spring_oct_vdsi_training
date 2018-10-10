package com.demo.spring;

public class Mail {

	private Message message;
	private String toAddress;
	private String fromAddress;
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	@Override
	public String toString() {
		return "Mail [message=" + message + ", toAddress=" + toAddress + ", fromAddress=" + fromAddress + "]";
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public Mail(String fromAddress) {
		super();
		this.fromAddress = fromAddress;
	}
	
}
