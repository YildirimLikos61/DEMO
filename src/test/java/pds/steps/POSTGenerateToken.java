package pds.steps;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTGenerateToken {

	
	
	
	
	@Test
	public void generateToken() 
	{
		RestAssured.baseURI = "https://bookstore.toolsqa.com";
		
		String payload = "{\r\n" 
				+ "  \"userName\": \"Yildirim_61\",\r\n" 
				+ "  \"password\": \"LetsDoIt@1\"\r\n" 
				+ "}";
		
		RequestSpecification request=RestAssured.given();	

		request.header("Content-Type", "application/json");
		
		request.body(payload);
		
        Response response =request.when().post("/Account/v1/GenerateToken");
		
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200);
		
		response.then().assertThat().body("result", Matchers.equalTo("User authorized successfully."));
		
		

	}
	
	
	
	
	
}
