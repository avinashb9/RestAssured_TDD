package testcases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojos.User;

public class GetSingleUserTest {


    @Test
    public void testGetSingleUser() throws JsonProcessingException {
        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification reqSpec = RestAssured.given();
//        Response response = RestAssured.get("/api/users/2");
        Response response = reqSpec.get("/api/users/2");
        System.out.println(response.asPrettyString());
        System.out.println(response.jsonPath().getString("data.id"));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody().asString());
        User user1 = mapper.convertValue(root.get("data"), User.class);
        System.out.println(user1);
    }
}
