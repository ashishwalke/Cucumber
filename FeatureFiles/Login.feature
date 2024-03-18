Feature: User Login 

Scenario: Successful Login 
	Given the user is on the nopCommerce login page 
	When the user enters valid credentials (username: "ashishwalke11@gmail.com" , password: "Ashish@11") 
	And the user clilck on the Login button 
	Then the user should be redirected to the My Account page 
	And the user should see a welcome msg 
	