package pds.steps;


import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pds.utility.APIConstants;

public class GetOneBookSteps {

	
	RequestSpecification request;
	Response response ;
	
	@Given("I provided URI")
	public void i_provided_uri() 
	{
		RestAssured.baseURI=APIConstants.BASE_URI;
	    request=RestAssured.given();
	}
	
	@Given("I provide the ISBN {string} as the querry parameters")
	public void i_provide_the_isbn_as_the_querry_parameters(String isbn)
    {
		request.queryParam("ISBN", isbn);
	}
	
	@When("I make a GET call to the Get one book endpoint")
	public void i_make_a_get_call_to_the_get_one_book_endpoint()
	{
	   
		response=request.when().get(APIConstants.GET_ONE_BOOK_ENDPOINT);
		response.prettyPeek();
	}
	
	@Then("I validate that status code is {int}")
	public void i_validate_that_status_code_is(Integer statuscode) 
	{
	    response.then().assertThat().statusCode(statuscode);
	}
	
	@Then("I validate taht the ISBN in the response body is {string}")
	public void i_validate_taht_the_isbn_in_the_response_body_is(String isbn) 
	{
		 response.then().assertThat().body("isbn", Matchers.equalTo(isbn));
	}

	
	
	
	
}
