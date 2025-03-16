package com.codingdojo.bookcrud.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.bookcrud.models.Book;
import com.codingdojo.bookcrud.services.BookService;

@Controller
public class BookController {
	 
	@Autowired
	BookService bookservice;
	
	@GetMapping("/")
	public String home(Model model) {
		return "redirect:/book";
	}
	
	
	@GetMapping("/book")
	public String index(Model model) {
		ArrayList<Book> books = (ArrayList<Book>) bookservice.allBooks();
		model.addAttribute("books", books);
		
		return"index.jsp";
	}
	
	@GetMapping("/book/{id}")
	public String index(Model model, @PathVariable(value="id") Long id) {
		System.out.println(id);
		
		Book book = bookservice.findBook(id);
		System.out.println(book);
		
		model.addAttribute("book", book);
		return"showById.jsp";
	}

}
