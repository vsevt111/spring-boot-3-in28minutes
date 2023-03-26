package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	private MyMath myMath = new MyMath();
	
	@Test
	void calculateSum_ThreeMembers() {
		assertEquals(6, myMath.calculateSum(new int[] {1,2,3}));
	}
	
	@Test
	void calculateSum_ZeroMembers() {
		assertEquals(0, myMath.calculateSum(new int[] {}));
	}
	

}
