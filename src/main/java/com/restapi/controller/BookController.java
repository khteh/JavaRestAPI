package com.restapi.controllers;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.restapi.models.Book;
import com.restapi.repositories.BookRepository;
@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@GetMapping("")
	public Iterable<Book> getAllBooks() {
		return repository.findAll();
	}
	@GetMapping("/{title}")
	public Book getBookByTitle(@PathVariable("title") String title) {
		Iterator<Book> it = repository.findAll().iterator();
		while (it.hasNext()) {
			Book book = it.next();
			if (book.getTitle().equals(title))
				return book;
		}
		return null;
	}
	@GetMapping("/{isbn}")
	public Book getBookByIsbn(@PathVariable("isbn") String isbn) {
		Iterator<Book> it = repository.findAll().iterator();
		while (it.hasNext()) {
			Book book = it.next();
			if (book.getIsbn().equals(isbn))
				return book;
		}
		return null;
	}
	@GetMapping("/{authorID}")
	public List<Book> getAllBookByAuthorID(@PathVariable("authorID") Long authorID) {
		return StreamSupport.stream(repository.findAll().spliterator(),  false)
						.filter(i -> i.getAuthor().getId().equals(authorID)).collect(Collectors.toList());
	}
	@GetMapping("/{authorFirstName}")
	public List<Book> getAllBookByAuthorFirstName(@PathVariable("authorFirstName") String authorFirstName) {
		return StreamSupport.stream(repository.findAll().spliterator(),  false)
						.filter(i -> i.getAuthor().getFirstName().equals(authorFirstName)).collect(Collectors.toList());
	}
	@GetMapping("/{authorLastName}")
	public List<Book> getAllBookByAuthorLastName(@PathVariable("authorLastName") String authorLastName) {
		return StreamSupport.stream(repository.findAll().spliterator(),  false)
						.filter(i -> i.getAuthor().getFirstName().equals(authorLastName)).collect(Collectors.toList());
	}
}