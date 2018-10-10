package com.demo.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsExample {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Jagadeesh");
		names.add("Sarani");
		names.add("Sriram");
		
		Stream<String> newNames= names.stream().filter((s)->s.startsWith("S"));
		newNames.forEach((s)->System.out.println(s));
	}
}
