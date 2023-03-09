package br.com.livrariaasafe.model.person;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.livrariaasafe.util.JPAUtil;

public class PersonDAO {

	private static final String SELECT_ALL_PEOPLE_FROM_DB = "SELECT p FROM Person p JOIN FETCH p.book";

	public List<Person> readAllPeople() {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			TypedQuery<Person> query = em.createQuery(SELECT_ALL_PEOPLE_FROM_DB, Person.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public void createPerson(Person person) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(person);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public void deletePerson(Person person) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			person = em.find(Person.class, person.getId());
			em.remove(person);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public Person getPerson(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return em.find(Person.class, id);
		} finally {
			em.close();
		}
	}

	public void updatePerson(Person person) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(person);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

}
