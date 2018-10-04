package com.java.ocp.chapter3.java8.methodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface SampleInterface {
	public int sample(int integer);
}

interface SampleInterfaceTwo<T> {
	public boolean sample(T t);
}

interface SampleInterfaceThree<T, U> {
	public boolean sample(T t, U u);
}

public class MethodReferencesDemo {
	public int count;
	
	public static void main(String[] args) {
		//static reference
		SampleInterface sampleInterface = d -> MethodReferencesDemo.sampleMethod(d);
		SampleInterface sampleInterface1 = MethodReferencesDemo::sampleMethod;
		//printIncrementedInteger(1, sampleInterface1);
		
		Consumer<List<String>> consumer = l -> Collections.sort(l);
		Consumer<List<String>> consumer2 = Collections::sort;
		List<String> arrayList = new ArrayList<>(Arrays.asList("1", "3", "2", "ab", "a"));
		//printSorted(arrayList, consumer2);
		
		//instance method on a particular instance
		MethodReferencesDemo mr = new MethodReferencesDemo();
		Predicate<Integer> predicate2 = x -> mr.isEven(x);
		Predicate<Integer> methodRef2 = mr::isEven;
		//printBoolean2(methodRef2, 25);
		
		//instance method without knowing the instance in advance
		Predicate<String> predicate3 = str -> str.isEmpty();
		Predicate<String> methodRef3 = String::isEmpty;
		//printBoolean1(methodRef3, "");
		
		SampleInterfaceTwo<MethodReferencesDemo> sI = mrd -> mrd.isCountZero(); 
		sI = MethodReferencesDemo::isCountZero;
		
		SampleInterfaceThree<MethodReferencesDemo, Integer> sample = (mrd, integer1) -> isSameCount(mrd, integer1); 
		sample = MethodReferencesDemo::isSameCount;
		
		//print(sample, new MethodReferencesDemo(), 10);
		//print(sample, new MethodReferencesDemo(), 0);
		
		
		//constructor reference
		Supplier<ArrayList<String>> supplier = () -> new ArrayList<String>(arrayList);
		supplier = ArrayList<String>::new;
		method(supplier);
	}
	
	public static void method(Supplier supplier) {
		System.out.println(supplier.get());
	}
	
	public static void print(SampleInterfaceThree st, MethodReferencesDemo mr, Integer i) {
		System.out.println(st.sample(mr, i));
	}
	
	public static boolean isSameCount(MethodReferencesDemo md, Integer i) {
		return md.count == i;
	}
	
	public boolean isCountZero() {
		return count == 0;
	}
	
	public static void printBoolean1(Predicate<String> predicate, String string) {
		System.out.println(predicate.test(string));
	}
	
	public static void printBoolean2(Predicate<Integer> predicate, Integer integer) {
		System.out.println(predicate.test(integer));
	}
	
	public static void printIncrementedInteger(int x, SampleInterface sampleInterface) {
		System.out.println(sampleInterface.sample(x));
	}
	
	public static int sampleMethod(int integer) {
		return integer + 1;
	}
	
	public static void printSorted(List<String> list, Consumer<List<String>> consumer) {
		consumer.accept(list);
		System.out.println(list);
	}
	
	public boolean isEven(int x) {
		return x%2 == 0;
	}
}
