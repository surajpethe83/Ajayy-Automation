package utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LoginReadExcelUserNameAndPassword {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");
		options.addArguments("--disable-save-password-bubble");
		
		Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
		
		String userNameData = ExcelUtil.getCellData("sheet1", 1, 0);  //read user name data from excel
		String passwordData = ExcelUtil.getCellData("sheet1", 1, 1);  // read password data from excel

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys(userNameData);
		driver.findElement(By.id("password")).sendKeys(passwordData);
		driver.findElement(By.id("login-button")).click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Swag Labs";
		Assert.assertEquals(actualTitle, expectedTitle, "page title does not matches");

		
	}

}
