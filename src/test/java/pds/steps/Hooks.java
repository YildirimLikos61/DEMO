package pds.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pds.testbase.BaseClass;
import pds.utility.CommonMethods;


public class Hooks extends BaseClass {

	
	
	
	@Before
	public static void open() throws InterruptedException 
	{
		setUp();
	}
	
	
	@After 
	public static void close(Scenario scenario) 
	{
		byte[] pics;
		
		if(scenario.isFailed()) 
		{
			pics=CommonMethods.takesScreenShot("Failed/"+scenario.getName());
		}else 
		{
			pics=CommonMethods.takesScreenShot("Passed/"+scenario.getName());
		}
		
		scenario.attach(pics, "image/png" , scenario.getName());
		
		tearDown();
	}
	
	
	
}
