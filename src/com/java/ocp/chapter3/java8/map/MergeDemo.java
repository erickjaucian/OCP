package com.java.ocp.chapter3.java8.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MergeDemo {
	public static void main(String[] args) {
	}
	
	public static void sample1() {
		BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;

		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		favorites.put("Tom", "Tram");

		String jenny = favorites.merge("Jenny", "Skyride", mapper);
		String tom = favorites.merge("Tom", "Skyride", mapper);

		System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
		System.out.println(jenny); // Bus Tour
		System.out.println(tom); // Skyride
	}
	
	public static void sample2() {
		//The merge() method also has logic for what happens if nulls or missing keys are involved.
		
		BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
		Map<String, String> favorites = new HashMap<>();
		favorites.put("Sam", null);
		favorites.merge("Tom", "Skyride", mapper);
		favorites.merge("Sam", "Skyride", mapper);
		System.out.println(favorites); // {Tom=Skyride, Sam=Skyride}
	}
	
	public static void sample3() {
		BiFunction<String, String, String> mapper = (v1, v2) -> null;
		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		favorites.put("Tom", "Bus Tour");
		favorites.merge("Jenny", "Skyride", mapper);
		favorites.merge("Sam", "Skyride", mapper);
		System.out.println(favorites); // {Tom=Bus Tour, Sam=Skyride}
	}
}
