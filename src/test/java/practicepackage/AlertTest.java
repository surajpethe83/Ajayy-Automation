package practicepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {

	WebDriver driver;

	@BeforeMethod
	public void setUP() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
	}

	@Test
	public void verifyAlertFuncionality() throws InterruptedException {

//		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		
//		WebElement resultText = driver.findElement(By.id("result"));
//		String getExpectedResultMsg = resultText.getText();
//		String actualResultMsg = "You successfully clicked an alert";
//		
//		Assert.assertEquals(actualResultMsg, getExpectedResultMsg, "Result text matches");
	
//		======================================
		
//		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
//		Alert dismissAlert = driver.switchTo().alert();
//		dismissAlert.dismiss();
//		
//		WebElement dismissResultText = driver.findElement(By.id("result"));
//		String getExpectedDismissResultMsg = dismissResultText.getText();
//		String actualDisResultMsg = "You clicked: Cancel";
//		
//		Assert.assertEquals(actualDisResultMsg, getExpectedDismissResultMsg, "Dismiss Result text matches");
		
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert textAlert = driver.switchTo().alert();
		textAlert.sendKeys("suraj");
		Thread.sleep(1000);
		textAlert.accept();
		
		
		WebElement textResultText = driver.findElement(By.id("result"));
		String getExpectedTextResultMsg = textResultText.getText();
		String actualTextResultMsg = "You entered: suraj";
		
		Assert.assertEquals(actualTextResultMsg, getExpectedTextResultMsg, "enter text and msg matches");
		
	}

//	@AfterMethod
//	public void tearUp() {
//		driver.close();
//	}

}
