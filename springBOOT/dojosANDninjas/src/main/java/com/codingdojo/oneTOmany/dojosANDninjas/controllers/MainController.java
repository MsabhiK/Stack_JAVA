package com.codingdojo.oneTOmany.dojosANDninjas.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.oneTOmany.dojosANDninjas.models.Dojo;
import com.codingdojo.oneTOmany.dojosANDninjas.models.Ninja;
import com.codingdojo.oneTOmany.dojosANDninjas.services.DojoService;
import com.codingdojo.oneTOmany.dojosANDninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String index() {
		return"redirect:/dojos/new";
	}
	
	@GetMapping("/dojos/new")
	public String dashboard(@ModelAttribute("dojo") Dojo dojo, Model model) {
		ArrayList<Dojo> dojos = (ArrayList<Dojo>) dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return"index.jsp";
	}
	
	@PostMapping("/dojos/add")
	public String createOne(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
			if (result.hasErrors()) {
				ArrayList<Dojo> dojos = (ArrayList<Dojo>) dojoService.allDojos();
				model.addAttribute("dojos", dojos);
				return"index.jsp";
	        } else {
	        		dojoService.createDojo(dojo);
	        		return"redirect:/";
	        }
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Integer id, Model model) {
		System.out.printf("dojo id from url: %s",id);
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		
		return "showNinjasOfDojo.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "addNinja.jsp";
	}
	
	@PostMapping("/ninjas/add")
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return"addNinja.jsp";
		} else {
		ninja = ninjaService.createNinja(ninja);
		return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}

}
