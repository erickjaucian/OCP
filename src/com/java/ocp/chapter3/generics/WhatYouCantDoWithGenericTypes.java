package com.java.ocp.chapter3.generics;

import java.util.ArrayList;
import java.util.List;

public class WhatYouCantDoWithGenericTypes<T> {
	public static T variable;
	public void main(String[] args) {
		new T();
		T[] array = new T[1];
		List<String> list = new ArrayList<String>();
		if (list instanceof T) {
			
		}
	}
}
