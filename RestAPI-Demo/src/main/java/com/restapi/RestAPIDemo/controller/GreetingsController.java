package com.restapi.RestAPIDemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
	@Value("${my.message}")	
	private String message;
	
	@GetMapping("/greetings")
	public String greetings() {
		
		return message;
		
	}

}
