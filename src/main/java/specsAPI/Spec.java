package specsAPI;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utility.ConfigReader;

public class Spec {

	public static RequestSpecification getRequestSpec() {

		return new RequestSpecBuilder().setContentType(ConfigReader.getProperty("contentType")).build();
	}

}
