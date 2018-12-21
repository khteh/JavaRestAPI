package com.restapi.model;
import lombok.Data;
import com.restapi.model.Author;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Data
@Table(name="book")
public class Book {
	private @Id @GeneratedValue Long id;
	@Column(name="page_count")
	private int page_count;
	@Column(name="title")
	private String title;
	@Column(name="isbn")
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
	public void setAuthor(Author author) { this.author = author; }
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