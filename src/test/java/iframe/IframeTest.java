package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {

	@Test
	public void iframeTestFunctionality() {

		WebDriver driver;
		
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();

		driver.switchTo().frame("frame1");
		
		String getIframeText = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("Iframe text is "+ getIframeText);

		//switch to main screen
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");

		String getIframeText2 = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("Iframe text is "+ getIframeText2);
		}

	public void tearDown() {
		
	}
	
}
