package practicepackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MutiSelectDropDownTest {

	WebDriver driver;

	@BeforeMethod
	public void setUP() {
		driver = new ChromeDriver();
		driver.get("https://syntaxprojects.com/basic-select-dropdown-demo.php");
		driver.manage().window().maximize();
	}

	@Test
	public void verifyMultiSelectDropdown() throws InterruptedException {

		WebElement multiSelect = driver.findElement(By.id("multi-select"));
		Select multiSelectDropdown = new Select(multiSelect);

		System.out.println(multiSelectDropdown.isMultiple());
		
		multiSelectDropdown.selectByValue("California");
		multiSelectDropdown.selectByVisibleText("New Jersey");
		multiSelectDropdown.selectByIndex(5);		
		
		List<WebElement> multiSelectedValues = multiSelectDropdown.getAllSelectedOptions();
		
		for(WebElement selected :multiSelectedValues ) {
			System.out.println(selected.getText());
		}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(multiSelect));
	
	
	multiSelectDropdown.deselectByValue("California");
	Thread.sleep(1000);
	multiSelectDropdown.deselectByVisibleText("New Jersey");
	Thread.sleep(1000);
	multiSelectDropdown.deselectByIndex(5);		
	Thread.sleep(1000);
	
	}

	@AfterMethod
	public void tearUp() {
		driver.close();
	}
	
}
