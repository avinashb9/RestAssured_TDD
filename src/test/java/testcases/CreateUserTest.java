package testcases;

import static io.restassured.RestAssured.post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateUserTest {

    @Test
    public void testCreateUser(){

        RestAssured.baseURI="https://reqres.in/";
        Map<String,String> jsonBody = new HashMap<>();
        jsonBody.put("name","Avinash");
        jsonBody.put("job","Lead Software Engineer");

        RequestSpecification reqSpec = RestAssured.given().body(jsonBody);
        Response response = reqSpec.post("/api/users");
        int statusCode = response.statusCode();
        System.out.println(response.getBody().asPrettyString());
        assertEquals(statusCode,201);

    }
}
