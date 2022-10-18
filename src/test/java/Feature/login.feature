Feature: OrangeHRM login Feature

  Scenario Outline: Login feature Test
    Given user is already on login page
    When user enter "<username>" and "<password>"
    And user clicks on login buttton
    Then user should login successfully if status of user is "<status>"


    Examples:
      | username | password  | status  |
      | Admin    | admin123  | valid   |
      | sachin   | sachin123 | invalid |









