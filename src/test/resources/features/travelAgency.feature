Feature: travelAgency testing

  Scenario: scenarioOne
    Given travelAgency *1 exists
      | name | description |
      | Test | forTest     |
    And tour *1 with travelAgency *1 exists
      | name | country | amount |
      | Test | Ukraine | 10     |
    And booking exists with tour *1
      | fullName | amountReservedPlaces |
      | fullName | 3                    |
    Then travelAgency is in database
      | name | description |
      | Test | forTest     |
    And tour is in database
      | name | country | amount |
      | Test | Ukraine | 7      |
