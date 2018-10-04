package com.java.ocp.chapter3.generics;

public class Box {
	public static <T> void ship(T t) {
		System.out.println(t);
	}
	
	public static void main(String[] args) {
		Box.<String>ship("string");
		Box.<String[]>ship(new String[0]);
	}
}
