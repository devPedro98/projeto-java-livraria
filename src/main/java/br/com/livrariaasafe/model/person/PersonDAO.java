package br.com.livrariaasafe.model.person;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.livrariaasafe.model.book.Book;
import br.com.livrariaasafe.util.JPAUtil;

public class PersonDAO {

	private EntityManager em = JPAUtil.getEntityManager();

	public List<Person> readAllPeople() {
		String jpql = "SELECT p FROM Person p JOIN FETCH p.book";
		TypedQuery<Person> query = em.createQuery(jpql, Person.class);
		return query.getResultList();
	}

	public void createPerson(Person person) {
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		em.close();
	}
}
