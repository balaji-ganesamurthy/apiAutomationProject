package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class APIUtils {

    public static Response get(String endpoint) {

        return given()
                .when()
                .get(ConfigReader.getBaseUrl() + endpoint);
    }
    
    public static Response post(String endpoint, String requestBody) {

        return given()
                .body(requestBody)
                .when()
                .post(ConfigReader.getBaseUrl() + endpoint);
    }
    
    public static Response put(String endpoint, String requestBody) {

        return given()
                .body(requestBody)
                .when()
                .put(ConfigReader.getBaseUrl() + endpoint);
    }
    public static Response delete(String endpoint) {

        return given()
                .when()
                .delete(ConfigReader.getBaseUrl() + endpoint);
    }
}