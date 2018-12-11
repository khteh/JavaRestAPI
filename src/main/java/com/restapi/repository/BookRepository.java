package com.restapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.restapi.models.Book;
//This will be AUTO IMPLEMENTED by Spring into a Bean called bookRepository
//CRUD refers Create, Read, Update, Delete
//@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}