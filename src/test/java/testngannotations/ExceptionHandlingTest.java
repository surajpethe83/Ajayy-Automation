package testngannotations;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExceptionHandlingTest {

	WebDriver driver;

	@BeforeMethod
	public void setUpMethod() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void exceptionTest1() {
		driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
		driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();

	}

	@Test(priority = 2, expectedExceptions = {org.openqa.selenium.NoSuchElementException.class, ElementNotInteractableException.class})
	public void exceptionTest2() throws InterruptedException {
		driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
		driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
	}

}
