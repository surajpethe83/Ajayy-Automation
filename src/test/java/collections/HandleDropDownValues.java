package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleDropDownValues {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");
	}

	@Test
	public void verifyElementsPresentInDom() {

		WebElement dropdown = driver.findElement(By.id("dropdown"));

		Select s = new Select(dropdown);
		List<WebElement> allOptions = s.getOptions();

		List<String> actualTextValues = new ArrayList<String>();

		for (int i = 0; i < allOptions.size(); i++) {
			actualTextValues.add(allOptions.get(i).getText());
		}

		System.out.println(actualTextValues);
		List<String> expectedList = Arrays.asList("Please select an option", "Option 1", "Option ");

		if(actualTextValues.equals(expectedList))
				System.out.println("Both lists are matching");
		else 
			System.out.println("Both lists are not matching");
		
		
		Assert.assertTrue(actualTextValues.equals(expectedList), "both lists are same");

		driver.close();
	}
}
