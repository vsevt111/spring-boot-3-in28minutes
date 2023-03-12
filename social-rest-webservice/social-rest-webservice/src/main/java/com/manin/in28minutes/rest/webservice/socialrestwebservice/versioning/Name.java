package com.manin.in28minutes.rest.webservice.socialrestwebservice.versioning;

public class Name {
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}	
