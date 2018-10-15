package com.java.ocp.chapter7;

public class _2_ReadInventoryThread extends Thread {
	public void run() {
		System.out.println("print zoo inventory");
	}
	
	public static void main(String[] args) {
		(new _2_ReadInventoryThread()).start();
	}
}
