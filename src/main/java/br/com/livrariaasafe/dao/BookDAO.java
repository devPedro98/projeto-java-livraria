package br.com.livrariaasafe.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.livrariaasafe.model.Book;

public class BookDAO {
	
	private EntityManager em;
	
	public BookDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void register(Book book) {
		this.em.persist(book);
	}
	
	public List<Book> readAllBooks(){
		String jpql = "SELECT p FROM Book p";
		return em.createQuery(jpql, Book.class).getResultList();
	}
	
	
}
