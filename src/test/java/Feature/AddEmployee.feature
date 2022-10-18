Feature: Add Employee feature Test

  Scenario Outline: Login feature Test
    Given user is already on login page
    When user enter "<username>" and "<password>"
    And user clicks on login buttton
    Then user should login successfully if status of user is "<status>"


    Examples:
      | username | password | status |
      | Admin    | admin123 | valid  |


  Scenario Outline:Create a new Employee
    Given user is on home page of application
    When user clicks on add button
    Then user can fill "<Firstname>","<Middlename>" and "<Lastname>"
    Then user can enter "<EmployeeID>"
    Then user click on Save Button


    Examples:
      | Firstname | Middlename | Lastname  | EmployeeID |
      | sachin    | kumar      | sharma    | 12345      |
