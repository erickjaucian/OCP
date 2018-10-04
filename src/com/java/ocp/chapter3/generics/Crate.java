package com.java.ocp.chapter3.generics;

public class Crate<T> {
	private T contents;

	public T emptyCrate() {
		return contents;
	}

	public void packCrate(T contents) {
		this.contents = contents;
	}
	
	public static void main(String[] args) {
		Robot joeBot = new Robot();
		Crate<Robot> robotCrate = new Crate<>();
		robotCrate.packCrate(joeBot);
		// ship to St. Louis
		Robot atDestination = robotCrate.emptyCrate();
	}
}