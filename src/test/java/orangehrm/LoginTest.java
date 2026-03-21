package orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class LoginTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginTestFunctionality() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName("Admin");
		Thread.sleep(3000);
		login.enterPassword("admin123");
		Thread.sleep(3000);
		login.clickLogin();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	
}
