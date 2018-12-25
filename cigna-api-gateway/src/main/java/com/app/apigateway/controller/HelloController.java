package com.app.apigateway.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {


	@ApiOperation(value = "Hello Controller")
	@GetMapping
	public String helloWorld()
	{
		return "Hi This Is Authentication API's";
	}
}
