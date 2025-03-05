package com.codingdojo.spring_hopper_receipt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController_hooper {

	@RequestMapping("/")
	public String index(Model model) {
		String name = "Carbon";
        String itemName = "Pipeline for Gas";
        double price = 50.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";
        
        model.addAttribute("first", name);
        model.addAttribute("item", itemName);
        model.addAttribute("price", price);
        model.addAttribute("dicte", description);
        model.addAttribute("vendor", vendor);
        return"index.jsp";
        
	}

}
