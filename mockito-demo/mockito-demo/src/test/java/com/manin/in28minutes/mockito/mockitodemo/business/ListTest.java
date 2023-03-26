package com.manin.in28minutes.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {

	@Test
	void singleTest() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(3);
		assertEquals(3, listMock.size());
	}
	
	@Test
	void oneParameters() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("SomeString");
		assertEquals("SomeString", listMock.get(0));
		//be default mockito return null if you don't define thenReturn to specific element
		assertEquals(null,listMock.get(1));
	}
	
	@Test
	void multipleParameters() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn(2).thenReturn(5);
		assertEquals(2, listMock.get(0));
		assertEquals(5,listMock.get(0));
		assertEquals(5,listMock.get(0));
		assertEquals(5,listMock.get(0));
	}
	
	@Test
	void genericParameters() {
		List listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenReturn("SomeOtherString");
		assertEquals("SomeOtherString", listMock.get(0));
		assertEquals("SomeOtherString",listMock.get(1));
	}

}
