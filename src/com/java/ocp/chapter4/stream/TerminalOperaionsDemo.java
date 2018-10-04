package com.java.ocp.chapter4.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperaionsDemo {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("w","o","l","f");
		String s = stream.collect(StringBuffer::new, StringBuffer::append, StringBuffer::append).toString();
		//System.out.println(s);
		
		collectSample();
	}
	
	public static void countSample() {
		//count
		Stream<String> countStream = Stream.of("gorilla", "monkey", "bonobo");
		System.out.println(countStream.count());
		
		Stream<Double> doubleStream = Stream.generate(Math::random);
		System.out.println(doubleStream.count());
	}
	
	public static void minMaxSample() {
		//min and max
		Stream<String> stream1 = Stream.of("monkey", "ape", "bonobo");
		Optional<String> min = stream1.min((s1, s2) -> s1.length()-s2.length());
		min.ifPresent(System.out::println);

		Stream<String> stream2 = Stream.of("monkey", "monkyy", "bonobo");
		Optional<String> max = stream2.max((s1, s2) -> s1.length()-s2.length());
		max.ifPresent(System.out::println);
	}
		
	
	public static void findAnyFindFirstSample() {
		//findAny findFirst
		Stream<String> s = Stream.of("gorilla", "gorilla", "bonobo");
		Stream<String> infinite = Stream.generate(() -> "chimp");
		//s.findFirst().ifPresent(System.out::println); // monkey
		//infinite.findAny().ifPresent(System.out::println); // chimp
	}
		
	public static void anyMatchAllMatchNoneMatchSample() {
		//anyMatch allMatch noneMatch
		List<String> list = Arrays.asList("monkey", "2", "chimp");
		Stream<String> infinite2 = Stream.generate(() -> "chimp");
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
		//System.out.println(list.stream().anyMatch(pred)); // true
		//System.out.println(list.stream().allMatch(pred)); // false
		//System.out.println(list.stream().noneMatch(pred)); // false
		//System.out.println(infinite2.anyMatch(pred)); // true	
	}
	
	public static void forEachSample() {
		//forEach
		Stream<String> stream3 = Stream.of("Monkey", "Gorilla", "Bonobo");
		//stream3.forEach(System.out::print); // MonkeyGorillaBonobo
	}
	
	public static void reduceSample() {
		//reduce
		String[] array = new String[] { "w", "o", "l", "f" };
		String result = "";
		for (String string: array) result = result + string;
		//System.out.println(result);
		
		//T reduce(T paramT, BinaryOperator<T> paramBinaryOperator); --- (1)
		Stream<String> streamSample1 = Stream.of("w", "o", "l", "f");
		String word1 = streamSample1.reduce("", (string, c) -> string + c);
		System.out.println(word1); // wolf
		
		Stream<String> streamSample2 = Stream.of("w", "o", "l", "f");
		String word2 = streamSample2.reduce("", String::concat);
		System.out.println(word2); // wolf
		
		Stream<Integer> streamSample3 = Stream.of(3, 5, 6);
		System.out.println(streamSample3.reduce(1, (a, b) -> a*b));
		
		BinaryOperator<Integer> op = (a, b) -> a * b;
		Stream<Integer> empty = Stream.empty();
		Stream<Integer> oneElement = Stream.of(3);
		Stream<Integer> threeElements = Stream.of(3, 5, 6);
		
		//Optional<T> reduce(BinaryOperator<T> paramBinaryOperator); --- (2)
		empty.reduce(op).ifPresent(System.out::print); // no output
		oneElement.reduce(op).ifPresent(System.out::print); // 3
		threeElements.reduce(op).ifPresent(System.out::print); // 90
		
		//<U> U reduce(U paramU, BiFunction<U, ? super T, U> paramBiFunction, BinaryOperator<U> paramBinaryOperator);
		BinaryOperator<Integer> op1 = (a, b) -> a * b;
		Stream<Integer> stream = Stream.of(3, 5, 6);
		System.out.println(stream.reduce(1, op1, op1)); // 90
	}
	
	public static void collectSample() {
		Stream<String> stream1 = Stream.of("w", "o", "l", "f");
		StringBuilder word = stream1.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(word);
		
		Stream<String> stream2 = Stream.of("w", "o", "l", "f");
		TreeSet<String> set2 = stream2.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		System.out.println(set2); // [f, l, o, w]
		
		Stream<String> stream3 = Stream.of("w", "o", "l", "f");
		TreeSet<String> set3 = stream3.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set3); // [f, l, o, w]
		
		Stream<String> stream4 = Stream.of("w", "o", "l", "f");
		Set<String> set4 = stream4.collect(Collectors.toSet());
		System.out.println(set4); // [f, w, l, o]
	}
}
