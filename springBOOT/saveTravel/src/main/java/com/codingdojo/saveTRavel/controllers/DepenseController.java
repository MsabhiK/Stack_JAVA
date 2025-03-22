package com.codingdojo.saveTRavel.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.saveTRavel.models.Depense;
import com.codingdojo.saveTRavel.services.DepenseService;

import jakarta.validation.Valid;

@Controller
public class DepenseController {
	@Autowired
	DepenseService depenseService;
	
	@GetMapping("/")
	public String index() {
		return"redirect:/expense";
	}
	
	@GetMapping("/expense")
	public String dashboard(@ModelAttribute("depense") Depense depense, Model model) {
		ArrayList<Depense> depenses = (ArrayList<Depense>) depenseService.allDepenses();
		model.addAttribute("depenses", depenses);
		return"index.jsp";
	}
	
	@PostMapping("/expense/new")
	public String createOne(@Valid @ModelAttribute("depense") Depense depense, BindingResult result, Model model) {
			if (result.hasErrors()) {
				ArrayList<Depense> depenses = (ArrayList<Depense>) depenseService.allDepenses();
				model.addAttribute("depenses", depenses);
				return"index.jsp";
	        } else {
	        		depenseService.createDepense(depense);
	        		return"redirect:/";
	        }
	}
	
	@GetMapping("/expense/{id}")
	public String findOne(Model model, @PathVariable(value="id") Long id) {
		System.out.println(id);
		
		Depense depense = depenseService.findDepense(id);
		System.out.println(depense);
		
		model.addAttribute("depense", depense);
		return"depenseById.jsp";
	}
	
	@GetMapping("/expense/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Depense depense = depenseService.findDepense(id);
		model.addAttribute("depense", depense);
		return"editDepense.jsp";
	}
	
	@PutMapping("/expense/{id}")
	public String update(@Valid @ModelAttribute("depense") Depense depense, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("depense", depense);
			return"editDepense.jsp";
		} else {
			depenseService.updateDepense(depense);
			return"redirect:/expense";
		}
	}
	
	@RequestMapping("/expense/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
		depenseService.deleteDepense(id);
        return "redirect:/expense";
    }

}
