package practicepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropClass {

	WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }
    
    
    @Test
    public void dragAndDrop() throws InterruptedException {
        
    	WebElement source = driver.findElement(By.id("column-a"));
    	WebElement destination = driver.findElement(By.id("column-b"));
    	
    	Actions act = new Actions(driver);
    	act.dragAndDrop(source, destination).perform();
    	
    	Assert.assertEquals(driver.findElement(By.id("column-b")).getText(), "A");
    	Assert.assertEquals(driver.findElement(By.id("column-a")).getText(), "B");

    }
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
	

