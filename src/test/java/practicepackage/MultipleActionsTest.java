package practicepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleActionsTest {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/key_presses");
	}

	@Test
	public void multipleKeyboardActions() throws InterruptedException {
		Actions act = new Actions(driver);

		act.keyDown(Keys.DOWN) // Press shift key no release
				.sendKeys("a") // Enter value a
				.keyUp(Keys.UP) // Release shift key
				.build().perform();

		WebElement result = driver.findElement(By.id("result"));
		String resulttext = result.getText();
		System.out.println(resulttext);
		Assert.assertTrue(resulttext.contains("A"));
	}

	@AfterMethod
	public void tearUp() {
		driver.close();
	}
}
