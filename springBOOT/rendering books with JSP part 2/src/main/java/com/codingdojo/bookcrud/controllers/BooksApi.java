package com.codingdojo.bookcrud.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.bookcrud.models.Book;
import com.codingdojo.bookcrud.services.BookService;

@RestController
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    @PostMapping(value="/api/books")
    public Book create(
    					@RequestParam(value="title") String title, 
    					@RequestParam(value="nbreofpages") Integer nbreofpages, 
    					@RequestParam(value="description") String description, 
    					@RequestParam(value="language") String language) {
        	Book book = new Book(title, nbreofpages, description, language);
        	return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    
 // Update
    @PutMapping(value="/api/books/{id}")
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="nbreofpages") Integer nbreofpages, 
    		@RequestParam(value="description") String description,
    		@RequestParam(value="language") String language) 
    {
        
    	Book book = new Book(title, nbreofpages, description, language);
        book.setId(id);
        return bookService.updateBook(book);
    }
    // DELETE
    @DeleteMapping(value="/api/books/{id}")
    public void destroy(@PathVariable("id") Long idbook) {
        bookService.deleteBook(idbook);
    }
}
