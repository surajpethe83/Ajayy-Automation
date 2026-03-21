package practicepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Add_RemoveElementsTest {

	WebDriver driver;

	@BeforeMethod
	public void setUpMethod() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void verifyAddElementFunctionality() {

		driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).isDisplayed(),
				"Element not found");
	}

	@Test(priority = 1)
	public void verifyRemoveElementFunctionality() {
		driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
		driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();

		int deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']")).size();
		Assert.assertEquals(deleteButtons, 0, "Element is not removed");
	}

	@AfterMethod
	public void tearUp() {
		driver.close();
	}
}
