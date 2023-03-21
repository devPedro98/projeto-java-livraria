package br.com.projeto.livraria.create.book;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateBookTest {
	
	private CreateBookPage createBookPage;

	@Before
	public void beforeEach() {
		this.createBookPage = new CreateBookPage();
	}

	@After
	public void afterEach() {
		this.createBookPage.closeBrowser();
	}

	@Test
	public void createBookSuccess() {
		this.createBookPage.fillOutFormBook("Livro adicionado", "Autor Adicionado", "Categoria adicionado");
		this.createBookPage.registryBook();
		Assert.assertEquals("http://localhost:8080/projeto-livraria/html/successfully-registered-user.jsp",
				this.createBookPage.getUrl());
	}

	@Test
	public void createBookFail() {
		this.createBookPage.fillOutFormBook("nome", "autor", "categ");
		Assert.assertEquals("http://localhost:8080/projeto-livraria/html/add-book.jsp", this.createBookPage.getUrl());
		Assert.assertTrue(this.createBookPage.containsSpanError("Nome deve ter mais do que 8 caracteres"));
		Assert.assertTrue(this.createBookPage.containsSpanError("Autor deve ter mais do que 8 caracteres"));
		Assert.assertTrue(this.createBookPage.containsSpanError("Categoria deve ter mais do que 5 caracteres"));

	}
}
