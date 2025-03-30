package com.codingdojo.oneTOmany.studentRoster1_n.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.oneTOmany.studentRoster1_n.models.Dorm;
import com.codingdojo.oneTOmany.studentRoster1_n.models.Student;
import com.codingdojo.oneTOmany.studentRoster1_n.services.DormService;
import com.codingdojo.oneTOmany.studentRoster1_n.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private DormService dormService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "dorms.jsp";
	}
	
	@GetMapping("/dorms/new")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "newDorm.jsp";
	}
	
	@PostMapping("/dorms/new")
	public String addDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if (result.hasErrors()) {
			return"newDorm.jsp";
		}else {
		dormService.addDorm(dorm);
		return "redirect:/";
		}
	}
	
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "newStudent.jsp";
	}
	
	@PostMapping("/students/new")
	public String addStudent(@ModelAttribute("student") Student student) {
		studentService.addStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/dorms/{id}")
	public String viewDorms(@PathVariable("id") Long id, Model model) {
		model.addAttribute("studentss", studentService.allStudents());
		model.addAttribute("dorm", dormService.findDorm(id));
		model.addAttribute("students", studentService.dormStudents(id));
		return "viewDorm.jsp";
	}
	
	@GetMapping("/students/remove/{id}")
	public String removeStudent(@PathVariable("id") Long id) {
		studentService.removeFromDorm(studentService.findStudent(id));
		return "redirect:/";
	}
}