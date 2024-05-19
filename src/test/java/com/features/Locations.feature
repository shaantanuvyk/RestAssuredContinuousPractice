Feature: Verifying the APIs for the Location

  @SanityTests
  Scenario Outline: Verify the Create Location API
    Given Verify adding "<name>" "<PhoneNumber>" "<Address>" details
    When using "addResource" and "methodType"
    And status of the response should be "200"
    And get the "place_id" and status as "OK"

    Examples: 
      | name                       | PhoneNumber | Address |
      | Shantanu Vilas Karambalkar |  7030002992 | Mumbai  |