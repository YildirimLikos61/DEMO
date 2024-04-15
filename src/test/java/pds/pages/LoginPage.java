package pds.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pds.testbase.BaseClass;

public class LoginPage {

	
	@FindBy(xpath="//input[@name='firstName']")
	public WebElement firstname;
	
	
	@FindBy(xpath="//input[@placeholder='Last name*']")
	public WebElement lastname;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement email;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submit;
	
	@FindBy(xpath="//span[text()='Thank You!']")
	public WebElement thankyou;
	
	
	public LoginPage () 
	{
		PageFactory.initElements(BaseClass.driver,this);
	}
	
	
	
	
}
