package com.codingdojo.counterassign.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CountController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("count", -1);
		session.setAttribute("count2", -2);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		Integer count=0;
		if(session.getAttribute("count")==null) {
			session.setAttribute("count", 0);
		}
		else {
			count = (Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}
		return"count.jsp";
	}
	
	@RequestMapping("/counter2")
	public String counter2(HttpSession session) {
		Integer count2=0;
		if(session.getAttribute("count2")==null) {
			session.setAttribute("count2", 0);
		}
		else {
			count2 = (Integer) session.getAttribute("count2");
			count2+=2;
			session.setAttribute("count2", count2);
		}
		return"count2.jsp";
	}

}
