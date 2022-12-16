package TestRunner;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		// if u want to run singgle feature file
		//features = ".//Features/Customers.feature" ,
		
		// if u want to run all feature files in feature folder
		//features = ".//Features/" ,
		
		// if u want to run multiple feature files of your choice
		features = {".//Features/Customers.feature", ".//Features/LoginFeature.feature",} ,
		
		//if u want to run all Stepdef files in a folder
		glue= "StepDefination" ,
		
		//if u want to run multple step defination files
		//glue={" .//StepDefination/steps1.java" ," .//StepDefination/steps2.java"} ,
		
		dryRun = false ,
		monochrome = true ,
		
		//if u want to run scenarios which are under sanity tag
		tags="@sanity",
		
		//plugin = {"pretty","html:target/cucumber-reports/102testng.html"}
		
		plugin={"com.aventstack.extentreoprts.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)


public class Runner extends AbstractTestNGCucumberTests {
	
 /*this is class will be empty always*/

	//plugin = {"pretty","html:target/cucumber-reports/report1.html"}
//plugin = {"pretty","json:target/cucumber-reports/jsonreport1.json"}


}
