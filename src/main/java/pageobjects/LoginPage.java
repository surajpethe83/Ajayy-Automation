package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	By userName = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@type='submit']");

	public void enterUserName(String uname) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).sendKeys(uname);
	}

	public void enterPassword(String pass) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
	}

	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn))
        .click();
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
}
