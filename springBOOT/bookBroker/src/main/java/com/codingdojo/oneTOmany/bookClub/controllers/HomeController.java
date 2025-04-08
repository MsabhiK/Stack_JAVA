package com.codingdojo.oneTOmany.bookClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.oneTOmany.bookClub.models.Book;
import com.codingdojo.oneTOmany.bookClub.models.LoginUser;
import com.codingdojo.oneTOmany.bookClub.models.User;
import com.codingdojo.oneTOmany.bookClub.services.BookService;
import com.codingdojo.oneTOmany.bookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
 
 // Add once service is implemented:
	@Autowired
	private UserService userServ;
	
	@Autowired
	private BookService bookServ;
 
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
	    	 return "redirect:/books";
	     }
	 }
	 
	 @GetMapping("/books")
	 public String home(Model model, HttpSession session) {
		 if(session.getAttribute("userId")== null) {
			 return"redirect:/";
		 }else {
			 model.addAttribute("books", bookServ.allBooks());
			 model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
			 return "books.jsp";
		    }
	 }
	 
	 @GetMapping("/addPage")
	 public String addPage(@ModelAttribute("book") Book book, Model model, HttpSession session) {
	    	
	    	User user = userServ.findById((Long)session.getAttribute("userId"));
	    	model.addAttribute("user", user);
	    	
	    	return "addBook.jsp";
	    }
	    
	    @PostMapping("/books/new")
	    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

	    	if (result.hasErrors()) {
	    		return "addBook.jsp";
	    	}
	    	
	    	bookServ.createBook(book);
	    	
	    	return "redirect:/books";
	    }
	    
	    @GetMapping("/books/{id}")
	    public String showPage(Model model, @PathVariable("id") Long id, HttpSession session) {
	    	if(session.getAttribute("userId") == null) {
	    		return "redirect:/";
	    	}
	    	Book book = bookServ.findBook(id);
	    	model.addAttribute("book", book);
	    	model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
	    	
	    	return "showbook.jsp";
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
	    
	        return "redirect:/books";
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
	 
	 @GetMapping("/books/{id}/remove")
		public String removeBook(@PathVariable("id") Long id, HttpSession session) {
		 	if(session.getAttribute("userId") == null) {
	    		return "redirect:/";
	    	}
	    	Book book = bookServ.findBook(id);
	    	bookServ.removeFromUser(book);
			return "redirect:/books";
		}
	 
	 @GetMapping("/books/{id}/edit")
	    public String editBook(Model model, @PathVariable("id") Long id, HttpSession session) {
	    	if(session.getAttribute("userId") == null) {
	    		return "redirect:/";
	    	}
	    	Book book = bookServ.findBook(id);
	    	model.addAttribute("book", book);
	    	model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
	    	
	    	return "editPage.jsp";
	    }
	    
	    @PutMapping("/books/{id}/edit")
	    public String updateBook(Model model, @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
	    	if(session.getAttribute("userId") == null) {
	    		return "redirect:/";
	    	}
	    	
	    	if(result.hasErrors()) {
	    		return "editPage.jsp";
	    	}
	    	
	    	bookServ.updateBook(book);
	    	
	    	return "redirect:/books";
	    }
	    
	    @GetMapping("/books/{id}/borrow")
	    public String borrowBook(@PathVariable("id") Long id, HttpSession session) {
	    	if(session.getAttribute("userId") == null) {
	    		return "redirect:/";
	    	}
	    	Book book = bookServ.findBook(id);
	    	book.setBorrower(userServ.findById((Long)session.getAttribute("userId")));
	    	bookServ.updateBook(book);
	    	
	    	return "redirect:/books";
	    }
	    
	    @GetMapping("/books/{id}/return")
	    public String returnBook(@PathVariable("id") Long id, HttpSession session) {
	    	if(session.getAttribute("userId") == null) {
	    		return "redirect:/";
	    	}
	    	Book book = bookServ.findBook(id);
	    	book.setBorrower(null);
	    	bookServ.updateBook(book);
	    	
	    	return "redirect:/books";
	    }
}

