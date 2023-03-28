package br.com.projeto.livraria.selenium.read.book;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class ReadBookTest {
	
	private ReadBookPage readBookPage;
	
	@Before
	public void beforeEach() {
		this.readBookPage = new ReadBookPage();
	}
	
	@After
	public void afterEach() {
		this.readBookPage.quitBrowser();
	}
	
	@Test
	public void readBookSuccess() {
		Assert.assertFalse(this.readBookPage.readBook());
	}
	

	
}
