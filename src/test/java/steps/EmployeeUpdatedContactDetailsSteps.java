package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ContactDetailsPage;
import utils.CommonMethods;
import utils.DBUtils;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class EmployeeUpdatedContactDetailsSteps extends CommonMethods {

    String Street1FE;
    String Street2FE;
    String CityFE;
    String StateFE;
    String ZipFE;
    String CountryFE;
    String HomeFE;
    String MobileFE;
    String WorkFE;
    String WorkEmailFE;
    String OtherEmailFE;

    @Given("the employee is logged into the HRMS application using valid ESS user credentials")
    public void the_employee_is_logged_into_the_hrms_application_using_valid_ess_user_credentials() {
        driver.get("https://www.syntaxhrm.com/web/index.php/auth/login");
        sendText("arundhati123", loginPage.usernameField);
        sendText("Arundhati@22", loginPage.passwordField);
        click(loginPage.loginButton);
        System.out.println("welcome screen displayed: Arundhati Sahoo");
        String actualText = dashboardPage.welcomeScreenLoc.getText();
        Assert.assertEquals("Arundhati Sahoo", actualText);
    }

    @Given("the employee navigates to the {string} and {string} section")
    public void the_employee_navigates_to_the_and_section(String string, String string2) {
        click(dashboardPage.myInfoField);
        waitForElementToBeClickAble(dashboardPage.contactDetailsField);
        click(dashboardPage.contactDetailsField);

    }

    @Then("the employee should see editable fields for contact information:")
    public void the_employee_should_see_editable_fields_for_contact_information(DataTable dataTable) {

        Assert.assertTrue(contactDetailsPage.cityField.isDisplayed());
        Assert.assertTrue(contactDetailsPage.stateField.isDisplayed());
        Assert.assertTrue(contactDetailsPage.zipField.isDisplayed());
        Assert.assertTrue(contactDetailsPage.countryDField.isDisplayed());
        Assert.assertTrue(contactDetailsPage.homeTField.isDisplayed());
        Assert.assertTrue(contactDetailsPage.mobileField.isDisplayed());
        Assert.assertTrue(contactDetailsPage.workField.isDisplayed());
        Assert.assertTrue(contactDetailsPage.workEmailField.isDisplayed());
        Assert.assertTrue(contactDetailsPage.otherEmailField.isDisplayed());
    }

    @When("the employee updates the following contact details:")
    public void the_employee_updates_the_following_contact_details(DataTable dataTable) throws InterruptedException {
        var data = dataTable.asMap();
        Thread.sleep(2000);
        sendText((data.get("Street 1")), contactDetailsPage.street1Field);
        Thread.sleep(2000);
        sendText((data.get("Street 2")), contactDetailsPage.street2Field);
        sendText((data.get("City")), contactDetailsPage.cityField);
        sendText((data.get("State")), contactDetailsPage.stateField);
        Thread.sleep(2000);
        contactDetailsPage.zipField.clear();
        sendText((data.get("Zip Code")), contactDetailsPage.zipField);
        // selectFromDropDown( contactDetailsPage.countryField,(data.get("Country")));
        // new Select(driver.findElement(By.xpath("//*[@class='oxd-select-text oxd-select-text--active']"))).selectByVisibleText(data.get("Country"));
        // sendText((data.get("Country")), contactDetailsPage.countryField);
        // driver.findElement(By.xpath("//*[@class='oxd-select-text oxd-select-text--active']")).click();
        contactDetailsPage.countryDField.click();

        List<WebElement> options = driver.findElements(By.xpath("//div[@class='oxd-select-text-input']"));
        for (WebElement option : options) {
            String optionText = option.getText();
            if (optionText.equals("United States")) {
                option.click();
            }
        }
        // driver.findElement(By.xpath("//*[text()='United States']")).click();
        sendText((data.get("Home Phone")), contactDetailsPage.homeTField);
        sendText((data.get("Mobile Phone")), contactDetailsPage.mobileField);
        sendText((data.get("Work Phone")), contactDetailsPage.workField);
        sendText((data.get("Work Email")), contactDetailsPage.workEmailField);
        sendText((data.get("Other Email")), contactDetailsPage.otherEmailField);

        Street1FE = (data.get("Street 1"));
        Street2FE = (data.get("Street 2"));
        CityFE = (data.get("City"));
        StateFE = (data.get("State"));
        ZipFE = (data.get("Zip Code"));
        CountryFE = (data.get("Country"));
        HomeFE = (data.get("Home Phone"));
        MobileFE = (data.get("Mobile Phone"));
        WorkFE = (data.get("Work Phone"));
        WorkEmailFE = (data.get("Work Email"));
        OtherEmailFE = (data.get("Other Email"));

    }

    @When("clicks on the {string} button")
    public void clicks_on_the_button(String string) throws InterruptedException {
        click(contactDetailsPage.saveButton);
        Thread.sleep(2000);
    }

    @Then("a success message should be displayed")
    public void a_success_message_should_be_displayed() throws InterruptedException {
        System.out.println("Success message displayed");

        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-toast')]")) );
       String message = toast.getText();
       System.out.println("Toast message: " + message);

        Assert.assertTrue(message.contains("Success"));



        //driver.findElement(By.cssSelector(".oxd-toast-container"));
        String actualMessage = toast.getText();
        // String expectedMessage = "Success\nSuccessfully Updated\n";
        Assert.assertTrue(actualMessage.contains("Successfully"));
        // Assert.assertEquals(actualMessage, expectedMessage);
        //  Assert.assertTrue(contactDetailsPage.successToastMessage.isDisplayed());
    }

    @When("logs out of the application")
    public void logs_out_of_the_application() {
        WebElement logOutDD = driver.findElement(By.xpath("//*[@class='oxd-userdropdown-tab']"));
        logOutDD.click();

        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='oxd-dropdown-menu']/li/a"));
        for (WebElement option : options) {
            String optionText = option.getText();
            if (optionText.equals("Logout")) {
                option.click();
            }
        }
    }

    @When("logs back in")
    public void logs_back_in() throws InterruptedException {
        sendText("arundhati123", loginPage.usernameField);
        sendText("Arundhati@22", loginPage.passwordField);
        click(loginPage.loginButton);
    }

    @When("navigates to the {string} section")
    public void navigates_to_the_section(String s) throws InterruptedException {
        click(dashboardPage.myInfoField);
        waitForElementToBeClickAble(dashboardPage.contactDetailsField);
        click(dashboardPage.contactDetailsField);
        Thread.sleep(2000);
    }

    @Then("the previously updated contact details should be displayed")
    public void the_previously_updated_contact_details_should_be_displayed() throws InterruptedException {
        //  Assert.assertEquals("UpdatedCity", contactDetailsPage.getCity());
        System.out.println("the previously updated contact details should be displayed");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Thread.sleep(1000);
        Assert.assertEquals("272",contactDetailsPage.street1Field.getAttribute("value"));
        Assert.assertEquals("SteepleChase dr",contactDetailsPage.street2Field.getAttribute("value"));
        Assert.assertEquals("Exton",contactDetailsPage.cityField.getAttribute("value"));
        Assert.assertEquals("PA",contactDetailsPage.stateField.getAttribute("value"));
        Assert.assertEquals("123345",contactDetailsPage.zipField.getAttribute("value"));
        String oldText = contactDetailsPage.countryDField.getText();
        System.out.println(oldText);
        wait.until(ExpectedConditions.textToBePresentInElement(contactDetailsPage.countryDField, oldText));

        String newText = contactDetailsPage.countryDField.getText();
        Assert.assertNotEquals(oldText, "Dropdown text did not change", newText);
        // Assert.assertEquals("United States",contactDetailsPage.homeTField.getText());
        Assert.assertEquals("1234556788",contactDetailsPage.homeTField.getAttribute("value"));
        Assert.assertEquals("3456723455",contactDetailsPage.mobileField.getAttribute("value"));
        Assert.assertEquals("6789023456",contactDetailsPage.workField.getAttribute("value"));
        Assert.assertEquals("arundhati@gmail.com",contactDetailsPage.workEmailField.getAttribute("value"));
        Assert.assertEquals("arundhatiwork@gmail.com",contactDetailsPage.otherEmailField.getAttribute("value"));
        //Database testing for validation
        String query = "select * from hs_hr_employee where emp_firstname ='Arundhati' and emp_lastname='Sahoo' and employee_id ='ABC'";

        List<Map<String,String>> data = DBUtils.fetch(query);
        String Street1FB = data.get(0).get("emp_street1");
        String Street2FB = data.get(0).get("emp_street2");
        String CityFB = data.get(0).get("city_code");
        String StateFB = data.get(0).get("provin_code");
        String ZipFB = data.get(0).get("emp_zipcode");
        String CountryFB = data.get(0).get("coun_code");
        String HomeFB = data.get(0).get("emp_hm_telephone");
        String MobileFB = data.get(0).get("emp_mobile");
        String WorkFB = data.get(0).get("emp_work_telephone");
        String WorkEmailFB = data.get(0).get("emp_work_email");
        String OtherEmailFB = data.get(0).get("emp_oth_email");

        Assert.assertEquals(Street1FE,Street1FB);
        Assert.assertEquals(Street2FE,Street2FB);
        Assert.assertEquals(CityFE,CityFB);
        Assert.assertEquals(StateFE,StateFB);
        Assert.assertEquals(ZipFE,ZipFB);
        //   Assert.assertEquals(CountryFE,CountryFB);
        Assert.assertEquals(HomeFE,HomeFB);
        Assert.assertEquals(MobileFE,MobileFB);
        Assert.assertEquals(WorkFE,WorkFB);
        Assert.assertEquals(WorkEmailFE,WorkEmailFB);
        Assert.assertEquals(OtherEmailFE,OtherEmailFB);

    }

    @When("the employee enters an invalid email format in {string} or {string}")
    public void the_employee_enters_an_invalid_email_format_in_or(String we, String oe) {
        sendText(we, contactDetailsPage.workEmailField);
        sendText(oe, contactDetailsPage.otherEmailField);
    }

    @Then("the system should display an email format validation error")
    public void the_system_should_display_an_email_format_validation_error() throws InterruptedException {
        // WebElement emailErrorMsg = driver.findElement(By.xpath("//*[text()='Expected format: admin@example.com']"));
        String emailErrText = ContactDetailsPage.emailErrorMsg.getText();
        // Assert.assertTrue(emailErrText.contains("@"));
        Thread.sleep(1000);
        Assert.assertEquals("Expected format: admin@example.com",emailErrText);
        // Assert.assertTrue("Expected format: admin@example.com",contactDetailsPage.emailErrorMsg.isDisplayed());
    }

    @When("the employee enters an invalid phone number in {string} or {string} or {string}")
    public void the_employee_enters_an_invalid_phone_number_in_or_or(String hp, String mp, String wp) {
        sendText(hp, contactDetailsPage.homeTField);
        sendText(wp, contactDetailsPage.workField);
        sendText(wp, contactDetailsPage.workField);
    }

    @Then("the system should display an phone number validation error")
    public void the_system_should_display_an_phone_number_validation_error() throws InterruptedException {
        Thread.sleep(1000);
        // WebElement phoneErMsg= driver.findElement(By.xpath("//span[text()='Allows numbers and only + - / ( )']"));
        String phoneErrText = contactDetailsPage.phoneErMsg.getText();
        Assert.assertEquals("Allows numbers and only + - / ( )",phoneErrText);
        // Assert.assertTrue(phoneErrText.contains("numbers"));
    }


}
