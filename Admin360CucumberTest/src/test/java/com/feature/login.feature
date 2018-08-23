	Feature: Admin360 Test
	
	Scenario: Admin360 Login
	
	Given url opened
	
	Then click Login
	
	Then enter user id and click continue
	
	Then enter password
	
	And click login
	
	Scenario: Gmail Close
	
	Then Close browser 