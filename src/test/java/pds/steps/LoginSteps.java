package pds.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pds.utility.CommonMethods;

public class LoginSteps extends CommonMethods {

	@When("i entered first name")
	public void i_entered_first_name() 
	{
	    sendText(login.firstname,"Yildirim");
	    wait(1);
	}
	
	@When("i entered last name")
	public void i_entered_last_name() 
	{
	    sendText(login.lastname,"Likos");
	    wait(2);
	}
	
	@When("i entered email")
	public void i_entered_email() 
	{
	    sendText(login.email,"yildirim61likos@gmail.com");
	}
	
	@When("i click submit button")
	public void i_click_submit_button() 
	{
	    click(login.submit);
	    wait(3);
	    
	}
	
	@Then("i validate thank you word is displayed")
	public void i_validate_thank_you_word_is_displayed() 
	{
	    boolean isdisplayed=login.thankyou.isDisplayed();
		
	    Assert.assertTrue(isdisplayed);
	    wait(3);
	    
	}




}
