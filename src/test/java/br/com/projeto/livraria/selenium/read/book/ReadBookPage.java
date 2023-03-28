package br.com.projeto.livraria.selenium.read.book;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReadBookPage {

	private WebDriver browser;

	ReadBookPage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		this.browser = new ChromeDriver(options);
		this.browser.navigate().to("http://localhost:8080/projeto-livraria/main");	
	}

	public void quitBrowser() {
		this.browser.quit();
	}

	public Boolean readBook() {
		return this.browser.getPageSource().contains("Nenhum livro foi cadastrado");

	}

}
