Feature:Green Kart Features Test

  Background:
    Given user is on Green kart Home Page

  @Search
  Scenario: Search vegetable test
    Then user enters veggie name in search field
    Then user clicks on search button

  @Deal
  Scenario: Top Deals Test
    Then User clicks on Top Deals link.