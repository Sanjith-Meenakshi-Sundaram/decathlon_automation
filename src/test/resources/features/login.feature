@Login
Feature: Login functionality on Decathlon website

  @Regression @Login
  Scenario: Invalid login with wrong credentials
    Given User is on Decathlon home page
    When User clicks on login button
    And User enters invalid username and password
    And User clicks on submit login
    Then User should see login error message
