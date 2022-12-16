package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver; 
	
	public LoginPage(WebDriver rDriver)  // constructor
	{
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	WebElement loginBtn;
	
	@FindBy(linkText = "Logout")
	WebElement logoutBtn;
	
	// to perfrom action on above webElements will create some methods
	
	public void enterEmail(String mail)
	{	
		email.clear();
		email.sendKeys(mail);
	}
	
	public void enterPassword(String pwd)
	{	
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginButton()
	{
		loginBtn.click();
	}
	
	public void clickOnlogoutButton()
	{
		logoutBtn.click();
	}
	
	
	
}
