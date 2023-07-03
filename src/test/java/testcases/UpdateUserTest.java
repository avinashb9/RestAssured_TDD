package testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class UpdateUserTest {

    @Test
    public void testUpdateUser(){
        RestAssured.baseURI = "https://reqres.in/";
        Map<String,String> jsonBody = new HashMap<>();
        jsonBody.put("name","Avinash");
        jsonBody.put("job","Lead Software Engineer");
        RequestSpecification reqSpec = RestAssured.given().body(jsonBody);

        Response response = reqSpec.put("/api/users/2");
        System.out.println(response.asPrettyString());
    }
}
