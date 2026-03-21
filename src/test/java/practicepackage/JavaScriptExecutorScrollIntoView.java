package practicepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExecutorScrollIntoView {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/documentation/webdriver");
	}

	@Test
	public void scrollUsingScrollIntoView() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Browser interactions')]"));

		jse.executeScript("argument[0].ScrollIntoView(true)", element);

		Thread.sleep(1000);
		element.click();
	}

	@Test
	public void usingScrollByMethod() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,500)"); // scroll vertically downwards
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(1000,0)"); // scroll right
	}

	@Test
	public void javaScriptExecutorGetPageheight() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollTo(9, document.body.scrollHeight);");

		Thread.sleep(1000);
	}

	@AfterMethod
	public void tearUp() {
		driver.close();
	}

}
