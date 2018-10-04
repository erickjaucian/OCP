package com.java.ocp.chapter3.java8.collections;

import java.util.*;

public class ForEachDemo {
	public static void main(String[] args) {
		List<String> cats = Arrays.asList("Annie", "Ripley");
		for(String cat: cats)
		System.out.println(cat);
		
		cats.forEach(c -> System.out.println(c));
		cats.forEach(System.out::println);
	}
}
