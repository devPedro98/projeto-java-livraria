package br.com.projeto.livraria.selenium.update.book;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class UpdateBookTest {
	
	private UpdateBookPage updateBook;
	
	@Before
	public void before() {
		this.updateBook = new UpdateBookPage();
	}
	
	@After
	public void after() {
		this.updateBook.quitBrowser();
	}
	
	@Test
	public void editBook() {
		this.updateBook.clickEdit("edit-book");
		this.updateBook.fillOutForm("Nome Editado", "Autor Editado", "Categoria editado");
		Assert.assertEquals("http://localhost:8080/projeto-livraria/html/successfully-updated.jsp", this.updateBook.clickUpdate());
	}
	
	
}
