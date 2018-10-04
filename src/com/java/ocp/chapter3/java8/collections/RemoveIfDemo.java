package com.java.ocp.chapter3.java8.collections;

import java.util.*;
public class RemoveIfDemo {
	public static void main(String[] args) {
		List<String> greetings = new ArrayList<String>();
		greetings.add("hello");
		greetings.add("hi");
		greetings.add("bye");
		greetings.removeIf(s -> s.startsWith("h"));
		System.out.println(greetings);
	}
}
