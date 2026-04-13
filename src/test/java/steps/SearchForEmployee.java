package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.EmployeeListPage;
import utils.CommonMethods;

public class SearchForEmployee extends CommonMethods {

    @When("userClicksOnPIMOptionForEmployeeSearch")
    public void userclicksonpimoptionforemployeesearch() {
        click(EmployeeListPage.pimOption);
    }

    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
        click(EmployeeListPage.employeeListOption);
    }

    @When("user enters valid FullName")
    public void user_enters_valid_full_name() {
        sendText("Mirwais Jafari", EmployeeListPage.employeeNameSearchBox);
    }

    @When("user enters valid EmployeeId")
    public void user_enters_valid_employee_id() {
        sendText("1199", EmployeeListPage.employeeIdSearchBox);
    }

    @When("user enters invalid employee")
    public void user_enters_invalid_employee() {
        sendText("AhmadXYZ123", EmployeeListPage.employeeNameSearchBox);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        click(EmployeeListPage.searchButton);
    }

    @Then("User is able to see all matching records")
    public void user_is_able_to_see_all_matching_records() {
        Assert.assertTrue("No matching records found",
                EmployeeListPage.resultRows.size() > 0);
    }

    @Then("User can see error message")
    public void user_can_see_error_message() {

        waitForVisibility(EmployeeListPage.noRecordsFoundMessage);

        Assert.assertTrue("Message not displayed",
                EmployeeListPage.noRecordsFoundMessage.isDisplayed());

        Assert.assertEquals("No Records Found",
                EmployeeListPage.noRecordsFoundMessage.getText());
    }


}
