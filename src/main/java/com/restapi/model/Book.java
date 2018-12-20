package com.restapi.model;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Data
public class Book {
	private @Id @GeneratedValue Long id;
	private int page_count;
	private String title;
	private String isbn;
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false, updatable = false)
	private Author author;
	public Book() {}
	public Book(String title, String isbn, int count, Author author) { this.title = title; this.isbn = isbn; page_count = count; this.author = author;}
	public Long getId() { return id; }
	public int getPageCount() { return page_count; }
	public String getTitle() { return title; }
	public String getIsbn() { return isbn; }
	public Author getAuthor() { return author; }
	public void setId(Long id) { this.id = id; }
	public void setPageCount(int count) { page_count = count; }
	public void setTitle(String name) { title = name; }
	public void setIsbn(String name) { isbn = name; }
	public void setAuthor(Author authoer) { this.author = author; }
	@Override
	public boolean equals(Object o) {
		return this == o || (o != null && getClass() == o.getClass() && id.equals(((Book)o).id));
	}
	@Override
	public int hashCode() { return id.hashCode(); }
	@Override
	public String toString() {
		return "Book { id = " + id + ", title = '" + title + "', isbn = '" + isbn + "', pageCount = " + page_count + ", author = " + author + "}";
	}
}