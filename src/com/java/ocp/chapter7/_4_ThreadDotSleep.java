package com.java.ocp.chapter7;  

public class _4_ThreadDotSleep {
	private static int counter = 0;
	public static void main(String[] args) throws InterruptedException {
		new Thread(() ->  {
			for (int i = 0; i < 500; i++) _4_ThreadDotSleep.counter++;
		}).start();
		
		while(_4_ThreadDotSleep.counter++ < 100) {
			System.out.println("Not reached yet");
			Thread.sleep(1000);
		}
		
		System.out.println("Reached!!");
	}
}
