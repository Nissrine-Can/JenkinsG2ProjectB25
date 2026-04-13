Feature: user story for Search for an Employee in the HRMS application

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then user is able to login successfully
    When userClicksOnPIMOptionForEmployeeSearch
    And user clicks on employee list option

  @search @smoke @regression @positive @mirwais
  Scenario: Search by employee FullName
    When user enters valid FullName
    And user clicks on search button
    Then User is able to see all matching records

  @search @regression @positive @mirwais
  Scenario: Search by employee ID
    When user enters valid EmployeeId
    And user clicks on search button
    Then User is able to see all matching records

  @search @regression @negative @mirwais
  Scenario: Search invalid employee
    When user enters invalid employee
    And user clicks on search button
    Then  User can see error message