package br.com.livrariaasafe.model;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.livrariaasafe.util.JPAUtil;

public class BookDAO {

	private EntityManager em = JPAUtil.getEntityManager();

	public void register(Book book) {
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
		em.close();
	}

	public List<Book> readAllBooks() {
		String jpql = "SELECT p FROM Book p";
		return em.createQuery(jpql, Book.class).getResultList();
	}

	public Book selectId(Long id) {
		return em.find(Book.class, id);
	}

}
