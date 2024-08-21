Feature: Verifying the APIs for the Location

  @SanityTests
  Scenario: Verify the Get Location API
    Given Verify sending the get request "DummyDomainURL"
    When using "DummygetUserResource" and "get"
    Then status of the response should be 200
    And get the "users.id[1]"

##  @Regression
##	Scenario Outline: Verify the Create Location API
##    Given Verify adding "<name>" "<PhoneNumber>" "<Address>" details
##    When using "addResource" and "methodType"
##    Then status of the response should be "200"
##    And get the "place_id" and status as "OK"

##    Examples: 
##      | name                       | PhoneNumber | Address |
##      | Shantanu Vilas Karambalkar |  7030002992 | Mumbai  |
