package apibasepackage;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import utility.ConfigReader;

public class APIBaseClass {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = ConfigReader.getProperty("baseURI");
		RestAssured.basePath = ConfigReader.getProperty("basePath");
		// content type from here
	}

}
