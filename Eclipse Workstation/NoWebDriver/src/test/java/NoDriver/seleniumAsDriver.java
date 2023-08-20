package NoDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class seleniumAsDriver {
	
	@Test
	public void website() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments ("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver (options);
		
		driver.get("https://mvnrepository.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.quit();
	}
}
