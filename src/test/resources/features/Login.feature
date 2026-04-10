Feature: Login Error Validation

  As a system user
  I want to log in with valid and invalid credentials
  So that I can validate login functionality

  @login @smoke @positive
  Scenario: Login with valid credentials
    Given user is on the login page
    When user enters a valid username and password
    Then user is successfully navigated to the dashboard


  @login @negative
  Scenario: Correct username and wrong password
    Given user is on the login page
    When user enters valid username and wrong password
    Then error message "Invalid credentials" should be displayed


  @login @negative
  Scenario: Correct username and empty password
    Given user is on the login page
    When user enters a correct username and empty password
    Then error message "Required" should be displayed


  @login @negative
  Scenario: Empty username and valid password
    Given user is on the login page
    When user enters empty username and valid password
    Then error message "Required" should be displayed


  @login @negative @regression
  Scenario: Empty username and empty password
    Given user is on the login page
    When user enters empty username and empty password
    Then multiple required error messages should be displayed