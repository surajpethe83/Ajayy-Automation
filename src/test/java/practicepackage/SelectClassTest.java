package practicepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectClassTest {

//	https://github.com/ajayautomates/HybridFramework
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");
		driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	public void selectClassFunctionality() {
		WebElement dropdownElement = driver.findElement(By.id("dropdown"));
	    // Create Select object
	    Select dropdown = new Select(dropdownElement);
	 
	    //verify default value is "Please select an option"
	    String defaultvalue = dropdown.getFirstSelectedOption().getText();
	    System.out.println("default value is" +defaultvalue);
	    
	    //use assertion
	    Assert.assertEquals(defaultvalue, "Please select an option");   
	    dropdown.selectByVisibleText("Option 2");
	    //dropdown.selectByValue("1");
	    //dropdown.selectByIndex(0);
	    
	    String verifyselectedvalue = dropdown.getFirstSelectedOption().getText();
	    System.out.println("selected value from dropdown  is" +verifyselectedvalue);   
	    //use assertion
	    Assert.assertEquals(verifyselectedvalue, "Option 2");
	}
	
}
