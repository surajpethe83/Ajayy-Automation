package orangehrm;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class AddAdminFlow {

	WebDriver driver;
	WebDriverWait wait;

	@Test(priority = 0)
	public void applaunch() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void Loginandverifydashboard() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.enterUserName("Admin");
		Thread.sleep(3000);
		login.enterPassword("admin123");
		Thread.sleep(3000);
		login.clickLogin();

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}

	@Test(priority = 2)
	public void navigateToAdminModule() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		
	driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']//span")).click();
	driver.findElement(By.xpath("//div[@class='orangehrm-header-container']")).click();			
	driver.findElement(By.xpath("//div[@class='oxd-select-wrapper']")).click();
	driver.findElement(By.xpath("//div[@role='option'][2]")).click();

	driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("123");
	
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@role='option'][1]")))).click();
	
	
//	(//div[contains(@class,'oxd-select-text')])[4]
	List<WebElement> statusList = driver.findElements(By.xpath("//div[@class='oxd-select-wrapper'][1]"));
	statusList.get(1).click();
	driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active oxd-input--error']")).sendKeys("Suraj");
	
	
	
	}

	@Test(priority = 3)
	public void addNewAdminUser() {

	}

	@Test(priority = 4)
	public void verifyCreatedUser() {

	}

	@Test(priority = 5)
	public void logoutApplication() {

	}

	@Test(priority = 6)
	public void tearDown() {

	}

}
