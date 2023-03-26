package com.manin.in28minutes.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

	@Test
	void findTheGreatest_NormalScenario() {
		DataService dataStub1 = new DataServiceStub1();
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataStub1);
		int result = businessImpl.findGreatestNumber();
		assertEquals(25, result);
	}

}

//using stub is hard to maintain
//เมื่อไหร่ก็ตามที่มีการเพิ่ม method หรือ เปลี่ยน test case จะต้องสร้าง class ใหม่ตลอด
class DataServiceStub1 implements DataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {25,15,5};
	}
	
}

class DataServiceStub2 implements DataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {35};
	}
	
}
