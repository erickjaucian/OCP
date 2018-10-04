package com.java.ocp.chapter5.section2_strings;

public class _1_String {
	public static void main(String[] args) {
		methodThree();
		// methodFour();
	}

	static void methodOne() {
		String s1 = "bunny";
		String s2 = "bunny";
		String s3 = new String("bunny");
		System.out.println(s1 == s2); // true
		System.out.println(s1 == s3); // false
		System.out.println(s1.equals(s3)); // true
	}

	static void methodTwo() {
		String s4 = "1" + 2 + 3;
		String s5 = 1 + 2 + "3";
		System.out.println(s4); // 123
		System.out.println(s5); // 33
	}

	static void methodThree() {
		String s = "abcde ";
		System.out.println(s.trim().length()); // 5
		System.out.println(s.charAt(4)); // e
		System.out.println(s.indexOf('e')); // 4
		System.out.println(s.indexOf("de")); // 3
		System.out.println(s.substring(2, 4).toUpperCase()); // CD
		System.out.println(s.replace('a', '1')); // 1bcde
		System.out.println(s.contains("DE")); // false
		System.out.println(s.startsWith("a")); // true
		System.out.println(s);
	}

	static void methodFour() {
		StringBuilder b1 = new StringBuilder(1);
		//StringBuilder b1 = new StringBuilder(1.0); DNC
		
		StringBuilder b = new StringBuilder();
		b.append(12345).append('-');
		System.out.println(b.length()); // 6
		System.out.println(b.indexOf("-")); // 5
		System.out.println(b.charAt(2)); // 3

		StringBuilder b2 = b.reverse();
		System.out.println(b.toString()); // -54321
		System.out.println(b == b2); // true

		System.out.println(b);
		System.out.println(b2);
	}

	static void methodFive() {
		StringBuilder s = new StringBuilder("abcde");
		s.insert(1, '-').delete(3, 4);
		System.out.println(s); // a-bde
		System.out.println(s.substring(2, 4)); // bd
	}
}
