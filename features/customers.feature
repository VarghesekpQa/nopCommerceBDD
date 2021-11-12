Feature: customers

 	Background: below are the common steps for every scenario
 
 		Given user launch chrome browser
		When user open url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
		And user enter email as "admin@yourstore.com" and password as "admin"
		And user click login button
		Then user can view dashboard
	@sanity
	Scenario: add new customer
		
		When user click customers menu
		And click on customers menu item
		And click on add new button
		Then user can view add new customer page
		When user enter customer info
		And user click on save button
		Then user can view confirmation message "The new customer has been addded successfully."
		And close the browser
		
	@regression	
	Scenario: search customer by email
		
		When user click customers menu
		And click on customers menu item
		And user enter customer email
		When user click on search button
		Then user should found email in search table
		And close the browser
	
	@regression
	Scenario: search customer by name
		
		When user click customers menu
		And click on customers menu item
		And user enter firstname and lastname
		When user click on search button
		Then user should found name in search table
		And close the browser