package crossword_pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrossHomePage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id="search")
	WebElement searchBar;
	
	public void enterBookNameInSearchBar(String bookName) {
		searchBar.sendKeys(bookName);
	}
	
	@FindBy(xpath="//button[contains(text(),'View More')]")
	WebElement searchViewMore;
	
	public void clickOnViewMoreOnSearch() {
		searchViewMore.click();
	}
	
	@FindBy(xpath="(//span[@class='wizzy-common-select-selectedItem'])[1]")
	WebElement sortByDropDown;
	
	public void clickOnSortByDropDown() {
		sortByDropDown.click();	
	}
	
	@FindBy(xpath="//div[contains(@class='wizzy-common-select-option') and normalize-space()='Price: Low to High']")
	WebElement lowToHighPrice;
	
	public void clickOnLowToHightPrice() {
		lowToHighPrice.click();
	}
	
	public CrossHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	
}
