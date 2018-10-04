package com.java.ocp.chapter4.stream.primitivestreams;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BooleanSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
	public static void main(String[] args) {
		linkingStreamsToTheUnderlyingData();
	}
	
	static void intStream() {
		Stream<Integer> stream = Stream.of(1, 2, 3);
		IntStream intStream = stream.mapToInt(x -> x);
	}
	
	static void optionalWithPrimitives() {
		IntStream stream1 = IntStream.rangeClosed(1,10);
		OptionalDouble optDouble1 = stream1.average();
		IntStream stream2 = IntStream.rangeClosed(1,10);
		OptionalInt optDouble2 = stream2.max();
		IntStream stream3 = IntStream.rangeClosed(1,10);
		int sum3 = stream3.sum();
	}
	
	static int summarizingStatistics(IntStream ints) {
		IntSummaryStatistics stats = ints.summaryStatistics();
		if (stats.getCount() == 0) throw new RuntimeException();
		return stats.getMax() - stats.getMin();
	}
	
	static void booleanSupplier() {
		BooleanSupplier b1 = () -> true;
		BooleanSupplier b2 = () -> Math.random() > .5;
		System.out.println(b1.getAsBoolean());
		System.out.println(b2.getAsBoolean());
	}
	
	static void linkingStreamsToTheUnderlyingData() {
		List<String> cats = new ArrayList<>();
		cats.add("Annie");
		cats.add("Ripley");
		Stream<String> stream = cats.stream();
		cats.add("KC");
		System.out.println(stream.count());
	}
}
