package com.manin.in28minutes.rest.webservice.socialrestwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController {
	
	@GetMapping("v1/person")
	public PersonV1 getPersonVersionOne() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("v2/person")
	public PersonV2 getPersonVersionTwo() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	@GetMapping(path="person" ,params="version=1")
	public PersonV1 getPersonVersionOneRequestParam() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="person",params="version=2")
	public PersonV2 getPersonVersionTwoRequestParam() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	@GetMapping(path="person" ,headers="X-API-VERSION=1")
	public PersonV1 getPersonVersionOneHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="person",headers="X-API-VERSION=2")
	public PersonV2 getPersonVersionTwoHeader() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	@GetMapping(path="person" ,produces="application/vnd.company.app-v1+json")
	public PersonV1 getPersonVersionOneAcceptHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="person",produces="application/vnd.company.app-v2+json")
	public PersonV2 getPersonVersionTwoAcceptHeader() {
		return new PersonV2(new Name("Bob","Charlie"));
	}

}
