Feature: User story for login scenarios

  Background:
    #Given user is able to access HRMS application

  @regression @smoke @sprint1
  Scenario: Valid admin login
    When user enters valid admin username and password
    And user clicks on login button
    Then user is able to login successfully

  @regression @sprint1
  Scenario: Invalid admin login
    When user enters invalid admin username and password
    And user clicks on login button
    Then user is able to see error message
