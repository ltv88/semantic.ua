package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class ApiHelper {

    public ApiHelper(){}

    public ValidatableResponse goToBaseUrl(String path) {
        return RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .basePath(path)
                .contentType(ContentType.JSON)
                .get()
                .then();
    }

}
