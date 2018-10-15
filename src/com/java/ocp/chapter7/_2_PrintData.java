package com.java.ocp.chapter7;

public class _2_PrintData implements Runnable {
	public void run() {
		for (int i = 0; i < 3; i++)
			System.out.println("Printing record: " + i);
	}
	
	public static void main(String[] args) {
		(new Thread(new _2_PrintData())).start();
	}
}
