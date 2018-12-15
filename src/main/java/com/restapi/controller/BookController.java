package com.restapi.controllers;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.restapi.models.Book;
import com.restapi.repositories.BookRepository;
@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@GetMapping
	public Iterable<Book> getAllBooks() {
		return repository.findAll();
	}
	@GetMapping("/{title}")
	public Book getBookByTitle(@PathVariable String title) {
		Iterator<Book> it = repository.findAll().iterator();
		while (it.hasNext()) {
			Book book = it.next();
			if (book.getTitle().equals(title))
				return book;
		}
		return null;
	}
	@GetMapping("/{isbn}")
	public Book getBookByIsbn(@PathVariable String isbn) {
		Iterator<Book> it = repository.findAll().iterator();
		while (it.hasNext()) {
			Book book = it.next();
			if (book.getIsbn().equals(isbn))
				return book;
		}
		return null;
	}
	@GetMapping("/{authorID}")
	public List<Book> getAllBookByAuthorID(@PathVariable Long authorID) {
		return StreamSupport.stream(repository.findAll().spliterator(),  false)
						.filter(i -> i.getAuthor().getId().equals(authorID)).collect(Collectors.toList());
	}
	@GetMapping("/{authorFirstName}")
	public List<Book> getAllBookByAuthorFirstName(@PathVariable String authorFirstName) {
		return StreamSupport.stream(repository.findAll().spliterator(),  false)
						.filter(i -> i.getAuthor().getFirstName().equals(authorFirstName)).collect(Collectors.toList());
	}
	@GetMapping("/{authorLastName}")
	public List<Book> getAllBookByAuthorLastName(@PathVariable String authorLastName) {
		return StreamSupport.stream(repository.findAll().spliterator(),  false)
						.filter(i -> i.getAuthor().getFirstName().equals(authorLastName)).collect(Collectors.toList());
	}
	@PostMapping
	public Book newBook(@RequestBody Book book) { return repository.save(book); }
	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
		return repository.findById(id).map(b -> {
			b.setPageCount(book.getPageCount());
			b.setTitle(book.getTitle());
			b.setIsbn(book.getIsbn());
			return repository.save(b);
		}).orElseGet(() -> {
			book.setId(id);
			return repository.save(book);
		});
	}
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) { repository.deleteById(id); } 
}