Feature: User can work with the location details

Scenario: Verify adding a location
	Given Verify user can add a location using "BaseURL"
	When using resource "AddResource" and method as "post"
	Then status should be "OK" with status code as 200
	And get the value "place_id"
	
	Scenario: Verify location can be fetched
		Given 
		When 
		Then
		And 