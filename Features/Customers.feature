Feature: Customers

Background: Steps common for all scenarios

Given User Launch Chrome Browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login 
Then User can view Dashboard
 
 
@regression
Scenario: Add new customer

When User clicks on customers menu
And  click on customers menu Item
And click on Add new button
Then User can view Add new customer Page
When User enter customer info
And click on Save buton
Then User can view confirmation message "The new customer has been added successfully."
And close browser

@regression
Scenario: Search Customer By Email

When User clicks on customers menu
And  click on customers menu Item
And Enter customer Email
When click on search button
Then User should found Email in the Search Table
And close browser


@regression @sanity
Scenario: Search Customer By FirstName & LastName

When User clicks on customers menu
And  click on customers menu Item
And Enter customer FirstName
And Enter customer LastName
When click on search button
Then User should found Name in the Search Table
And close browser
