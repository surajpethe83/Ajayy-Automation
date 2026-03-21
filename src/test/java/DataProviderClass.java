import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/* //Why we use Object instead of string?
	//Because testng dataprovider expect Object[][]. Object is the parent class of all the 
	//datatypes in java so it can hold string, boolean, double, integer..etc */

public class DataProviderClass {

	WebDriver driver;
	@Test (dataProvider= "loginData")
	public void accesslevellogintests(String username, String password) {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		driver.quit();
		}
	
	//We need to execute this testcase with three user levels..
	
	@DataProvider(name="loginData") //declaring our dataprovider name is "loginData"
	public Object[][] getData() { //Returns a 2 dimensional array of objects ie rows and columns
		//Object[no of tests][no of parameters]
	return new Object[][]{
		//new keyword here -> creates a new 2d array
		//Object[][] here declares it as a 2D object array
			{"standard_user","secret_sauce"}, //actual test data sets
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"}
		};
		
	}
}
