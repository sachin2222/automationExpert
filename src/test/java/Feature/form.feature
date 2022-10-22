Feature: Fill form feature

  Scenario: Filling form data test
    Given user is on web page
    When title of the page is Protocommerce
    Then user enters form data
      | name   | email           | password    |
      | sachin | sachin@test.com | sachin@1234 |
      | kapil  | kapil@gmail.com | kapil1234   |

