package practicepackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleBrokenImagesTest {

	WebDriver driver;

	@BeforeMethod
	public void setUpMethod() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void findBrokenImagesFunctionality() throws MalformedURLException, IOException {
		List<WebElement> images = driver.findElements(By.tagName("img"));

		for (WebElement img : images) {

			String imgurl = img.getAttribute("src");
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(imgurl).openConnection();
				connection.setRequestMethod("GET");
				connection.connect();

				int statuscode = connection.getResponseCode();

				if (statuscode != 200) {
					System.out.println("Broken images " + imgurl + " | status " + statuscode);
				}else  {
					System.out.println("Broken images " + imgurl + " | status " + statuscode);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
