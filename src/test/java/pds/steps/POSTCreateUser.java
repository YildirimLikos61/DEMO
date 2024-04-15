package pds.steps;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTCreateUser {

	
	
	@Test
	public void createUserTest() 
	{
		RestAssured.baseURI = "https://bookstore.toolsqa.com";
		
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		String payload = "{\r\n" 
		+ "  \"userName\": \"Yildirim_61\",\r\n" 
		+ "  \"password\": \"LetsDoIt@1\"\r\n" 
		+ "}";
		
		request.body(payload);

		Response response = request.when().post("/Account/v1/User");
		
		System.out.println("status code:" + response.statusCode());

		response.prettyPrint();
		
		Assert.assertEquals(201,response.getStatusCode());
		
		
	}
	
	
	
	
}
