package com.java.ocp.chapter4.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreatingStreamSourceDemo {
	public static void main(String[] args) {
		Stream<String> emptyStream = Stream.empty();
		Stream<Integer> singleElementStream = Stream.of(1);
		Stream<Integer> fromArrayStream = Stream.of(1, 2, 3); //varargs
		System.out.println(emptyStream.count());
		System.out.println(singleElementStream.count());
		System.out.println(fromArrayStream.count());
		
		List<String> list = Arrays.asList("1", "2", "3");
		Stream<String> steamFromArrayList = list.stream();
		Stream<String> fromListParrallel = list.parallelStream();
		
		
		Stream<Double> streamDouble = Stream.generate(Math::random);
		streamDouble.forEach(System.out::println);
		
		Stream<Integer> oddNumbers = Stream.iterate(1, i -> i + 2);
		oddNumbers.forEach(System.out::println);
	}
}
