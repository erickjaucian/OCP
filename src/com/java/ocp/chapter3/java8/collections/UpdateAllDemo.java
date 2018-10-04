package com.java.ocp.chapter3.java8.collections;

import java.util.Arrays;
import java.util.List;

public class UpdateAllDemo {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("1", "2", "3");
		list.replaceAll(x -> x+2);
		System.out.println(list);
	}
}
