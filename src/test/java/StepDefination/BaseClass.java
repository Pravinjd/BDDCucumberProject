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
	
	//create an object of Page:LoginPage,AddNewCutomerPage,SearchCustomerPage
	
	public static WebDriver driver;
	
	public LoginPage loginpg;
	public AddNewCustomerPage addNewCustomerpg;
	public SearchCustomerPage searchCustomerpg;
	
	public static Logger log;     //to log informational messages
	public ReadConfig readConfig; //to read properties file
	
	public String generateEmailId()
	{
		return RandomStringUtils.randomAlphabetic(5);
	}

}
