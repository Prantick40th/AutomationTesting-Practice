package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DriverSetup {

	public WebDriver driver;

	@BeforeSuite
	@Test
	public void setDriver() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		// driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.3.1");
	}

	@AfterSuite
	public void quitDriver() {
		driver.quit();
	}

}
