package com.manin.in28minutes.mockito.mockitodemo.business;

public class SomeBusinessImpl {
	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		this.dataService = dataService;
	}

	public int findGreatestNumber() {
		int[] data= dataService.retrieveAllData();
		int greatestValue = 0;
		for(int number: data) {
			if(number> greatestValue) {
				greatestValue= number;
			}
		}
		return greatestValue;
	}
}

interface DataService{
	int[] retrieveAllData();
}