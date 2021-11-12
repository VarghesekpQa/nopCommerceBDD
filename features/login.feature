Feature: login
	@sanity
	Scenario: login with valid credential
		Given user launch chrome browser
		When user open url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
		And user enter email as "admin@yourstore.com" and password as "admin"
		And user click login button
		Then page title should be "Dashboard / nopCommerce administration"
		When user click logout url
		Then page title should be "Your store. Login"
		And close browser
	@regression
	Scenario Outline: login with data driven
		Given user launch chrome browser
		When user open url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
		And user enter email as "<email>" and password as "<password>"
		And user click login button
		Then page title should be "Dashboard / nopCommerce administration"
		When user click logout url
		Then page title should be "Your store. Login"
		And close browser 
		
	Examples:
		| email 			   | password |
		| admin@yourstore.com  | admin |	
		
		
	