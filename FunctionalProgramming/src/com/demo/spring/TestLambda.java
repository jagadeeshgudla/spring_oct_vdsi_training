package com.demo.spring;

public class TestLambda {

	public static void main(String[] args) {
		Thread t = new Thread(()->System.out.println("Testing Lambda"));
		t.start();
	}

}
