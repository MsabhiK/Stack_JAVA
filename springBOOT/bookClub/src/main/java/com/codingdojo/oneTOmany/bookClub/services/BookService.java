package com.codingdojo.oneTOmany.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.oneTOmany.bookClub.models.Book;
import com.codingdojo.oneTOmany.bookClub.repositories.BookRepository;


@Service
public class BookService {
	 
	@Autowired
	 private BookRepository bookRepository;
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    //list all of books by one user
    public List<Book> userBooks(Long userId) {
		return bookRepository.findByUserIdIs(userId);
	}
    
    public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void removeFromUser(Book book) {
		bookRepository.delete(book);
	}
}
