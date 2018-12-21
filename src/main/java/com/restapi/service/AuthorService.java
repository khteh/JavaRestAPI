package com.restapi.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AuthorService {
	@PersistenceContext
	private EntityManager entityManager;
	//public long insert(Author author)
}