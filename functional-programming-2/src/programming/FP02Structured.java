package programming;

import java.util.List;

//traditional approach
public class FP02Structured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> courses = List.of("Spring","Spring boot","API","Microservice",
				"AWS","PCF","Azure","Docker","Kubernetes");
		//printCourses(courses);
		//printSpringCourses(courses);
		//printGreaterFourCharactersCourses(courses);
		mapLenghtCharacterCourses(courses);
	}
	
	private static void printCourses(List<String> courses) {
		courses.stream().forEach(System.out::println);
	}
	
	private static void printSpringCourses(List<String> courses) {
		courses.stream()
		.filter(course->course.contains("Spring"))
		.forEach(System.out::println);
	}
	
	private static void printGreaterFourCharactersCourses(List<String> courses) {
		courses.stream()
		.filter(course->course.length()>=4)
		.forEach(System.out::println);
	}
	
	private static void mapLenghtCharacterCourses(List<String> courses) {
		courses.stream()
		.map(course->course.length())
		.forEach(System.out::println);
	}

	

}
