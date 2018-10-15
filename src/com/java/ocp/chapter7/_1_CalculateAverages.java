package com.java.ocp.chapter7;

public class _1_CalculateAverages implements Runnable {
	private double[] scores;
	
	public _1_CalculateAverages(double[] scores) {
		this.scores = scores;
	}
	
	public static void main(String[] args) {
		(new Thread(new _1_CalculateAverages(new double[] {1,2}))).start();
	}
	
	@Override
	public void run() {
		System.out.println(scores.length);
		
	}

}
