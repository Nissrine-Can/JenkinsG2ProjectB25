package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class AdminLoginSteps extends CommonMethods {

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
        //  driver = new ChromeDriver();
        //  driver.get("http://54.198.61.50/web/index.php/auth/login");
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        openBrowserAndLaunchApplication();
    }

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        WebElement usernameField = driver.findElement(By.xpath("//*[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@name='password']"));

        //   usernameField.sendKeys(ConfigReader.read("userName"));
        //   passwordField.sendKeys(ConfigReader.read("password"));

        sendText(ConfigReader.read("userName"),loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        //   WebElement loginButton = driver.findElement(By.xpath("//*[@type='submit']"));
        //   loginButton.click();
        click(loginPage.loginButton);

    }

    @Then("user is able to login successfully")
    public void user_is_able_to_login_successfully() {

        //using assertion to verify that the user is logged in successfully
        //we can verify it by checking the presence of welcome message on the dashboard page
        Assert.assertTrue(dashboardPage.welcomeScreenLoc.isDisplayed());
        System.out.println("Test passed");
    }

    @When("user enters invalid admin username and password")
    public void user_enters_invalid_admin_username_and_password() {
        //   WebElement usernameField = driver.findElement(By.xpath("//*[@name='username']"));
        //   WebElement passwordField = driver.findElement(By.xpath("//*[@name='password']"));

        // usernameField.sendKeys("hrm_user3245");
        //    passwordField.sendKeys("Hrm_user@1232334");

        sendText("test",loginPage.usernameField);
        sendText("testtest", loginPage.passwordField);
    }

    @Then("user is able to see error message")
    public void user_is_able_to_see_error_message() {
        //using assertion to verify that the error message is displayed and correct
        String actualText =  loginPage.errorMessageLoc.getText();
        Assert.assertEquals("Invalid credentials", actualText);
        System.out.println("error message appeared");
    }



}