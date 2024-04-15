package pds.utility;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GenerateTokenUtils {

	
	public static String token;
	
	@Given("a token is generated")
	public void generateToken() 
	{
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILE_PATH);
		
		String userName=ConfigsReader.getProperty("APIUserName");
		
		String password=ConfigsReader.getProperty("APIPassword");
		
		 String payload = "{\r\n"
		    		+ "  \"userName\": \""+userName+"\",\r\n"
		    		+ "  \"password\": \""+password+"\"\r\n"
		    		+ "}";
	
		 
		 RestAssured.baseURI=APIConstants.BASE_URI;
		 
		   token=RestAssured.given()
				   
				 .contentType(ContentType.JSON)
				 
				 .body(payload)
				 
				 .when().post(APIConstants.GENERATE_TOKEN_ENDPOINT)
				 
				 .body().jsonPath().getString("token");
		 
		 System.out.println(token);
		 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
