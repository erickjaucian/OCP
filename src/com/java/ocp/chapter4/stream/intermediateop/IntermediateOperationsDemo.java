package com.java.ocp.chapter4.stream.intermediateop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperationsDemo {
	public static void main(String[] args) {
		sortedDemo();
	}

	public static void filterDemo() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo", "marsupial");
		s.filter(string -> string.startsWith("m")).forEach(IntermediateOperationsDemo::printString);
	}

	public static void printString(String string) {
		string = "cute ".concat(string);
		System.out.println(string);
	}

	public static void distinctDemo() {
		Stream<String> stream = Stream.of("duck", "duck", "duck", "goose");
		stream.distinct().forEach(IntermediateOperationsDemo::printString);
	}

	public static void limitSkipDemo() {
		Stream<Integer> stream = Stream.iterate(1, i -> i + 1);
		stream.skip(5).limit(2).forEach(System.out::print);
	}

	public static void mapDemo() {
		Stream<String> stream = Stream.of("string", "word", "random");
		stream.map(l -> l.length()).forEach(System.out::println);
	}

	public static void flatMapDemo() {
		List<String> zero = Arrays.asList();
		List<String> one = Arrays.asList("Bonobo");
		List<String> two = Arrays.asList("Mama Gorilla", "Baby G vorilla"); 
		Stream<List<String>> animals = Stream.of(zero, one, two);
		animals.flatMap(l -> l.stream()).forEach(System.out::println);
	}

	public static void sortedDemo() {  
		Stream<Double> s = Stream.generate(Math::random);
		long count = s.peek((l) -> System.out.println("peek1: " + l)).sorted().peek((l) -> System.out.println("peek2: " + l)).count(); // bear-brown-
		System.out.println(count);
		
		Stream<String> stream2 = Stream.of("brown bear-", "grizzly-");
		stream2.sorted((s1, s2) -> s2.length() - s1.length()).forEach(System.out::print); // grizzly-brown
																			// bear-
	}

	public static void peekDemo() {
		Stream<String> stream1 = Stream.of("black bear", "brown bear", "grizzly");
		long count = stream1.filter(s -> s.startsWith("g")).peek(System.out::println).count(); // grizzly
		System.out.println(count); // 1
		
		//bad peek code
		List<Integer> numbers = new ArrayList<>();
		List<Character> letters = new ArrayList<>();
		numbers.add(1);
		letters.add('a');
		Stream<List<?>> stream = Stream.of(numbers, letters);
		stream.map(List::size).forEach(System.out::print); // 11
		
		StringBuilder builder = new StringBuilder();
		Stream<List<?>> good = Stream.of(numbers, letters);
		good.peek(l -> builder.append(l)).map(List::size).forEach(System.out::print); // 11
		System.out.println(builder); // [1][a]
		
		Stream<List<?>> bad = Stream.of(numbers, letters);
		bad.peek(l -> l.remove(0)).map(List::size).forEach(System.out::print); // 00
	}
}
