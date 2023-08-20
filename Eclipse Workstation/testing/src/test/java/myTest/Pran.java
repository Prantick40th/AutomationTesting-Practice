package myTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pran {
	
	@Test
	public void WTT() {
		
		//////////use setup//////////
		//WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.whitelistedIps", "");
		
		/////////or setPropety///////
		System.setProperty("webdriver.chrome.driver", "E:\\2. Task\\Eclipse Workstation\\drivers\\chromedriver.exe");
		
		
		////////Add chrome options to avoid local issues////////
		ChromeOptions options = new ChromeOptions();
		options.addArguments ("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver (options);
		
		driver.get("https://stackoverflow.com/");
		
		
	}
}
