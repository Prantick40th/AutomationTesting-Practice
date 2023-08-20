package test_moblie;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.metal.MetalIconFactory.TreeLeafIcon;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestDialerApp {
	
	@Test
	public void test_dial() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("appium:udid", "emulator-5554");
	    desiredCapabilities.setCapability("deviceName","pixel3");
	    desiredCapabilities.setCapability("automationName", "UiAutomator2");
	    desiredCapabilities.setCapability("appPackage", "com.google.android.dialer");
	    desiredCapabilities.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
		
	    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

	    AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(remoteUrl, desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //driver.findElement(By.id("fab")).click();
	    
	    driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Favorites\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
	    
	    //List<AndroidElement> Keypad = (List<AndroidElement>) driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"key pad\"]"));
	    
	    
	    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("key pad");
	    el4.click();
	    MobileElement el5 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"0\"]/android.widget.LinearLayout/android.widget.TextView");
	    el5.click();
	    MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("1,");
	    el6.click();
	    MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("3,DEF");
	    el7.click();
	    MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("dial");
	    el8.click();

	    
		/*
		 * List<AndroidElement> keypad =
		 * driver.findElements(By.id("com.android.dialer:id/dialpad_key_number"));
		 * 
		 * keypad.get(10).click(); System.out.println(keypad.get(10).getText());
		 * keypad.get(0).click(); keypad.get(2).click();
		 * assertEquals(driver.findElement(By.id("com.android.dialer:id/digits")),
		 * "013"); driver.quit();
		 */
	}
}
