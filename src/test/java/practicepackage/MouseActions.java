package practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseActions {
	
	
	WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");
    }
    
    @Test
    public void hoverAndClick() throws InterruptedException {
 
    	WebElement img = driver.findElement(By.xpath("//img[@src='/img/avatar-blank.jpg'][1]"));
    	WebElement imgLink = driver.findElement(By.xpath("(//a[contains(text(),'View profile')])[1]"));
    	
    	Actions act = new Actions(driver);
    	act.moveToElement(img).perform();
    	
    	WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(imgLink)).click();
    
    	Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Not Found']")).getText(), "Not Foun", "Page not redirected to view profile page");
    }
    
    @AfterMethod
    public void tearUp() {
    	driver.close();
    }
}


