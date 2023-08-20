package utilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DriverSetup {
	public AndroidDriver<AndroidElement> driver;

	@BeforeSuite
	public void setDriver() throws MalformedURLException {
		File f = new File("src");
		File fs = new File(f, "General-Store.apk");
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("appium:udid", "emulator-5554");
	    desiredCapabilities.setCapability("deviceName","local");
	    desiredCapabilities.setCapability("automationName", "UiAutomator2");
	    desiredCapabilities.setCapability("app", fs.getAbsolutePath());
		
	    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

	    driver = new AndroidDriver<AndroidElement>(remoteUrl, desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void quitDriver() {
		driver.quit();
	}
}
