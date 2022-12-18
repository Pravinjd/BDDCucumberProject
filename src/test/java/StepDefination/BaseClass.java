 package StepDefination;
 
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

//Parent class for all step defination files
public class BaseClass {
	
	
	//instanitiate WebDriver,
	public static WebDriver driver;
	
	//instantaite page objects Page:LoginPage,AddNewCutomerPage,SearchCustomerPage
	public LoginPage loginpg;
	public AddNewCustomerPage addNewCustomerpg;
	public SearchCustomerPage searchCustomerpg;
	
	//instantaite Logger class
	public static Logger log;     //to log informational messages
	
	//instantaite ReadConfig Class
	public ReadConfig readConfig; //to read properties file
	
	// generates unique emailId
	public String generateEmailId()
	{
		return RandomStringUtils.randomAlphabetic(5);
	}

}
