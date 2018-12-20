package com.restapi.controller;
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

import com.restapi.model.Book;
import com.restapi.model.Author;
import com.restapi.repository.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorRepository repository;
	
	@GetMapping
	public List<Author> getAllAuthors() {
		return repository.findAll();
	}
	@PostMapping
	public Author newAuthor(@RequestBody Author author) { return repository.save(author); }
	@PutMapping("/{id}")
	public Author updateAuthor(@RequestBody Author author, @PathVariable Long id) {
		return repository.findById(id).map(a -> {
			a.setFirstName(author.getFirstName());
			a.setLastName(author.getLastName());
			return repository.save(a);
		}).orElseGet(() -> {
			author.setId(id); 
			return repository.save(author);	
		});
	}
	@DeleteMapping("/{id}")
	public void deleteAuthor(@PathVariable Long id) { repository.deleteById(id);	}
}