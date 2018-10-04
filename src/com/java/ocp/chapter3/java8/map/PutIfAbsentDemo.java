package com.java.ocp.chapter3.java8.map;

import java.util.HashMap;
import java.util.Map;

public class PutIfAbsentDemo {
	public static void main(String[] args) {
		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		favorites.put("Tom", null);
		favorites.putIfAbsent("Jenny", "Tram");
		favorites.putIfAbsent("Sam", "Tram");
		favorites.putIfAbsent("Tom", "Tram");
		System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}
	}
}
