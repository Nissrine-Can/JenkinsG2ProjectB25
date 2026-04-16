Feature: Add employee scenarios

  #all the common steps for all the scenarios will be written in the background section
  #the steps in the background section will be executed before each scenario
  #the steps in the background section will be executed in the order they are written
  #the background is different for every feature file

  Background:
   # Given user is able to access HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then user is able to login successfully
    When user clicks on PIM option
    And user clicks on add employee option

  @add @nissrine
  Scenario: Adding employee
    When user enters employee first name and last name
    And user clicks on save button
    Then user is able to see employee added successfully

  @param @db @regression @nissrine
  Scenario: Adding employee using parameters
    When user enters employee "Nissrine" and "Canina" values
    And user clicks on save button
    Then user is able to see employee added successfully
    And employee "Nissrine" and "Canina" is present in the database





  @examples @regression @nissrine
  Scenario Outline:  Adding multiple employees
    When user enters employee value "<firstname>" and "<lastname>" and "<middlename>"
    And user clicks on save button
    Then user is able to see employee added successfully
    Examples:
      | firstname | lastname | middlename |
      | roman     | Ali      | ms         |
      | kevin     | adams    | ms         |
      | hamit     | ahmed    | ms         |


  @datatable  @regression @nissrine
  Scenario: Adding employees using data table
    When user enters employee value for firstname , mmiddlename and lastname and save the employees
      | firstname | lastname | middlename |
      | Adam      | Ali      |     ms     |
      | Julia     | adams    |     ms     |
      | Rayan     | ahmed    |     ms     |


  @excel @regression @sprint1 @nissrine
  Scenario: Adding employees using excel file
    When user enters employee value for firstname , middlename and lastname using excel file and save the employees