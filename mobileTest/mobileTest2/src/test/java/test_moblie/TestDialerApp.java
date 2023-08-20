package test_moblie;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestDialerApp {
	
	@Test
	public void test_genaral_store_apk() throws MalformedURLException {
		File f = new File("src");
		File fs = new File(f, "General-Store.apk");
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("appium:udid", "emulator-5554");
	    desiredCapabilities.setCapability("deviceName","pixel3");
	    desiredCapabilities.setCapability("automationName", "UiAutomator2");
	    
	    //desiredCapabilities.setCapability("appium:app", "E:/2. Task/Eclipse Workstation/mobileTest2/src/General-Store.apk");
	    
	    desiredCapabilities.setCapability("app", fs.getAbsolutePath());
		
	    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

	    AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(remoteUrl, desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	}

}
