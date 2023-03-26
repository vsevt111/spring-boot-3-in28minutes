package com.manin.in28minutes.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//use this annotation because @Mock
//ถ้าไม่ใช่จะเป็น nullpointerexception
@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {
	
	@Mock
	DataService dataMock;
	
	@InjectMocks
	SomeBusinessImpl businessImpl;

//	@Test
//	void findTheGreatest_NormalScenario() {
//		DataService dataMock= mock(DataService.class);
//		when(dataMock.retrieveAllData()).thenReturn(new int[] {25,15,1});
//		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataMock);
//		assertEquals(25, businessImpl.findGreatestNumber());
//	}
	
	@Test
	void findTheGreatest_NormalScenario() {
		when(dataMock.retrieveAllData()).thenReturn(new int[] {25,15,1});
		assertEquals(25, businessImpl.findGreatestNumber());
	}
	
	@Test
	void findTheGreatest_OneEleScenario() {
		when(dataMock.retrieveAllData()).thenReturn(new int[] {35});
		assertEquals(35, businessImpl.findGreatestNumber());
	}


}

