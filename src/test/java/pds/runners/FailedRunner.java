package pds.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions
        

        (
		
		  features="@target/failed.txt",
		  glue="pds.steps"
		
		
		)



public class FailedRunner {

}
