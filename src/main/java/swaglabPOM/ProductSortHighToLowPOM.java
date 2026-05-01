package swaglabPOM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductSortHighToLowPOM {
	
	WebDriver driver;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	WebElement sortDropDown;
	
	public void selectSortPriceHighToLow(String sortValue) {
		Select s = new Select(sortDropDown);
		s.selectByVisibleText(sortValue);
	}
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	List<WebElement> priceElements;
    List<Double> actualPrices = new ArrayList<>();

	
	public  List<Double> getAllProductPrices() {
	
	    for (int i = 0; i < priceElements.size(); i++) {
	        String priceText = priceElements.get(i).getText();   // "$29.99"
	        priceText = priceText.replace("$", "");              // "29.99"
	        double price = Double.parseDouble(priceText);        // 29.99
	        actualPrices.add(price);
	    }
	    
	    return actualPrices; 
	}
	
	public ProductSortHighToLowPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
