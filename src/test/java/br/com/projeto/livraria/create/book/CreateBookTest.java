package br.com.projeto.livraria.create.book;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateBookTest {
	private WebDriver browser;

	@Before
	public void beforeEach() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		this.browser = new ChromeDriver(options);
		this.browser.navigate().to("http://localhost:8080/projeto-livraria/main");
		this.browser.findElement(By.id("button-add-book")).click();
	}
}
