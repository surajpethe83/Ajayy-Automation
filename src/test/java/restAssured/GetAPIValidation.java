package restAssured;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class GetAPIValidation {

	@Test
	public void getRequestValidation() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		given()
			.header("Content-Type", "application/json")
		.when()
			.get("/posts/1")
		.then()
			.statusCode(200)
			.body("id", equalTo(1))
			.body("userId", notNullValue())
			.body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
			.body("body", containsString("quia et suscipit"));
	
	}
	
}
