package handle_web_element;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.DriverSetup;

public class JsInAutomation extends DriverSetup {
	@Test
	private void scrollUsingJs() throws InterruptedException {
		driver.get("https://www.w3schools.com");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(4000);
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0);");
		Thread.sleep(4000);
		WebElement numpy = driver.findElement(By.xpath("//h2[normalize-space()='NumPy']"));
		js.executeScript("arguments[0].scrollIntoView();", numpy);
		Thread.sleep(4000);
	}
	
	@Test
	public void testWait() {
		driver.get("https://qavbox.github.io/demo/alerts/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("delayalert")));
		btn.click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		assertEquals(alert.getText(), "I appeared after 5 seconds!");
		alert.accept();
	}
}
