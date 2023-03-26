package com.in28minutes.junit;

public class MyMath {
	public int calculateSum(int[] sum) {
		int result =0;
		for(int ele : sum) {
			result+=ele;
		}
		return result;
	}
}
