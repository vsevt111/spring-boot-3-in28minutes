package programming;

import java.util.List;

//traditional approach
public class FP01Structured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		//printAllNumberInListStructured(numbers);
		//printEvenNumberInListStructured(numbers);
		printOddNumberInListStructured(numbers);
	}

	private static void printAllNumberInListStructured(List<Integer> numbers) {
		// TODO Auto-generated method stub
		for(int number: numbers) {
			System.out.println(number);
		}
	}
	
	private static void printEvenNumberInListStructured(List<Integer> numbers) {
		// TODO Auto-generated method stub
		for(int number: numbers) {
			if(number%2==0)
			{System.out.println(number);}
		}
	}
	
	private static void printOddNumberInListStructured(List<Integer> numbers) {
		// TODO Auto-generated method stub
		for(int number: numbers) {
			if(number%2==1)
			{System.out.println(number);}
		}
	}

}
