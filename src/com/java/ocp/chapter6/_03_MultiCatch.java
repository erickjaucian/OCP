package com.java.ocp.chapter6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

//Java 7
public class _03_MultiCatch {
	public static void main(String[] args) {
		try {
			Path path = Paths.get("dolphinsBorn.txt");
			String text = new String(Files.readAllBytes(path)); //java.nio.file.NoSuchFileException
			LocalDate localDate = LocalDate.parse(text);
			System.out.println(localDate); 
		} catch(DateTimeParseException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		 
	}
	
	//valid
	void method1() throws SQLException {
		try {

		} catch (Exception e) {
			throw e;
		}
	}
	
	void method2() throws SQLException {
		try {
			throw new Exception();
		} catch (Exception e) {
			//throw e; //Unhandled exception type Exception
		}
	}
	
	void method3() throws Exception {
		try {
			if (true)
			throw new SQLException();
			throw new IOException();
		} catch (SQLException | IOException e) {
			
		}
	}
	
	void method4a() throws Exception {
		try {
			method4b();
		} catch (SQLException | IOException e) {
			
		}
	}
	
	void method4b() throws Exception {
		try {
			if (false)
				throw new ParseException("s", 1);
			if (true)
			throw new SQLException();
			throw new IOException();
		} catch (SQLException | IOException | ParseException e) {
			
		}
	}
	
	void method5() {
		try {
			
		} catch (Exception1a | Exception1b e) {
			e.sampleMethod();
		}
	}
}

class Exception1 extends RuntimeException {
	void sampleMethod() {}
}
class Exception1a extends Exception1 {}
class Exception1b extends Exception1 {}

