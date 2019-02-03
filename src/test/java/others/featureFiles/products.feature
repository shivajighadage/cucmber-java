Feature: products

Scenario Outline: Validate promo code alert is visible when clicking on special product links
	Given user navigate to "<url>" website  
	When user click on "<button>" 
	Then user should be presented with a promo alert
	
	Examples:
	|                 url	 										 			|		button					|
	| http://webdriveruniversity.com/Page-Object-Model/products.html			| #container-special-offers     	|