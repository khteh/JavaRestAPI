package com.restapi.models;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.restapi.models.Author;
@Entity
@Data
public class Author {
	private @Id @GeneratedValue Long id;
	private String firstName;
	private String lastName;
	public Author() {}
	public Author(Long id) { this.id = id; }
	public Author(String first, String last) { firstName = first; lastName = last; }
	public Long getId() { return id; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public void setId(Long id) { this.id = id; }
	public void setFirstName(String name) { firstName = name; }
	public void setLastName(String name) { lastName = name; }
	@Override
	public boolean equals(Object o) {
		return this == o || (o != null && getClass() == o.getClass() && id.equals(((Author)o).id));
	}
	@Override
	public int hashCode() { return id.hashCode(); }
	@Override
	public String toString() {
		return "Author { id = " + id + ", firstName = '" + firstName + "', lastName = '" + lastName + "'}";
	}
}