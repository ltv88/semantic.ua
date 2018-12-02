package apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void apiTest(){
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200)
                .body("id", Matchers.hasItem(9))
                .extract().response().prettyPrint();


        RestAssured.given()
                .contentType(ContentType.JSON)
                .get("https://jsonplaceholder.typicode.com/users?id=9")
                .then()
                .statusCode(200)
                .body("company.name", Matchers.contains(("Yost and Sons")))
                .extract().response().prettyPrint();
    }
}
