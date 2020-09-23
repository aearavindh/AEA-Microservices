package com.batch23.Batch23Demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Value("${message:Hello World}")
	private String message;
	
	@GetMapping("/hello")
	public String sayHello() {
		return message;
	}

}
