Feature: Update Employee Contact Details

  As an ESS user (employee)
  I want to edit my contact information in the HRMS application
  So that my contact details remain current and accurate

  Background:
    Given the employee is logged into the HRMS application using valid ESS user credentials
    And the employee navigates to the "My Info" and "Contact Details" section
  @test @dbTesting
  Scenario: View contact details form
    Then the employee should see editable fields for contact information:
      | Field Name        | Field Type |
      | Address Street 1  | Textbox    |
      | Address Street 2  | Textbox    |
      | City              | Textbox    |
      | State             | Textbox    |
      | Zip Code          | Textbox    |
      | Country           | Dropdown   |
      | Home Phone        | Textbox    |
      | Mobile Phone      | Textbox    |
      | Work Phone        | Textbox    |
      | Work Email        | Textbox    |
      | Other Email       | Textbox    |
  @contact @dbTesting
  Scenario: Successfully update contact details
    When the employee updates the following contact details:
      | Street 1         | 272           |
      | Street 2         | SteepleChase dr|
      | City             | Exton          |
      | State            | PA             |
      | Zip Code         | 123345         |
      | Country          | United States  |
      | Home Phone       | 12345          |
      | Mobile Phone     | 34567          |
      | Work Phone       | 67890          |
      | Work Email       | asdfg@gmail.com   |
      | Other Email      | cdzxc@gmail.com   |
    And clicks on the "Save" button
    Then a success message should be displayed

  @invalidPhone @dbTesting
  Scenario: Validate Phone number format
    When the employee enters an invalid phone number in "Home" or "Mobile" or "Work"
    Then the system should display an phone number validation error

  @invalidEmail @dbTesting
  Scenario: Validate email format
    When the employee enters an invalid email format in "Work Email" or "Other Email"
    And clicks on the "Save" button
    Then the system should display an email format validation error

  @dbTesting
  Scenario: Persist updated contact details
    When the employee updates the following contact details:
      | Street 1         | 272                       |
      | Street 2         | SteepleChase dr           |
      | City             | Exton                     |
      | State            | PA                        |
      | Zip Code         | 123345                    |
      | Country          | United States             |
      | Home Phone       | 1234556788                |
      | Mobile Phone     | 3456723455                |
      | Work Phone       | 6789023456                |
      | Work Email       | arundhati@gmail.com       |
      | Other Email      | arundhatiwork@gmail.com   |
    And clicks on the "Save" button
    And logs out of the application
    And logs back in
    And navigates to the "Contact Details" section
    Then the previously updated contact details should be displayed