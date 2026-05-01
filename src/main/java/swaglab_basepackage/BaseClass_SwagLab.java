package swaglab_basepackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseTest;

public class BaseClass_SwagLab {
	protected WebDriver driver;

	public static ExtentReports extent;
	public static ExtentTest test;
	public static Logger log ;


	// ==========================================================
	// REPORT INITIALIZATION
	// ==========================================================
	@BeforeSuite
	public void startReport() {

		ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);

		log = LogManager.getLogger(BaseTest.class);
		log.info("===== Test Suite Started =====");
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		test = extent.createTest("Swag Lab");
	}

	@AfterClass
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail("Test Failed: " + result.getThrowable());
			log.error("Test failed: " + result.getName());
		}

		driver.close();
	}

}
