package com.java.ocp.chapter5.section1_dates_times;

import java.util.Properties;

public class Class {
	public static void main(String[] args) { 
		
	}
	private static void print(Properties props) {
		System.out.println(props.getProperty("veggies", "none") + " " + props.getProperty("omni", "none"));
	}
}
