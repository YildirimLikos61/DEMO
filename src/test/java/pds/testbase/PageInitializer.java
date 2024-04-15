package pds.testbase;

import pds.pages.LoginPage;

public class PageInitializer extends BaseClass{

	
	public static LoginPage login;
	
	
	public static void Initializer()
	{
		login =new LoginPage();
	}
	
	
	
}
