package programming;

import java.util.List;

//traditional approach
public class FP01Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		//printAllNumberInListFunctional(numbers);
		//printSquaresOfEvenNumbers(numbers);
		printCubesOfOddNumbers(numbers);
	}
	
	private static void print(int number) {
		System.out.println(number);
	}
	
	private static boolean isEven(int number) {
		return number%2==0;
	}

	private static void printAllNumberInListFunctional(List<Integer> numbers) {
		// TODO Auto-generated method stub
//		for(int number: numbers) {
//			System.out.println(number);
//		}
		
		numbers.stream()
//		.filter(FP01Functional::isEven)
//		.filter(number-> number%2==0)
		.filter(number->number%2==1)
//		.forEach(FP01Functional::print) 
		//method references because don't want to call function
		.forEach(System.out::println);
		;
	}
	
	private static void printSquaresOfEvenNumbers(List<Integer> numbers){
		numbers.stream()
		.filter(number->number%2==0)
		.map(number->number*number)
		.forEach(System.out::println);
	}
	
	private static void printCubesOfOddNumbers(List<Integer> numbers){
		numbers.stream()
		.filter(number->number%2==1)
		.map(number->number*number*number)
		.forEach(System.out::println);
	}
	
}
