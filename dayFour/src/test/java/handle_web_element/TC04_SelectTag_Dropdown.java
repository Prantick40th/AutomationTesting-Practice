package handle_web_element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.DriverSetup;

public class TC04_SelectTag_Dropdown extends DriverSetup{
	@Test
	public void testRadioButton() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement selectOption =  driver.findElement(By.id("dropdown-class-example"));
		selectOption.click();
		
		//Select select = new Select(selectOption);
		
		Select select = new Select(selectOption);
		
		select.selectByIndex(2);
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(select.getFirstSelectedOption().getText(), "Option3");
		
		Thread.sleep(2000);
		
		select.selectByValue("option3");
		softAssert.assertEquals(select.getFirstSelectedOption().getText(), "Option2");
		
		Thread.sleep(2000);
		select.selectByVisibleText("Option1");
		softAssert.assertEquals(select.getFirstSelectedOption().getText(), "Option1");
		
		System.out.println(select.getOptions().size());
		System.out.println(select.getOptions().get(2).getText());
//		driver.findElement(By.xpath("//option[@value='option2']")).click();
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	@Test
	public void dropDownBySelectClass() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement selectOption =  driver.findElement(By.id("dropdown-class-example"));
		selectOption.click();
		Thread.sleep(2000);
		
		Select select = new Select(selectOption);
		
		select.selectByIndex(3);
	
		
		SoftAssert softAssert = new SoftAssert();
		//select.selectByIndex(3);
		softAssert.assertEquals(select.getFirstSelectedOption().getText(), "Option3");
		
	
		Thread.sleep(3000);
	}
}
