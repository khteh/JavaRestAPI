package com.restapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.restapi.model.Author;
//This will be AUTO IMPLEMENTED by Spring into a Bean called bookRepository
//CRUD refers Create, Read, Update, Delete
public interface AuthorRepository extends JpaRepository<Author, Long> {
}