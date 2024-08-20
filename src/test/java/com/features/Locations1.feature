Feature: User can work with the location details

Scenario: Verify adding a location
	Given Verify user can add a location using "BaseURL"
	When using resource "AddResource" and method as "post"
	Then status should be "OK" with status code as 200
	And get the value "place_id"

Scenario: Verify location can be fetched
	Given Verify user can be fetched using "place_id"
	When using resource "GetResource" and method as "get"
	Then status should be "OK" with status code as 200
	And get the value "name" and "address"
	
Scenario: Verify location details can be updated
	Given Verify user can update the location using "place_id" and address as "Tilakwadiee, Belgaum"
	When using resource "UpdateResource" and method as "put"
	Then status should be "OK" with status code as 200
	And response should be "Address successfully updated"

Scenario: Verify location can be fetched
	Given Verify user can be fetched using "place_id"
	When using resource "GetResource" and method as "get"
	Then status should be "OK" with status code as 200
	And get the value "name" and "address"	
	
Scenario: Verify location can be deleted
	Given Verify user delete the "place_id"
	When using resource "DeleteResource" and method as "post"
	Then status should be "OK" with status code as 200
	And the response status should be "OK"	
	
	
Scenario: Verify location can be fetched
	Given Verify user can be fetched using "place_id"
	When using resource "GetResource" and method as "get"
	Then status should be "Not Found" with status code as 404
	And the response status should be	