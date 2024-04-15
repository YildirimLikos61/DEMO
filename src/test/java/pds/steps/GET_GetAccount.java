package pds.steps;

import org.hamcrest.Matchers;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pds.utility.APIConstants;

public class GET_GetAccount {

	
	
	@Test
	public void getAccount() 
	{
		
		RestAssured.baseURI=APIConstants.BASE_URI;
		
		String token=APIConstants.token;
		
		RequestSpecification request=RestAssured.given();		
		
		request.auth().oauth2(token);
		
		request.pathParam("UserId",APIConstants.userId);
		
		Response response =request.when().get(APIConstants.GET_ACCOUNT_ENDPOINT);
		
		response.prettyPeek();
		
		response.then().assertThat().statusCode(200);
		
		response.then().assertThat().body("userId", Matchers.equalTo(APIConstants.userId));
		
		response.then().assertThat().body("username", Matchers.equalTo("Yildirim_61"));
		
		
	}
	
	
	
	
	
	
	
}
