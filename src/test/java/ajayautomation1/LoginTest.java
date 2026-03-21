package ajayautomation1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-blink-features=AutomationControlled");

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void verifyLoginPageTitle() {

		String actualLoginPageTitle = driver.getTitle();
		Assert.assertEquals(actualLoginPageTitle, "OrangeHRM");
		System.out.println(actualLoginPageTitle);

	}

	@Test(priority = 1)
	public void verifyLoginPageSourceDoesNotContainError() {
		Assert.assertFalse(driver.getPageSource().contains("404") || driver.getPageSource().contains("500"));
	}

	@Test(priority = 3)
	public void verifyLoginWithValidCredentials() {

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}

	@Test(priority = 4)
	public void verifyErrorMessageForInvalidLogin() {
		driver.findElement(By.name("username")).sendKeys("Admin23");
		driver.findElement(By.name("password")).sendKeys("admin12312");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Invalid credentials']")).isDisplayed());

	}

	@Test(priority = 5)
	public void verifyLoginFieldPlaceholders() {

		String userNamePlaceholder = driver.findElement(By.name("username")).getDomAttribute("placeholder");
		String passwordPlaceholder = driver.findElement(By.name("password")).getDomAttribute("placeholder");

		Assert.assertEquals(userNamePlaceholder, "Username", "placeholder name for username did not matches");
		Assert.assertEquals(passwordPlaceholder, "Password", "placeholder name for password did not matches");

	}

	@Test(priority = 6)
	public void verifyPasswordFieldIsMasked() throws InterruptedException {

		Assert.assertTrue(driver.findElement(By.name("password")).getDomAttribute("type").equals("password"),
				"password does not masked");
		System.out.println(driver.findElement(By.name("password")).getDomAttribute("type"));
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
