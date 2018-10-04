package com.java.ocp.chapter3.collection;

import java.util.*;

class SampleClass {
	static int x;
	public int hashCode() {
		return x++;
	}
}

public class CollectionMethods<E> {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(1);
		//list.remove(1);
		list.contains(1);
		
		SampleClass sc = new SampleClass();
		SampleClass sc1 = new SampleClass();
		
		Set set1 = new HashSet();
		System.out.println(set1.add(sc));
		System.out.println(set1.add(sc));
		
		Set<Integer> set = new TreeSet<>();
		boolean b1 = set.add(66); // true
		boolean b2 = set.add(10); // true
		boolean b3 = set.add(66); // false
		boolean b4 = set.add(8); // true
		set.add(null);
		for (Integer integer: set) System.out.print(integer + ","); // 8,10,66

	}
}
