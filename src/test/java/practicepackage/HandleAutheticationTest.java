package practicepackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleAutheticationTest {

	WebDriver driver;

	@BeforeMethod
	public void setUpMethod() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}

	@Test(priority=0)
	public void verifyAlertWithTwoInputFields() {

		String userName = "admin";
		String password = "admin";
		
		 String url = "https://" + userName + ":" + password + "@the-internet.herokuapp.com/basic_auth";
	        driver.get(url);		
	}
	
	
}
