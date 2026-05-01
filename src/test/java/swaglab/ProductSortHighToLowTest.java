package swaglab;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import swaglabPOM.Dashboard;
import swaglabPOM.ProductSortHighToLowPOM;
import swaglab_basepackage.BaseClass_SwagLab;

public class ProductSortHighToLowTest extends BaseClass_SwagLab{
	
	Dashboard ds;
	
	@Test
	public void verifyProductSortLowToHigh() throws InterruptedException, AWTException {
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
		Thread.sleep(2000);
		ds = new Dashboard(driver);
		ds.clickOkOnBrowserAlert();
		log.info("clicked Entered on Browser popup");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		test.pass("loginTest_SwagLab()");
		log.info("Swag Lab Login Test Pass");

//		======================
		log.info("=============================");
		
		ProductSortHighToLowPOM prod = new ProductSortHighToLowPOM(driver);
		prod.selectSortPriceHighToLow("Price (low to high)");
		List<Double> actualPrices = prod.getAllProductPrices();

	    //actualPrices-> [7.99, 9.99, 15.99]
	    //sortedPrices->  [7.99, 9.99, 15.99]     
	    // Step 4: Sort copy list
	    List<Double> sortedPrices = new ArrayList<Double>(actualPrices);
	    Collections.sort(sortedPrices);
	    
	 // Step 5: Compare
	    Assert.assertEquals(actualPrices, sortedPrices, "Prices are NOT sorted low to high");
	    test.pass("Products sorted correctly (Low to High)");
	}
	
	@Test
	public void verifyProductSortHighToLow() throws InterruptedException, AWTException {

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
		Thread.sleep(2000);
		ds = new Dashboard(driver);
		ds.clickOkOnBrowserAlert();
		log.info("clicked Entered on Browser popup");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		test.pass("loginTest_SwagLab()");
		log.info("Swag Lab Login Test Pass");

//		======================
		log.info("=============================");

		
		ProductSortHighToLowPOM prod = new ProductSortHighToLowPOM(driver);
		prod.selectSortPriceHighToLow("Price (high to low)");
		List<Double> actualPrices = prod.getAllProductPrices();

	    //actualPrices-> [15.99, 9.99, 7.99]
	    //sortedPrices->  [15.99, 9.99, 7.99]     
	    // Step 4: Sort copy list
	    List<Double> sortedPrices = new ArrayList<Double>(actualPrices);
	    Collections.reverse(sortedPrices);
	    
	 // Step 5: Compare
	    Assert.assertEquals(actualPrices, sortedPrices, "Prices are NOT sorted low to high");
	    test.pass("Products sorted correctly (high to low)");
	  
	}
}
