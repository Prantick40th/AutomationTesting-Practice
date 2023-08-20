package handle_web_element;

import javax.xml.stream.XMLStreamException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.DriverSetup;

public class TC05_Action extends DriverSetup{
	
	@Test
	public void TestDiffrentAction() throws InterruptedException {
		driver.get("https://demoqa.com/menu");
		Actions actions = new Actions(driver);
		
		WebElement mainMenu2 = driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']"));
		
		actions.clickAndHold(mainMenu2).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@href='#'][normalize-space()='Sub Item'])[1]")).click();
		actions.clickAndHold(driver.findElement(By.xpath("//a[normalize-space()='SUB SUB LIST »']"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Sub Sub Item 2']")).click();
		Thread.sleep(2000);
		
//		actions.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Menu']"))).build().perform();
//		Thread.sleep(2000);
		actions.scrollToElement(driver.findElement(By.xpath("//span[normalize-space()='Menu']"))).build().perform();
		Thread.sleep(2000);
		
	}
	@Test
	public void TestMultiselectUsingActions() throws InterruptedException {
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		Actions actions = new Actions(driver);
		driver.switchTo().frame("iframeResult");
		Select select = new Select(driver.findElement(By.id("cars")));
		actions.keyDown(Keys.CONTROL).click(select.getOptions().get(0)).click(select.getOptions().get(2)).keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(2000);
	}
	
	@Test
	public void testActionClass() throws InterruptedException {
		//driver.get("https://demoqa.com/menu");
		//Actions actions = new Actions(driver);
		
//		WebElement mainMenu2 = driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']"));
//		actions.clickAndHold(mainMenu2).build().perform();
//		Thread.sleep(3000);
//		
//		driver.findElement(By.xpath("(//a[@href='#'][normalize-space()='Sub Item'])[1]")).click();
//		Thread.sleep(3000);
//		//////////////////////////////////////////
		
//		actions.scrollToElement(driver.findElement(By.xpath("//span[normalize-space()='Menu']"))).build().perform();
//		Thread.sleep(5000);
		
		///////////////////////////////
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		
		driver.switchTo().frame("iframeResult");
		
		Actions actions = new Actions(driver);
		Select select = new Select(driver.findElement(By.id("cars")));
		// two click for two selection
		// parater the button
		WebElement op1 = select.getOptions().get(0);
		WebElement op3 = select.getOptions().get(2);
		
		actions.keyDown(Keys.CONTROL).click(op1).click(op3).keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		
	}

}
