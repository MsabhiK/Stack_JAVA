package com.codingdojo.burgerTracker1.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.burgerTracker1.models.Burger;
import com.codingdojo.burgerTracker1.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	
	@Autowired
	BurgerService burgerservice;

	@GetMapping("/")
	public String index(@ModelAttribute("burger") Burger burger, Model model) {
		ArrayList<Burger> burgers = (ArrayList<Burger>) burgerservice.allBurgers();
		model.addAttribute("burgers", burgers);
		return"index.jsp";
	}
	
	//4/ To create a new book
	@PostMapping("/burger/new")
	public String createOne(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
			if (result.hasErrors()) {
				ArrayList<Burger> burgers = (ArrayList<Burger>) burgerservice.allBurgers();
				model.addAttribute("burgers", burgers);
				return"index.jsp";
	        } else {
			burgerservice.createBurger(burger);
			return"redirect:/";
	        }
	}
	
	@GetMapping("/burger/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerservice.findBurger(id);
		model.addAttribute("burger", burger);
		return"editBurger.jsp";
	}
	
	@PutMapping("/burger/{id}")
	public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("burger", burger);
			return"editBurger.jsp";
		} else {
			burgerservice.updateBurger(burger);
			return"redirect:/";
		}
	}
}
