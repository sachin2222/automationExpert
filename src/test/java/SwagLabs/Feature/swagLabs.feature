Feature: SwagLabs Application functional Test


  @Login
  Scenario Outline: Login Test
    Given user is on swagLabs Login Web Page
    When user enters "<username>" and "<password>"
    Then user clicks on Login Button
    Then user is navigated to Home page of swagLabs Application

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @Cart
  Scenario: Add to Cart functionality Test
    Given user is already on Home page of the Application
    When user clicks on the Add to Cart Button of the Required Product
    Then User will navigate to Add to cart Option
    Then user clicks on Checkout
    Then user enters Firstname , Lastname and Pincode
      | firstname | lastname | pincode |
      | sachin    | sharma   | 110044  |
    Then use clicks on continue button and Finish
    Then user will see Required message on screen
      | message                  |
      | THANK YOU FOR YOUR ORDER |



