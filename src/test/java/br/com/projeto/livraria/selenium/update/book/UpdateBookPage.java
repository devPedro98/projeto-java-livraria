package br.com.projeto.livraria.selenium.update.book;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UpdateBookPage {

	private WebDriver browser;

	UpdateBookPage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		this.browser = new ChromeDriver(options);
		this.browser.navigate().to("http://localhost:8080/projeto-livraria/main");
	}

	public void quitBrowser() {
		this.browser.quit();

	}

	public void clickEdit(String classBook) {
		this.browser.findElement(By.className(classBook)).click();

	}

	public void fillOutForm(String bookName, String bookAuthor, String bookCategory) {
		this.browser.findElement(By.id("book-name")).sendKeys(bookName);
		this.browser.findElement(By.id("book-author")).sendKeys(bookAuthor);
		this.browser.findElement(By.id("book-category")).sendKeys(bookCategory);
	}

	public String clickUpdate() {
		this.browser.findElement(By.id("input-cadastrar")).click();
		return this.browser.getCurrentUrl();
	}

}
