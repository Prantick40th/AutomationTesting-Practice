package pages;

import org.testng.annotations.Test;

import utilities.DriverSetup;

public class loginPage extends DriverSetup {
	
	@Test
	public void test1() throws InterruptedException {
		getDriver().get("https://www.daraz.com.bd/");
		Thread.sleep(3000);
	}

}
