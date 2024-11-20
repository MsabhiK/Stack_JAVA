package com.codingdojo.helloworld.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class MainController {

	@RequestMapping("")
	public String control_1() {
		return"Hello user";
	}
	@RequestMapping("/hello")
	public String control_2() {
		return"Hello World!!! you are an user";
	}
	@RequestMapping("/goodby")
	public String control_3() {
		return"GoodBy user";
	}

}
