package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.DarazLoginPage;
import utilities.DataSet;
import utilities.DriverSetup;

public class TestLogin extends DriverSetup {
	DarazLoginPage loginPage = new DarazLoginPage();
	
	@Test
	public void testLogInwithInalidCredentials() throws InterruptedException {
		getDriver().get(loginPage.LOGINPAGE_URL);
		loginPage.doLogin("0111111111", "password");
		Thread.sleep(5000);
		assertEquals(loginPage.getErrorMessage(), loginPage.ERROR_MESSAGE_TEXT);
	}
	@Test
	public void testLogInwithInalidCredentialsPassword() {
		getDriver().get(loginPage.LOGINPAGE_URL);
		loginPage.doLogin("01724444444", "password");
		assertEquals(loginPage.getErrorMessage(), loginPage.ERROR_MESSAGE_PASSWORD_TEXT);
	}
	
	//Dataset is using here
	@Test(dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
	public void testLoginWithInvalidCredentialsUsingDateProvider(String username, String password, String message) {
		getDriver().get(loginPage.LOGINPAGE_URL);
		loginPage.doLogin(username, password);
		assertEquals(loginPage.getErrorMessage(), message);
	}

}
