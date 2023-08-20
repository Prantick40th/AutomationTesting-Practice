package pages;

import org.testng.annotations.Test;

import utilities.DriverSetupITB;

public class loginPageITB extends DriverSetupITB {
	
	@Test
	public void test1() throws InterruptedException {
		getDriver().get("https://www.daraz.com.bd/");
		Thread.sleep(3000);
	}

}
