package restAssured;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

import apibasepackage.APIBaseClass;
import specsAPI.Spec;

public class GetRequestTest extends APIBaseClass {

    @Test
    public void getPostById() {

       given()
       	.spec(Spec.getRequestSpec()).log().all()
        .when()
            .get()
        .then()
            .log().all()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("userId", notNullValue())
            .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
            .body("body", containsString("quia et suscipit"));
    }
}