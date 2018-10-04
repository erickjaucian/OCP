package com.java.ocp.chapter3.generics.bounds;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcards {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("tweet");
		List<Object> objects = new ArrayList<Object>(strings);
		addSound(strings);
		addSound(objects);
	}
}
