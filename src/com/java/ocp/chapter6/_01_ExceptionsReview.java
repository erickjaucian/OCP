package com.java.ocp.chapter6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class _01_ExceptionsReview {
	public static void main(String[] args) {
//		int[] x = new int[2];
//		x[1] = "string"; //compile error
		
//		Object[] y = new String[1];
//		y[0] = new Integer(1); // java.lang.ArrayStoreException
		
//		LocalDate localDate = LocalDate.of(1, 13, 40); //java.time.DateTimeException

//		ResourceBundle resourceBundle = ResourceBundle.getBundle("Prop"); //java.util.MissingResourceException
//		String value = ResourceBundle.getBundle("Props").getString("key"); //java.util.MissingResourceException
		
//		String[] stringArray = new String[5];
//		List<String> stringList = Arrays.asList(stringArray);
//		stringList.add("hello"); //java.lang.UnsupportedOperationException
		
//		try {
//			
//		} catch(IOException e) { //unreachable code
//			
//		}
	}
	
	void method() throws IOException {
		throw new FileNotFoundException();
	}
	
	void method1() throws IOException {
		throw new NullPointerException();
	}
}
