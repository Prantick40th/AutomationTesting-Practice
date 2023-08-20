package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class DriverSetup {
	private static String browserName = System.getProperty("browser", "brave");
	//private static String browserName = System.setProperty("browser", "chrome");
	private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

	public static void setDriver(WebDriver driver) {
		LOCAL_DRIVER.set(driver);
	}

	public static WebDriver getDriver() {
		return LOCAL_DRIVER.get();
	}

	public static WebDriver getBrowser(String browserName) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		EdgeOptions options2 = new EdgeOptions();
		options2.addArguments("--remote-allow-origins=*");
		

		switch (browserName.toLowerCase()) {
		case "chrome":
			return new ChromeDriver(options);
		case "firefox":
			return new FirefoxDriver();
		case "edge":
			return new EdgeDriver(options2);
		case "brave":
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			return new ChromeDriver(options);
		default:
			throw new RuntimeException("Browser not found using the name '" + browserName + "'!");
		}
	}
	
	
	@BeforeClass
	public static synchronized void setBrowser() {
		WebDriver driver = getBrowser(browserName); //new chromeDriver() with driver instance
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().window().maximize();
		setDriver(driver);
	}
	
	@AfterClass
	public static synchronized void quitBrowser() {
		getDriver().quit();
	}

}
