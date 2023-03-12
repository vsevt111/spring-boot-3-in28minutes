package com.manin.in28minutes.rest.webservice.socialrestwebservice.versioning;

public class PersonV2 {
	
	public PersonV2(Name name) {
		this.name = name;
	}

	private Name name;

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}

	public Name getName() {
		return name;
	}

}
