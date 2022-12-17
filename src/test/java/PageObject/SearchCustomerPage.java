package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	WebDriver ldriver;

	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	// now find WebElements on this page

	@FindBy(id = "SearchEmail")
	WebElement emailAdd;

	@FindBy(id = "search-customers")
	WebElement searchBTn;

	@FindBy(xpath = "//table[@role='grid']")
	WebElement searchTable;

	@FindBy(xpath = "//table[@role='grid']//tbody/tr")
	List<WebElement> tableRows;

	// @FindBy(xpath="//table[@role='grid']//tbody/tr[1]/td")
	// List <WebElement> tableColumns;

	@FindBy(id = "SearchFirstName")
	WebElement firstName;

	@FindBy(id = "SearchLastName")
	WebElement lastName;

	public void enterEmailAdd(String email) {
		emailAdd.sendKeys(email);
	}

	public void clickOnSearchBtn() {
		searchBTn.click();
	}

	public boolean searchCustomerByEmail(String email) {
		boolean found = false;

		// total no of rows in table
		int ttlRows = tableRows.size();

		// total no of columns in table
		// int ttlColumns=tableColumns.size();

		for (int r = 1; r <= ttlRows; r++) 
		{
			WebElement usermails = ldriver.findElement(By.xpath("//table[@role='grid']//tbody/tr["+ r +"]/td[2]"));

			String actualmail = usermails.getText();

			if (actualmail.equals(email)) 
			{
				found = true;
				break;
			}

		}
		return found;
	}

	// **********************************search cutomer by name************************************************

	// action method to enter first name
	public void enterFirstName(String fName) {
		firstName.sendKeys(fName);
	}

	// action method to enter last name
	public void enterLastName(String lName) {
		lastName.sendKeys(lName);
	}

	public boolean searchCustomerByName(String name) { 
		boolean found = false;

		// tottal no of rows in table
		int ttlRows = tableRows.size();

		for (int r = 1; r <= ttlRows; r++) 
		{
			WebElement usernames = ldriver.findElement(By.xpath("//table[@role='grid']//tbody/tr[" + r + "]/td[3]"));

			String actualname = usernames.getText();

			if (actualname.equals(name)) 
			{
				found = true;
				break;
			}
		}
		return found;
	}

}
