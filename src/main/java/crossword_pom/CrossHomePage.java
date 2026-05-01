package crossword_pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	@FindBy(xpath="//div[contains(@class,'wizzy-common-select-selector')]")
	WebElement sortByDropDown;
	
	public void clickOnSortByDropDown() {
		
		wait.until(ExpectedConditions.elementToBeClickable(sortByDropDown));		
		sortByDropDown.click();	
	}
	
	@FindBy(xpath="//div[contains(@title, 'Price: Low to High')]")
	WebElement lowToHighPrice;
	
	public void clickOnLowToHightPrice() {
		lowToHighPrice.click();
	}
	
	@FindBy(xpath="//p[@class='product-item-original-price']")
	List<WebElement> allProductPrice;
	
	public CrossHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	
	
}
