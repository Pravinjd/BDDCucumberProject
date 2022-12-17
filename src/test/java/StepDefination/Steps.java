package StepDefination;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.codehaus.plexus.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps extends BaseClass {

	@Before  //("@sanity")                 // io.cucumber.java
	public void setup1() throws Exception
	{	
		System.out.println(" sanity  setup1  executed ");

		//initialise ReadConfig()class to read data from config.properties
		readConfig = new ReadConfig();
		String browser=readConfig.getBrowser();

		//launch browser
		switch(browser.toLowerCase())
		{
		case  "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			break;

		case  "msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			break;

		case  "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			break;

		default:
			driver=null;
			break;
		}


		//create an object of logger class
		log = LogManager.getLogger("Steps");
		log.info("*******************Setup1 executed**************************");
	}

	/*
	@Before ("@regression")                 // io.cucumber.java
	public void setup2()
	{
		System.out.println("regression setup2  executed ");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.info(" user launch chrome browser");

	}	
	 */

	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {

		//initialize loginPage, AddNewCustomer Page,SearchCustomerPage
		loginpg          = new LoginPage(driver);   
		addNewCustomerpg = new AddNewCustomerPage(driver);
		searchCustomerpg = new SearchCustomerPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);
		log.info("Url opened");

	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {
		loginpg.enterEmail(emailadd);
		loginpg.enterPassword(password);

		log.info("email & password entered");

	}

	@When("Click on Login")
	public void click_on_login() {
		loginpg.clickOnLoginButton();

		log.info("clciked on login button");

	}

	//********************************************* logIN PAGE *****************************************************

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		String actualTitle = driver.getTitle();

		if(actualTitle.equals(expectedTitle))
		{
			log.warn("Test Passed: Login Feature: Page title matched");
			Assert.assertTrue(true);
		}
		else
		{
			log.warn("Test Failed: Login Feature: Page title is not matched");
			Assert.assertTrue(false);
		}


	}
	@When("User click on Logout link")
	public void user_click_on_logout_link() throws Exception {
		Thread.sleep(1500);
		loginpg.clickOnlogoutButton();
		log.info ("user clicked on logout link");


	}


	/*
	@Then("close browser")
	public void close_browser() {
		driver.close();
		driver.quit();
		log.info ("***********************browser closed************************");
	}
	 */	

	//**********************************  ADD NEW CUSTOMER PAGE ***************************************



	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle = addNewCustomerpg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true); // if both matches then tc will pass
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@When("User clicks on customers menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
		addNewCustomerpg.clickOnCustomersMenu();
		Thread.sleep(2000);
	}

	@When("click on customers menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		addNewCustomerpg.clickOnCustomersMenuItem();
		Thread.sleep(2000);

	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addNewCustomerpg.clickOnAddnew();
	}

	@Then("User can view Add new customer Page")
	public void user_can_view_add_new_customer_page() {

		String actualTitle = addNewCustomerpg.getPageTitle();
		String expectedTitle =	"Add a new customer / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true); // if both matches then tc will pass
		}
		else
		{
			Assert.assertTrue(false);
		}

	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		//addNewCustomerpg.enterEmail("test5@gmail.com");
		addNewCustomerpg.enterEmail(generateEmailId() + "@gmail.com" );
		addNewCustomerpg.enterPassword("test1");
		addNewCustomerpg.enterFirstName("Pravin1");
		addNewCustomerpg.enterLastName("Jadhav");
		addNewCustomerpg.enterGender("male");
		addNewCustomerpg.enterDob("6/13/1988");
		addNewCustomerpg.enterCompanyName("CodeStudio");
		addNewCustomerpg.enterAdminContent("ha ha ha");
		addNewCustomerpg.enterManagerOfVendor("Vendor 2");

	}

	@When("click on Save buton")
	public void click_on_save_buton() {
		addNewCustomerpg.clickOnSave();

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMessage) {

		String bodyTagText = driver.findElement(By.tagName("Body")).getText();

		if(bodyTagText.contains(expectedConfirmationMessage))
		{
			Assert.assertTrue(true);  //tc will pass
		}
		else
		{
			Assert.assertTrue(false);	// tc will fail
		}

	}

	//**********************Search Customer Page**********************************

	@When("Enter customer Email")
	public void enter_customer_email() {
		searchCustomerpg.enterEmailAdd("victoria_victoria@nopCommerce.com");
	}

	@When("click on search button")
	public void click_on_search_button() {
		searchCustomerpg.clickOnSearchBtn();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("User should found Email in the Search Table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail="victoria_victoria@nopCommerce.com";

		// Assert.assertTrue(searchCustomerpg.searchCustomerByEmail(expectedEmail)); we use this or we can use if else

		if (searchCustomerpg.searchCustomerByEmail(expectedEmail)==true )
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	//************************search customer by first name and last name******************


	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		searchCustomerpg.enterFirstName("Victoria ");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchCustomerpg.enterLastName("Terces");
	}

	@Then("User should found Name in the Search Table")
	public void user_should_found_name_in_the_search_table() {

		String expectedFnameLname="Victoria Terces";

		if (searchCustomerpg.searchCustomerByName(expectedFnameLname)==true )
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}

	}

	/* 

@After          //this method will get executed after teardown2  //io.cucumber.java
public void teardown (Scenario sc) throws IOException 
{	
	System.out.println(" tear down 1 method executed ");

	if(sc.isFailed()==true)
	{	
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy HH-mm-ss");

		//convert webdriver object to TakesScreenshot

		//String filewithpath="C:\\Users\\admin\\eclipse-workspace\\cucumber\\CucumberFramework\\Screenshots\\" + sdf.format(d) + "failedscrshot.png";
		String filewithpath=".\\Screenshots\\" + sdf.format(d) + " failed_SS.png";

		TakesScreenshot scrShot =(TakesScreenshot)driver;

		//call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		//move image file to new destination
		File DestFile=new File(filewithpath);

		//copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
}	

	 */


	@AfterStep 
	public void addScreenshot (Scenario scenario) 
	{
		if(scenario.isFailed())
		{ 
			final byte [] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);


			//attach image file report (data,media type, name of theattachment)
			scenario.attach(screenshot, "image/png", scenario.getName() ); 
		}

	}



	/*
@After (order=2)            //io.cucumber.java
public void teardown2()
{
	driver.quit();
	System.out.println(" tear down 2 method executed ");
}
	 */

	/*
@BeforeStep                    //io.cucumber.java
public void beforeStepMethodDemo()
{
	System.out.println("this is before step");
}
@AfterStep                    //io.cucumber.java
public void afterStepMethodDemo()
{
	System.out.println("this is after step");
}
	 */

}




