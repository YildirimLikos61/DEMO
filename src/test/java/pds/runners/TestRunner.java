package pds.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions


        (
		
		   features="src/test/resources/feature/",
		   
		   glue="pds.steps",
		   
		   dryRun=true,
		   
		   tags="@",
		   
		   monochrome=true,
		   
		   plugin= 
	       {
	    		   "pretty",
               	
                   "html:target/cucumber-default-report.html",
					
					"json:target/cucumber.json",
					
					"rerun:target/failed.txt"
	    		   	   
	       }
		
		)

public class TestRunner {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
