package com.java.ocp.chapter7;

public class _4_Polling {
	private static int counter = 0;
	public static void main(String[] args) {
		new Thread(() ->  {
			for (int i = 0; i < 500; i++) _4_Polling.counter++;
		}).start();
		
		while(_4_Polling.counter++ < 100)
			System.out.println("Not reached yet");
		
		System.out.println("Reached!!");
	}
}
