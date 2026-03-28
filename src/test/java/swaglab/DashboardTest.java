package swaglab;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import swaglabPOM.Dashboard;
import swaglab_basepackage.BaseClass_SwagLab;

public class DashboardTest extends BaseClass_SwagLab {

	Dashboard ds;

	// extend report
	// logging
	// excel and properties files

	@Test
	public void loginTest_SwagLab() throws InterruptedException, AWTException {

		log.info("===========================");
		log.info("loginTest_SwagLab");
		test = extent.createTest("Swag Lab");

		ds = new Dashboard(driver);
		ds.enterUserName("standard_user");
		log.info("Entered UserName");
		ds.enterPassword("secret_sauce");
		log.info("Entered Password");
		ds.clickLoginBtn();
		log.info("clicked on login button");
		Thread.sleep(3000);
		ds = new Dashboard(driver);
		ds.clickOkOnBrowserAlert();
		log.info("clicked Entered on Browser popup");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		test.pass("loginTest_SwagLab()");
		log.info("Swag Lab Login Test Pass");
	}

	@Test
	public void verifyloginissuccessful_SwagLab() throws InterruptedException, AWTException {

		log.info("===========================");
		log.info("verify login successfull");

		
		String actualTitle = driver.getTitle();
		log.info("Get page title");
		String expectedTitle = "Swag Labs";
		Assert.assertEquals(actualTitle, expectedTitle, "page title does not matches");
		log.info("Verify page title");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		test.pass("Verify login success and redirected to Dashboard");
		log.info("Verify login success and redirected to Dashboard");
	}

	@Test
	public void verifyProductsAreDisplayedOnDashboard_SwagLab() {
		
		log.info("===========================");
		log.info("verify products displayed on dashboard");
		
		Assert.assertTrue(ds.checkProductHeaderIsDisplayed());
		test.pass("verify products header / title is displayed on product list page");
		log.info("verify products header / title is displayed on product list page");
		// few more validation
	}

	@Test
	public void verifyAddToCartUpdatesCartBadge_SwagLab() {
		
		log.info("===========================");
		log.info("verify add to cart updates cart badge");
		
		ds.clickOnAddToCart();
		log.info("Click on Add to cart button");
		String actualCartCount = ds.getCurrentCartCount();
		log.info("Get current cart count from cart baged");
		Assert.assertEquals(actualCartCount, "1");
		log.info("verify actual and expected cart count");
		// cart count is increasing / updating
		Assert.assertTrue(ds.removeCartBtnIsDisplayed());
		log.info("verify remove cart button displayed");
		test.pass("verify add to cart update cart badge");
	}

	@Test
	public void verifyUserNavigatesToProductDetailsPage_SwagLab() {
		
		log.info("===========================");
		log.info("verify user navigates to product details page");
		
		ds.clickOnProductLink();
		log.info("click on product link");
		String currentUrl = driver.getCurrentUrl();
		log.info("get current url");
		Assert.assertTrue(currentUrl.contains("inventory-item"));
		log.info("verify current url");
		driver.navigate().back();
		log.info("Navigated to product list page");
		Assert.assertTrue(ds.checkProductHeaderIsDisplayed());
		log.info("verify product header / title on product list page");

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		log.info("verify current url");
		test.pass("verify user navigates to product details page");
	}

	@Test
	public void verifyAllElementsOnProductCard_SwagLab() {
		
		log.info("===========================");
		log.info("verify all element present on product card");
		
		ds.clickOnRemoveCartBtn();
		log.info("click on remove cart button");
		ds.clickOnAddToCart();
		log.info("click on add to cart button");
		Assert.assertTrue(ds.isProductDescDisplayed());
		log.info("verify product description displayed");
		Assert.assertTrue(ds.isProductPriceDisplayed());
		log.info("verify product price displayed");
		Assert.assertTrue(ds.removeProductBtnIsDisplayed());
		log.info("verify remove to cart product button displayed");
		test.pass("verify all element present on product card");
	}

}
