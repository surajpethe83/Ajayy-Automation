package practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsEnabledTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(priority=1)
	public void verifyIsEnabled() {
		//verify field is disabled
				//perform some action..in this case click
				//verify field is enabled now
				//then enter values using sendkeys
				WebElement inputbox = driver.findElement(By.xpath("//form[@id='input-example']/input"));		
				WebElement enablebtn = driver.findElement(By.xpath("//form[@id='input-example']/button"));		
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				//isdisplayed will return boolean values ie True or false.
				boolean enablebtnbeforeclick = inputbox.isEnabled();
				System.out.println("Before clicking enable btn the state is=" +enablebtnbeforeclick);
				enablebtn.click();
				wait.until(ExpectedConditions.elementToBeClickable(inputbox));
				boolean enablebtnafterclick = inputbox.isEnabled();
				System.out.println("After clicking enable btn the state is=" +enablebtnafterclick);
				inputbox.sendKeys("Entervalues");
		
	}
	
}
