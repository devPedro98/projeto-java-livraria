package br.com.projeto.livraria.selenium.create.book;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateBookPage {
	private WebDriver browser;

	public CreateBookPage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		this.browser = new ChromeDriver(options);
		this.browser.navigate().to("http://localhost:8080/projeto-livraria/main");
		this.browser.findElement(By.id("button-add-book")).click();
	}

	public void closeBrowser() {
		this.browser.quit();
		
	}

	public void fillOutFormBook(String bookName, String bookAuthor, String bookCategory) {
		this.browser.findElement(By.id("book-name")).sendKeys(bookName);
		this.browser.findElement(By.id("book-author")).sendKeys(bookAuthor);
		this.browser.findElement(By.id("book-category")).sendKeys(bookCategory);
		
	}

	public void registryBook() {
		this.browser.findElement(By.id("button-cadastrar")).click();
		
	}

	public String getUrl() {
		return this.browser.getCurrentUrl();
	}

	public boolean containsSpanError(String spanMessage) {
		return browser.getPageSource().contains(spanMessage);
	}

}
