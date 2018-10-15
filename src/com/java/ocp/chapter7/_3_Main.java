package com.java.ocp.chapter7;

public class _3_Main {
	//answer is unknown til runtime. 3 threads created. 
	public static void main(String[] args) {
		System.out.println("begin");
		new _2_ReadInventoryThread(). start();
		(new Thread(new _2_PrintData())).start();
		new _2_ReadInventoryThread(). start();
		System.out.println("end");
	}
}
