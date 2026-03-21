package collections;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementPresentInDom {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
	}

	@Test
	public void verifyElementsPresentInDom() {
		
		List<WebElement> links = driver.findElements(By.linkText("Elemental Seleniu"));	
		
		if(links.size()>0) 
			System.out.println("Element is present");
		else 
			System.out.println("Element is not present");
		
			Assert.assertTrue(links.size()>0, "Element is not present");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
