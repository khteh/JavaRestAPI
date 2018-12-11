package com.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.models.Book;
import com.restapi.repositories.BookRepository;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private BookRepository repository;
	
	@GetMapping("")
	public Iterable<Book> getAllAuthors() {
		return repository.findAll();
	}
}