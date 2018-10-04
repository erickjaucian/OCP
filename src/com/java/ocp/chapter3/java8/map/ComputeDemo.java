package com.java.ocp.chapter3.java8.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ComputeDemo {
	public static void main(String[] args) {
		computeIfAbsent();
	}
	
	public static void computeIfPresent() {
		Map<String, Integer> counts = new HashMap<>();
		counts.put("Jenny", 1);
		BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;
		Integer jenny = counts.computeIfPresent("Jenny", mapper);
		Integer sam = counts.computeIfPresent("Sam", mapper);
		System.out.println(counts); // {Jenny=2}
		System.out.println(jenny); // 2
		System.out.println(sam); // null
	}
	
	public static void computeIfAbsent() {
		Map<String, Integer> counts = new HashMap<>();
		counts.put("Jenny", 1);
		Function<String, Integer> mapper = (k) -> 10;
		counts.computeIfAbsent("Erick", mapper);
		counts.computeIfAbsent("Jenny", mapper);
		System.out.println(counts);
	}
	
	public static void nullMapper() {
		Map<String, Integer> counts = new HashMap<>();
		counts.put("Jenny", 1);
		counts.computeIfPresent("Jenny", (k, v) -> null);
		counts.computeIfAbsent("Sam", k -> null);
		System.out.println(counts); // {}
	}
	
}
