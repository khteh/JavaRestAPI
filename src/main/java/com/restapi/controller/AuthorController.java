package com.restapi.controller;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.Book;
import com.restapi.exception.ResourceNotFoundException;
import com.restapi.model.Author;
import com.restapi.repository.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorController {
	private static final Log log = LogFactory.getLog(AuthorController.class);
	@Autowired
	private AuthorRepository repository;
	@Autowired
	private Environment env;
	@PostConstruct
	public void init()
	{
		log.info(env.getProperty("spring.datasource.url"));
	}
	@GetMapping
	public List<Author> getAllAuthors() {
		return repository.findAll();
	}
	@PostMapping
	public Author newAuthor(@RequestBody Author author) {
		log.info("/author/newAuthor: "+author.toString());
		return repository.save(author); 
	}
	@PutMapping("/{id}")
	public Author updateAuthor(@RequestBody final Author author, @PathVariable Long id) {
		log.info("/author/updateAuthor/"+id+": "+author.toString());
		return (Author) repository.findById(id).map(a -> {
			a.setFirstName(author.getFirstName());
			a.setLastName(author.getLastName());
			return repository.save(a);
		}).orElseGet(() -> {
			author.setId(id); 
			return repository.save(author);	
		});
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
		log.info("/author/deleteAuthor/"+id);		
		Author author = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("author", "id", id));
		repository.delete(author);
		return ResponseEntity.ok().build();
	}
}