package ajayautomation1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SauceLabLogintest {

	WebDriver driver;

	@Test(priority = 0)
	public void applaunchtest() {
		// launch an app - a browser and a url
		// chrome
		driver = new ChromeDriver();
		driver.get("https://www.ajayautomates.com/");
		driver.findElement(By.id("Name")).sendKeys("myname");
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("Email");
	}

	@Test(priority = 1)
	public void maximizebrowser() {
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void closebrowser() {
		driver.quit();
	}

}
