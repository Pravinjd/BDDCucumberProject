Feature: Login

@sanity 
Scenario: Successful Login With Valid Credentials 
	
	Given User Launch Chrome Browser
	When  User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Logout link
	Then Page Title should be "Your store. Login"
	And close browser
	
@regression	
Scenario Outline:Successful Login With Valid Credentials using DDT 
	Given User Launch Chrome Browser
	When  User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "<email>" and Password as "<password>"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Logout link
	Then Page Title should be "Your store. Login"
	And close browser


Examples:
| email | password |
| admin@yourstore.com | admin | 
#| test@yourstore.com | admin |
