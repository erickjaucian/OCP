package com.java.ocp.chapter4;

public class LambdaIntroDemo {
	public static void main(String[] args) {
		
	}
}

interface Gorilla {
	String move();
}

class GorillaFamily {
	String walk = "walk";
	static String run = "run";
	void everyOnePlay(boolean baby) {
		String approach = "amble";
		//approach = "run";
		walk = "walk fast";
		run = "run fast";
		//baby = false;
		play(() -> walk);
		play(() -> approach);
		play(() -> baby ? "hitch a ride" : run);
	}
	
	void play(Gorilla g) {
		System.out.println(g.move());
	}
}
