package locator;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.DriverSetup;


public class MyFistWebTest extends DriverSetup{

	@Test
	public void testWebPageTitle() throws InterruptedException {
		driver.get("https://bikroy.com/bn"); //get the link
		//System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), "Bikroy - বাংলাদেশে ইলেকট্রনিকস, গাড়ি, প্রপার্টি এবং চাকরি");
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void testDescriptonByClassName() {
		driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.3.1");
		WebElement descrption = driver.findElement(By.className("im-description"));
		assertEquals(descrption.getText(),
				"Automated driver management and other helper features for Selenium WebDriver in Java");
		driver.quit();
	}

	@Test
	public void testNameByLinkText() {
		driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.3.1");
		WebElement name = driver.findElement(By.linkText("WebDriverManager"));
		assertEquals(name.getText(), "WebDriverManager");
		driver.quit();
	}
	
	@Test
	public void linktest() throws InterruptedException {
		driver.get("https://bikroy.com/bn");
		//WebElement name = driver.findElement(By.linkText("সকল বিজ্ঞাপন"));
		WebElement name =  driver.findElement(By.className("all-ads-button--1c5U5 header-link--woAbP"));
		
		//name.click();
		//System.out.println(linktext.getText());
		assertEquals(name.getText(), "সকল বিজ্ঞাপন");
		Thread.sleep(5000);
		driver.quit();	
		
	}

	@Test
	public void testNameByPartialLinkText() {
		driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.3.1");
		WebElement name = driver.findElement(By.partialLinkText("WebDriverMan"));
		assertEquals(name.getText(), "WebDriverManager");
		driver.quit();
	}

	@Test
	public void testSearchFieldByID() throws InterruptedException {
		driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.3.1");
		WebElement searchInput = driver.findElement(By.id("query"));
		searchInput.sendKeys("testng");
		WebElement search_button = driver.findElement(By.className("button"));
		search_button.click();
		Thread.sleep(5000);
		assertEquals(driver.getTitle(), "Just a moment...");
		Thread.sleep(10000);
		driver.quit();
	}
	
	@Test
	public void searchkey() throws InterruptedException {
		
		driver.get("https://www.daraz.com.bd/");
		WebElement searchInput = driver.findElement(By.className("search-box__input--O34g"));
		searchInput.sendKeys("SSD");
		WebElement searchButton = driver.findElement(By.className("search-box__button--1oH7"));
		searchButton.click();
		
		Thread.sleep(9000);
		driver.quit();	
	}

	@Test
	public void testSearchFieldByName() throws InterruptedException {
		driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.3.1");
		WebElement searchInput = driver.findElement(By.name("q"));
		searchInput.sendKeys("Hello");
		WebElement search_button = driver.findElement(By.className("button"));
		search_button.click();
		Thread.sleep(5000);
		assertEquals(driver.getTitle(), "Just a moment...");
		Thread.sleep(10000);
		driver.quit();
	}

}
