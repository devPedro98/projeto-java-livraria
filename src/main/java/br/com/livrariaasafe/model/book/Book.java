package br.com.livrariaasafe.model.book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.livrariaasafe.model.person.Person;

@Entity
@Table(name = "livros")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String author;
	private String category;
	@OneToMany(mappedBy = "book")
	private List<Person> people = new ArrayList<>();

	public Book(String name, String author, String category) {
		super();
		this.name = name;
		this.author = author;
		this.category = category;
	}

	public Book() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}

}
