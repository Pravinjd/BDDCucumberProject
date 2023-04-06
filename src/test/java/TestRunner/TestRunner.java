package TestRunner;

import org.testng.annotations.DataProvider;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
		
		

		features = {".//Features/"} ,
		
		//if u want to run all Stepdef files in a folder
		glue= "StepDefination" ,	
		dryRun = false ,
		monochrome = false ,
		tags="@sanity",
		
		
		//html report plugin
		//plugin = {"pretty","html:target/cucumber-reports/103testng.html"}
		
		//extent report plugin
		plugin={"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"
				}
		)


public class TestRunner extends AbstractTestNGCucumberTests {
	
 /*this is class will be empty always*/
	
//	@Override
//	@DataProvider(parallel = true)
//	public Object [] [] scenarios()
//	{
//		return super.scenarios();
//	}


}
