package pds.steps;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pds.utility.APIConstants;

public class DELETE_AllBooks {

	
	
	@Test
	public void deleteAllTheBooks() 
	{
		
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		RequestSpecification request=RestAssured.given();
		
		request.auth().oauth2(APIConstants.token);
		
		request.queryParam("UserId", APIConstants.userId);
		
		Response response =request.when().delete(APIConstants.DELETE_ALL_BOOKS_ENDPOINT);
		
		response.prettyPrint();
		
		response.then().assertThat().statusCode(204);
		
	}
	
	
	
	
	
	
}
