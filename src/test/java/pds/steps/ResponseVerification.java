package pds.steps;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseVerification {

	
	
	@Test
	public void verifyAllBooksRequest() 
	{
		RestAssured.baseURI="https://bookstore.toolsqa.com";
		
		RequestSpecification request=RestAssured.given();
		
		Response response=request.when().get("BookStore/v1/Books");
		
		response.prettyPeek();
		
		//verify the response code is 200
		
		response.then().assertThat().statusCode(200);
		
		//verify using JUnit 
		
		Assert.assertEquals(200, response.statusCode());
		
		//verify the content type in header
		
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
		
		Assert.assertEquals("application/json; charset=utf-8", response.header("Content-Type"));
		
	
		//check if body contains 
		String body=response.body().asString();
		
		Assert.assertTrue(body.contains("Learning JavaScript Design Patterns"));
		
		Assert.assertTrue(response.body().asString().contains("Learning JavaScript Design Patterns"));
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
