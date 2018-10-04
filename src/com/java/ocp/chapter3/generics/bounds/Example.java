package com.java.ocp.chapter3.generics.bounds;

import java.util.List;

class ClassOne {
public class Example {
	?field1; // invalid
	List<?> field2; // valid
	ClassOne<?> field3; //invalid
	
	private ? method1(? param) {return param;} // invalid

	private List<?> method2(List<?> param) {
		return param;
	} // valid

	private void method3() {
        ? var1;        // invalid
        List<?> var2;  // valid
        
        Map
    }
}