package crossworld_test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import crossword_pom.CrossHomePage;

public class SearchForBookTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.crossword.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	}

	@Test
	public void searchForBook() throws InterruptedException {
		CrossHomePage cross = new CrossHomePage(driver);
		cross.enterBookNameInSearchBar("Menifest");
		Thread.sleep(3000);
		cross.clickOnViewMoreOnSearch();
		Thread.sleep(30);
		cross.clickOnSortByDropDown();
		cross.clickOnLowToHightPrice();
	}
	
}
