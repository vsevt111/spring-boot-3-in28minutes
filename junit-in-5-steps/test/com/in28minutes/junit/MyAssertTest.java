package com.in28minutes.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {

	@Test
	void test() {
		List<String> todos = Arrays.asList("AWS","DANCE","DevOps");
		boolean test = todos.contains("AWS");
		boolean test1 = todos.contains("GCP");
		
		assertTrue("True",test);
		assertFalse(test1);
		assertEquals(3, todos.size(),"not same size");
		assertArrayEquals("Not same array",new int[] {1,2}, new int[] {2,1});
	}

}
