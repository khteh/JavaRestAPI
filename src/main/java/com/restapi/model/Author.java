package com.restapi.model;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.restapi.model.Author;
@Entity
@Data
@Table(name="author")
public class Author {
	private @Id @GeneratedValue Long id;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	public Author() {}
	public Author(Long id) { this.id = id; }
	public Author(String first, String last) { first_name = first; last_name = last; }
	public Long getId() { return id; }
	public String getFirstName() { return first_name; }
	public String getLastName() { return last_name; }
	public String getEmail() { return email; }
	public String getPhone() { return phone; }
	public void setId(Long id) { this.id = id; }
	public void setFirstName(String name) { first_name = name; }
	public void setLastName(String name) { last_name = name; }
	public void setEmail(String email) { this.email = email; }
	public void setPhone(String phone) { this.phone = phone; }
	@Override
	public boolean equals(Object o) {
		return this == o || (o != null && getClass() == o.getClass() && id.equals(((Author)o).id));
	}
	@Override
	public int hashCode() { return id.hashCode(); }
	@Override
	public String toString() {
		return "Author { id = " + id + ", first_name = '" + first_name + "', last_name = '" + last_name + "', email = '" + email + "', phone = '" + phone + "'}";
	}
}