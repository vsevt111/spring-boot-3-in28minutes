package com.manin.in28minutes.springboot.todowebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private AuthenticationService authenticationService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoginName());
		return "welcome";
	}
	
	private String getLoginName() {
		Authentication authen= SecurityContextHolder.getContext().getAuthentication();
		return authen.getName();
	}
	
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

//	@RequestMapping(value="login",method=RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		
//		if (authenticationService.authenticate(name, password)) {
//			model.put("name", name);
//			return "welcome";
//		}
//		
//		model.put("errorMessage", "Invalid credential! Please try again.");
//		return "login";
//	}
	
	
}
