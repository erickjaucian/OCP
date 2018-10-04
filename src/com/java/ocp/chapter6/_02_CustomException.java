package com.java.ocp.chapter6;

//Custom Exception
public class _02_CustomException extends Exception {
	
	public _02_CustomException() {
		super();
	}
	
	public _02_CustomException(Exception e) {
		super(e);
	}
	
	public _02_CustomException(String message) {
		super(message);
	}
	
	public static void main(String[] args) throws _02_CustomException {
		throw new _02_CustomException(new RuntimeException());
	}
}
