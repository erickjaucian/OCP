package com.java.ocp.chapter4.stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {
	public static void main(String[] args) {

	}
	
	static void joining() {
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		String result = ohMy.collect(Collectors.joining(", "));
		System.out.println(result); // lions, tigers, bears
	}
	
	static void averagingInt() {
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		Double result = ohMy.collect(Collectors.averagingInt(String::length));
		System.out.println(result); // 5.333333333333333
	}
	
	static void toCollection() {
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		TreeSet<String> result = ohMy.filter(s -> s.startsWith("t"))
								.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(result); // [tigers]
	}
	
	static void toMap() {
		//good
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		Map<String, Integer> map = ohMy.collect(Collectors.toMap(s -> s, k -> k.length()));
		//System.out.println(map.getClass());
		
		//bad
		//Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
		//Map<Integer, String> map2 = ohMy2.collect(Collectors.toMap(String::length, k -> k)); // BAD
		
		Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
		Map<String, Integer> map3 = ohMy3.collect(Collectors.toMap(s -> s, k -> k.length(), (a,b) -> (a),() -> new TreeMap<String, Integer>()));
		System.out.println(map3);
		System.out.println(map3.getClass());
	}
	
	static void groupingBy() {
		//default return type
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length));
		System.out.println(map); // {5=[lions, bears], 6=[tigers]}
		
		//set value
		Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
		Map<Integer, Set<String>> map1 = ohMy1.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
		System.out.println(map1); // {5=[lions, bears], 6=[tigers]}
		
		//TreeMap return type set value
		Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
		TreeMap<Integer, Set<String>> map2 = ohMy2.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
		System.out.println(map2); // {5=[lions, bears], 6=[tigers]}
		
		//TreeMap return type list value
		Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
		TreeMap<Integer, List<String>> map3 = ohMy3.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
		System.out.println(map3);
		
		//with counting
		Stream<String> ohMy4 = Stream.of("lions", "tigers", "bears");
		Map<Integer, Long> map4 = ohMy4.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println(map4); // {5=2, 6=1}
	}
	
	static void partitioningBy() {
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		Map<Boolean, List<String>> map = ohMy.collect(Collectors.partitioningBy(s -> s.length() <= 5));
		System.out.println(map); // {false=[tigers], true=[lions, bears]}
		
		//still two keys
		Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
		Map<Boolean, List<String>> map1 = ohMy1.collect(Collectors.partitioningBy(s -> s.length() <= 7));
		System.out.println(map1); // {false=[], true=[lions, tigers, bears]}
		
		//type of map value is set. //Unlike groupingBy(), we cannot change the type of Map that gets returned.
		Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
		Map<Boolean, Set<String>> map2 = ohMy2.collect(Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
		System.out.println(map2);// {false=[], true=[lions, tigers, bears]}
	}
}
