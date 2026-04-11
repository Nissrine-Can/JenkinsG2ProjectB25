package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

//import java.sql.Driver;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        // Navigate to the login page using the URL from config
        CommonMethods.getDriver().get(ConfigReader.read("url"));

        // Clear username and password fields if any text is already present
        if (!loginPage.usernameField.getText().isEmpty()) {
            loginPage.usernameField.clear();
        }

        if (!loginPage.passwordField.getText().isEmpty()) {
            loginPage.passwordField.clear();
        }
    }
    @When("user enters a valid username and password")
    public void user_enters_a_valid_username_and_password() {
        // Logic to type in username/password
        //LoginPage login = new LoginPage();
        // login.sendText(login.usernameField, ConfigReader.read("username"));
        loginPage.login(ConfigReader.read("username"), ConfigReader.read("Password"));
    }


    @Then("user is successfully navigated to the dashboard")
    public void user_is_successfully_navigated_to_the_dashboard() {
        // Logic to verify the dashboard is visible
        String title = CommonMethods.getDriver().getTitle();
        System.out.println("Page title: " + title);
        //assert title != null;
        Assert.assertTrue(title.contains("SyntaxHRM"));
        Assert.assertTrue(loginPage.userDropdown.isDisplayed());
        loginPage.logout();
        System.out.println("User logged out successfully");
    }
    @When("user enters valid username and wrong password")
    public void user_enters_valid_username_and_wrong_password() {
        loginPage.login(ConfigReader.read("username"), "wrong123");
    }


    @When("user enters a correct username and empty password")
    public void user_enters_correct_username_and_empty_password(){
        loginPage.login(ConfigReader.read("username"),"");
    }
    @When("user enters empty username and valid password")
    public void user_enters_empty_username_and_valid_password() {
        loginPage.login("", ConfigReader.read("password"));
    }

    @When("user enters empty username and empty password")
    public void user_enters_empty_username_and_empty_password() {
        loginPage.login("", "");
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String expected) {

        String actual;

        if (expected.equalsIgnoreCase("Invalid credentials")) {
            actual = loginPage.getInvalidCredentialsText();
        } else {
            actual = loginPage.getRequiredErrorText();
        }

        System.out.println("Expected:" + expected + "| Actual error: " + actual);
        Assert.assertEquals(expected, actual);
    }
    @Then("multiple required error messages should be displayed")
    public void multiple_required_error_messages_should_be_displayed() {
        for (int i = 0; i < loginPage.errorMessages.size(); i++) {
            String actual = loginPage.errorMessages.get(i).getText().trim();
            System.out.println("Error " + (i + 1) + ": " + actual);
            Assert.assertEquals("Required", actual);
        }
    }

    @Then("user remains on login page")
    public void user_remains_on_login_page() {
        // Verify login button is still visible (means user is still on login page)
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}

