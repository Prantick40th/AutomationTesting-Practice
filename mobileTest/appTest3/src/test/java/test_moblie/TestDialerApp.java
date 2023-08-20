package test_moblie;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidElement;
import utilities.DriverSetup;

public class TestDialerApp extends DriverSetup {
	
	
	
	@Test
	public void test_dial() throws MalformedURLException {	    
	    driver.findElement(By.id("fab")).click();
	    List<AndroidElement> keypad =  driver.findElements(By.id("com.android.dialer:id/dialpad_key_number"));
	    
	    keypad.get(10).click();
	    System.out.println(keypad.get(10).getText());
	    keypad.get(0).click();
	    keypad.get(2).click();
	    assertEquals(driver.findElement(By.id("com.android.dialer:id/digits")), "013");
	    driver.quit();
	}


}
