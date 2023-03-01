package br.com.livrariaasafe.testes;

import javax.persistence.EntityManager;

import br.com.livrariaasafe.dao.BookDAO;
import br.com.livrariaasafe.model.Book;
import br.com.livrariaasafe.util.JPAUtil;

public class CadastroDeLivros {

	public static void main(String[] args) {
		
	}

	private void registerBook() {
		Book livro1 = new Book();
		livro1.setAuthor("Rick Riordan");
		livro1.setCategory("Fantasia");
		livro1.setName("Percy Jackson e o Ladrão de Raios");
		EntityManager em = JPAUtil.getEntityManager();
		BookDAO bookDao = new BookDAO(em);
		em.getTransaction().begin();
		bookDao.register(livro1);
		em.getTransaction().commit();
		em.close();
	}
}
