package test_moblie;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidElement;
import utilities.DriverSetup;

public class TestGenaralStorAPK extends DriverSetup{
	
	@Test
	public void test_genaral_store_apk() throws MalformedURLException {
	    AndroidElement countryDropDown = driver.findElement(By.id("spinnerCountry"));
	    countryDropDown.click();
	    AndroidElement countryAngola = driver.findElement(By.xpath("//android.widget.TextView[@text='Angola']"));
	    countryAngola.click();
	    AndroidElement name = driver.findElement(By.id("nameField"));
	    name.sendKeys("Test Name");
	    driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}

}
