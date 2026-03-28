package base;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Logger log;
	public static Properties prop;

	// ==========================================================
	// REPORT INITIALIZATION
	// ==========================================================
	@BeforeSuite
	public void startReport() {

		ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);

		log = Logger.getLogger(BaseTest.class);
		log.info("===== Test Suite Started =====");
	}

	// ==========================================================
	// LOAD CONFIG + LAUNCH BROWSER
	// ==========================================================
	@BeforeClass
	public void setup() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("src/main/resources/configuration.properties");
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--window-size=1920,1080");

			driver = new ChromeDriver(options);

		}

		else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();

		}

		else if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		}

		else {

			throw new RuntimeException("Invalid browser name in config.properties");

		}

		driver.manage().window().maximize();

		driver.get(url);
		log.info("Navigated to URL: " + url);
	}

	// ==========================================================
	// CREATE EXTENT TEST BEFORE EVERY @Test METHOD
	// ==========================================================
	@BeforeMethod
	public void createExtentTest(Method method) {

		test = extent.createTest(method.getName());
		log.info("===== Starting Test: " + method.getName() + " =====");
	}

	// ==========================================================
	// SCREENSHOT
	// ==========================================================
//    public String takeScreenshot(String testName) {
//
//        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        String path = "screenshots/" + testName + ".png";
//
//        try {
//
//            File dest = new File(path);
//            dest.getParentFile().mkdirs(); // create folder if not exist
//
//            FileUtils.copyFile(src, dest);
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//
//        }
//
//        return path;
//    }

	// ==========================================================
	// ADD SCREENSHOT TO EXTENT ON FAILURE
	// ==========================================================
	@AfterMethod
	public void tearDownMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

//            String filePath = takeScreenshot(result.getName());
//
//            String base64 =
//                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

			test.fail("Test Failed: " + result.getThrowable());
//            test.addScreenCaptureFromPath(filePath);
//            test.addScreenCaptureFromBase64String(base64);

			log.error("Test failed: " + result.getName());
		}
	}

	// ==========================================================
	// CLOSE BROWSER
	// ==========================================================
	@AfterClass
	public void closeBrowser() {

		if (driver != null) {

			driver.quit();
			log.info("Browser closed");
		}
	}

	// ==========================================================
	// FLUSH REPORT
	// ==========================================================
	@AfterSuite
	public void flushReport() {

		extent.flush();
		log.info("===== Test Suite Finished =====");
	}
}
