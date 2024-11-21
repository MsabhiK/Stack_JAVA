package com.codingdojo.helloworld.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHuman {

	@RequestMapping("/")
	public String query(@RequestParam(value="name", required=false) String searchName, 
			@RequestParam(value="lastname", required=false) String searchLast,
			@RequestParam(value="times", required=false) Integer times) {
		
		if(times != null && times > 0) {
			String result = "";
			for(int i = 0; i < times; i++) {
				if(searchName != null && searchLast != null) {
					result += "Hello " + searchName + " " + searchLast + " ";
				}else if(searchName != null) {
					result += "Hello " + searchName + " ";
				}else if(searchLast != null) {
					result += "Hello " + searchLast + " ";
				}else {
					result += "Hello Human ";
				}
			}
			return result;
		}
		
		if(searchName != null && searchLast != null) {
			return"Hello: " + searchName + " " + searchLast;
		}
		else if(searchName != null){
			return"Hello: " + searchName;
		}
		else if(searchLast != null){
			return"Hello: " + searchLast;
		}
		return "HELLO Human!!";
		
}
	
}
