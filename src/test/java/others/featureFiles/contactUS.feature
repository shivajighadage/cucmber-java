Feature: Submit data to webdriveruniversity using contact us form

Scenario: Submit valid data to contact us form 
	Given I access to webdriveruniversity site 
	And I Enter valid firstname 
	And I enter valid lastname
	|Ghadage|Pawar|Pawar123|!@#$%|
	And I enter valid email address 
	And I enter comment  
	|Required Mouse|Call me for enquiry|This is just test message|
	When I click on submit button to save data
	Then The information should saved succesfully to contact us form.