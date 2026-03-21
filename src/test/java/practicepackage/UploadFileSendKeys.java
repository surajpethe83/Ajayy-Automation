package practicepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFileSendKeys {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/upload");
	}

	@Test
	public void uploadFileUsingSendKeys() {

		WebElement uploadFile = driver.findElement(By.id("file-upload"));
		uploadFile.sendKeys("C:\\Users\\Admin\\Downloads\\download.jfif");
		
		WebElement clickUpload = driver.findElement(By.id("file-submit"));
		clickUpload.click();
		
		Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "File Uploaded!",
				"Page is not redirected to File Uploaded! Page");

		Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "download.jfif");

	}

	@AfterTest
	public void tearDown() {
//        driver.quit();
	}
}
