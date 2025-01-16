package com.codingdojo.springApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class FruitController {
	@RequestMapping("/menu")
	public String index(Model model) {
		String firstName= "Karim";
		String lastName= "Msabhi";
		Integer myage = 42;
		model.addAttribute("fruit", "KIWI");
		model.addAttribute("first", firstName);
		model.addAttribute("last", lastName);
		model.addAttribute("age", myage);
		return "index.jsp";
	}
	
	@RequestMapping("/session")
	public String session(HttpSession session) {
		session.setAttribute("country", "Netherland");
		return "country.jsp";
	}
	
	@RequestMapping("/session/country")
	public String country(HttpSession session) {
		String your_country = (String) session.getAttribute("country");
		System.out.println("I like traveling to the: " + your_country);
		return"travel.jsp";
	}
	
	@RequestMapping("/")
	public String count(HttpSession session, HttpSession s) {
		Integer count = 0;
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			count = (Integer) session.getAttribute("count");
			count ++;
			session.setAttribute("count", count);
		}
		
		Integer count2 = 0;
		if(s.getAttribute("count2") == null) {
			s.setAttribute("count2", 0);
		}
		else {
			count2 = (Integer) s.getAttribute("count2");
			count2 += 2;
			s.setAttribute("count2", count2);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter() {
		return "count.jsp";
	}
	
	@RequestMapping("/counter2")
	public String counter2() {
		return "count2.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return"count.jsp";
	}
	
	@RequestMapping("/reset2")
	public String reset2(HttpSession session) {
		session.setAttribute("count2", 0);
		return"count2.jsp";
	}

}
