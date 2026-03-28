package swaglabPOM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	WebDriver driver;

	@FindBy(id="user-name")
	WebElement username;
	
	public void enterUserName(String name) {
		username.sendKeys(name);
	}
	
	@FindBy(id="password")
	WebElement password;
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	@FindBy(id="login-button")
	WebElement loginBtn;
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void clickOkOnBrowserAlert() throws AWTException {
		Robot robot = new Robot();
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	@FindBy(xpath = "//span[@class='title']")
	WebElement productHeader;

	public boolean checkProductHeaderIsDisplayed() {
		return productHeader.isDisplayed();
	}

	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement addToCart;
	
	public void clickOnAddToCart() {
		addToCart.click();
	}
	
	@FindBy(id="remove-sauce-labs-backpack")
	WebElement removeCartBtn;
	
	public void clickOnRemoveCartBtn() {
		removeCartBtn.click();
	}
	
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")
	WebElement getRemoveCartBtn;
	
	public boolean removeCartBtnIsDisplayed() {
		return getRemoveCartBtn.isDisplayed();
	}
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement cartCount;
	
	public String getCurrentCartCount() {
		return cartCount.getText();
	}
	
	@FindBy(xpath="(//div[@class='inventory_item_name '])[1]")
	WebElement clickOnProduct;
	
	public void clickOnProductLink() {
		clickOnProduct.click();
	}
	
	@FindBy(xpath="(//div[@class='inventory_item_desc'])[1]")
	WebElement productDesc;
	
	public boolean isProductDescDisplayed() {
		return productDesc.isDisplayed();
	}

	@FindBy(xpath="(//div[@class='inventory_item_price'])[1]")
	WebElement productPrice;
	
	public boolean isProductPriceDisplayed() {
		return productPrice.isDisplayed();
	}
	
	
	@FindBy(id="remove-sauce-labs-backpack")
	WebElement removeProductBtn;
	
	public boolean removeProductBtnIsDisplayed() {
		return removeProductBtn.isDisplayed();
	}

	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
