package br.com.livrariaasafe.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.livrariaasafe.model.Book;
import br.com.livrariaasafe.model.Person;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("livraria");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Book book = new Book();
			book.setName("Cristianismo Puro e Simples");
			book.setAuthor("C.S Lewis");
			book.setCategory("Literatura Cristã");

			Person person = new Person();
			person.setName("Eliana Santos");
			person.setSurname("Barrios");

			person.setBook(book);

			book.getPeople().add(person);

			em.persist(book);
			em.persist(person);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
			emf.close();

		}

	}
}
