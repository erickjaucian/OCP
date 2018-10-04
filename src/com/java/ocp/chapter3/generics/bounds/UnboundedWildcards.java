package com.java.ocp.chapter3.generics.bounds;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcards {
	public static void printList(List<Superclass> list) {
		for (Superclass x : list)
			System.out.println(x);
	}

	public static void main(String[] args) {
		List<Subclass> keywords = new ArrayList<>();
		keywords.add(new Subclass());
		printList(keywords); // DOES NOT COMPILE
	}
}
