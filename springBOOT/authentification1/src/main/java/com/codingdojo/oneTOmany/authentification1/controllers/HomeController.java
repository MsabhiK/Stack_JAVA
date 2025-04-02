package com.codingdojo.oneTOmany.authentification1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.oneTOmany.authentification1.models.LoginUser;
import com.codingdojo.oneTOmany.authentification1.models.User;
import com.codingdojo.oneTOmany.authentification1.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
 
 // Add once service is implemented:
	@Autowired
	private UserService userServ;
 
	 @GetMapping("/")
	 public String index(Model model) {
	 
	     // Bind empty User and LoginUser objects to the JSP
	     // to capture the form input
	     model.addAttribute("newUser", new User());
	     model.addAttribute("newLogin", new LoginUser());
	     return "index.jsp";
	 }
	 
	 @PostMapping("/register")
	 public String register(@Valid @ModelAttribute("newUser") User newUser, 
	         BindingResult result, Model model, HttpSession session) {
	     
	     // TO-DO Later -- call a register method in the service 
	     // to do some extra validations and create a new user!
		 User user = userServ.register(newUser, result);
	     
	     if(result.hasErrors()) {
	         // Be sure to send in the empty LoginUser before 
	         // re-rendering the page.
	         model.addAttribute("newLogin", new LoginUser());
	         return "index.jsp";
	     }else {
	     // No errors! 
	     // TO-DO Later: Store their ID from the DB in session, 
	     // in other words, log them in.
	    	 session.setAttribute("userId", user.getId());
	    	 return "redirect:/home";
	     }
	 }
	 
	 @GetMapping("/home")
	 public String home(Model model, HttpSession session) {
		 if(session.getAttribute("userId")== null) {
			 return"redirect:/";
		 }else {
			 model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
			 return "home.jsp";
		    }
		 
	 }
	 
	 
	 @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        // Add once service is implemented:
	        User user = userServ.login(newLogin, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "index.jsp";
	        }
	    
	        // No errors! 
	        // Store their ID from the DB in session, 
	        // in other words, log them in.
	        session.setAttribute("userId", user.getId());
	    
	        return "redirect:/home";
	    }
	 
	 @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.invalidate();
	    	return "redirect:/";
	    }
	/* 
	 @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.setAttribute("userId", null);
	    	return "redirect:/";
	    }
	 */
}

