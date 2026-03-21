package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsHandlingTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
	}

	@Test
	public void multipleWindowHandles() throws InterruptedException {

		// get parent window details or ID. gjshg2917209
		// click the link and get all the opened window ids.
		// then we will loop through the windows..
		// identify child windows and perform validations/assert
		// close the child window (driver.close) and go back to parent window
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Click Here")).click(); 
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
		// Set will not support indexing, List use to support index
		List<String> windowlist = new ArrayList<>(windows);
		// windows.get(0),windows.get(1)

		for (int i = 0; i < windowlist.size(); i++) {
			String window = windowlist.get(i);

			if (!window.equals(parentwindow)) {
				driver.switchTo().window(window);
				Thread.sleep(3000);
				System.out.println(driver.findElement(By.tagName("h3")).getText());
				driver.close();
				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(parentwindow);
		System.out.println("came back to main parent window");

	}
}
