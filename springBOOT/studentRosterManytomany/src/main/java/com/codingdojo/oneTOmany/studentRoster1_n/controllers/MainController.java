package com.codingdojo.oneTOmany.studentRoster1_n.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.oneTOmany.studentRoster1_n.models.Course;
import com.codingdojo.oneTOmany.studentRoster1_n.models.Dorm;
import com.codingdojo.oneTOmany.studentRoster1_n.models.Student;
import com.codingdojo.oneTOmany.studentRoster1_n.services.CourseService;
import com.codingdojo.oneTOmany.studentRoster1_n.services.DormService;
import com.codingdojo.oneTOmany.studentRoster1_n.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private DormService dormService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		model.addAttribute("students", studentService.allStudents());
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
	public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return"newStudent.jsp";
		}else {
		studentService.addStudent(student);
		return "redirect:/";
		}
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
	
	@RequestMapping("/students/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
        return "redirect:/";
    }
	
	@GetMapping("/classes")
	public String viewCourses(Model model) {
		model.addAttribute("courses", courseService.allCourses());
		return"viewClasses.jsp";
	}
	
	@GetMapping("/classes/new")
	public String newCourse(@ModelAttribute("course") Course course) {
		return"newClass.jsp";
	}
	
	@PostMapping("/classes/new")
	public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if (result.hasErrors()) {
			return"newClass.jsp";
		}else {
		courseService.addCourse(course);
		return "redirect:/classes";
		}
	}
	
	@GetMapping("/classes/{id}")
	public String oneClass(@PathVariable("id") Long id, Model model) {
		model.addAttribute("course", courseService.findCourse(id));
		return"oneCourse.jsp";
	}
	
	@GetMapping("/students/{studentId}")
	public String viewStudent(@PathVariable("studentId") Long studentId, Model model) {
		Student student = studentService.findStudent(studentId);
		model.addAttribute("student", student);
		model.addAttribute("availableCourses", courseService.getNotAssignedCourse(student));
		model.addAttribute("assignedCourses", courseService.getAssignedCourses(student));
		return "viewStudentClass.jsp";
	}
	
	@PostMapping("/students/{studentId}/addcourseTOstudent")
	public String assignCourse(@PathVariable("studentId") Long studentId, @RequestParam("courseId") Long courseId) {
		Student student = studentService.findStudent(studentId);
		Course course = courseService.findCourse(courseId);
		course.getStudents().add(student);
		courseService.updateCourse(course);
		return "redirect:/students/"+studentId;
	}
	
	@GetMapping("/students/{studentId}/classes/{courseId}/drop")
	public String dropCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
		Student student = studentService.findStudent(studentId);
		Course course = courseService.findCourse(courseId);
		courseService.dropCourse(course, student);
		return "redirect:/students/"+studentId;
	}
	
}