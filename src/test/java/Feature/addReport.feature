Feature: Add Report feature test by Data Tables

  Scenario: add report test
    Given user has  already on login page
    When user entered username and password
      | Admin | admin123 |
    Then user clicked on login button
    Then user has navigated to home page
    Then user navigated to Reports
    Then user clicked on add button
    Then user enters required reports Data