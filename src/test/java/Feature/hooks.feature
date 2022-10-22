Feature: Hooks feature of cucumber

  Scenario: Login Test
    Given user is on orange hrm live login page
    When user sees logo
    Then user captures screenshot of logo
    Then user close all the browser windows


  @Smoke
  Scenario: create test
    Given user has been created test


  @Sanity
  Scenario: Logout Test
    Given user has clicked on Logout
