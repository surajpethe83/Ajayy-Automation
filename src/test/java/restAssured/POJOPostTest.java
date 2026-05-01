package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojo.User;
import pojo.UserResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class POJOPostTest {

    @Test
    public void createUserUsingPOJO() {

        RestAssured.baseURI = "https://reqres.in";

        // Step 1: Creates POJO object
        User user = new User("Ajay", "QA Engineer");

        // Step 2: API call with headers + POJO body
        UserResponse response = //response stores API response data
            given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres_dfb885e240a04999a4bc1f4e85a450c7")
                .contentType(ContentType.JSON)
                .body(user)
            .when()
                .post("/api/users")
            .then()
                .statusCode(201)
                .extract()
                .as(UserResponse.class);

        // Step 3: Print response values
        System.out.println("ID: " + response.getId());
        System.out.println("Created At: " + response.getCreatedAt());

        // Step 4: Assertions (optional)
        assert response.getName().equals("Ajay");
        assert response.getJob().equals("QA Engineer");
    }
}