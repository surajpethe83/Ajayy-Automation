package crossworld_test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import crossword_pom.CrossHomePage;

public class SearchForBookTest {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Logger log;
	public static Properties prop;

	@BeforeSuite
	public void startReport() {

		ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
		reporter.config().setReportName("Crossword Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
		reporter.config().setReportName("New Execution Report");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Environment", "QA");

		log = LogManager.getLogger(SearchForBookTest.class);
		log.info("===== Test Suite Started =====");
	}

	@BeforeClass
	public void setUp() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("src/main/resources/crosswordconfiguration.properties");
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Invalid browser name in config.properties");
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@Test
	public void searchForBook() throws InterruptedException {
		test = extent.createTest("Crossword search for Book Starts");
		CrossHomePage cross = new CrossHomePage(driver);
		log.info("Browser opened / url entered / driver get initialized ");
		cross.enterBookNameInSearchBar("Menifest");
		log.info("search product in search bar");
		cross.clickOnViewMoreOnSearch();
		log.info("click on view more button on search popup");

		cross.clickOnSortByDropDown();
		log.info("click on relavance filter");
		cross.clickOnLowToHightPrice();
		log.info("select filter Low to High price");
		test.pass("search For Book test pass");

	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
		log.info("===== Test Suite Finished =====");
	}
}
