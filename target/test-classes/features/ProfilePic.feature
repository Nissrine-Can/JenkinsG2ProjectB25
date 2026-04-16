Feature: Verify ESS user can upload profile pic
  Background: common steps
    When user enters valid admin username and password
    And user clicks on login button
    Then user is able to login successfully
    And the user navigates to "MY info" page

  @regression1 @prachi
  Scenario: Upload valid profile picture
    When the user clicks on "Choose Profile Picture"
    And the user selects a valid image file "employee-image.jpg"
    And the user clicks on "Save"
    Then the profile picture should be uploaded successfully
    And the uploaded image should be displayed on the profile.

  @prachi
  Scenario: Upload invalid profile picture
    When the user selects a file "document.pdf"
    And the user clicks on "Save"
    Then an error message "File type not allowed" should be displayed.