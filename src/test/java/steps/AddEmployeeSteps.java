package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import pages.DashboardPage;
import utils.CommonMethods;
import utils.DBUtils;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;



public class AddEmployeeSteps extends CommonMethods {

    //  AddEmployeePage addEmployeePage = new AddEmployeePage();
    //  DashboardPage dashboardPage = new DashboardPage();

    @When("user clicks on PIM option")
    public void userClicksOnPIMOption() {

        click(dashboardPage.pimOption);
    }

    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        //  WebElement addEmpOption = driver.findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
        //  addEmpOption.click();
        click(dashboardPage.addEmpOption);
    }

    @When("user enters employee first name and last name")
    public void user_enters_employee_first_name_and_last_name() {
        // WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
        sendText("Nissrine", addEmployeePage.firstNameloc);
        // firstNameloc.sendKeys("sofia");
        //  WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));
        //  lastNameloc.sendKeys("rozhko");
        sendText("Canina", addEmployeePage.lastNameloc);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //WebElement saveButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        //saveButton.click();
        click(addEmployeePage.saveButton);

    }
    @Then("user is able to see employee added successfully")
    public void user_is_able_to_see_employee_added_successfully() {
        System.out.println("employee added succesfully");
    }

    @When("user enters employee {string} and {string} values")
    public void user_enters_employee_and_values(String firstname, String lastname) {
        //  WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
        //  firstNameloc.sendKeys(firstname);
        //  WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));
        //lastNameloc.sendKeys(lastname);
        sendText(firstname, addEmployeePage.firstNameloc);
        sendText(lastname, addEmployeePage.lastNameloc);
    }

    @When("user enters employee value {string} and {string} and {string}")
    public void user_enters_employee_value_and_and(String fn, String ln, String mn) {
        //  WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
        //  firstNameloc.sendKeys(fn);
        //  WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));
        //  lastNameloc.sendKeys(ln);
        //  WebElement middleNameloc = driver.findElement(By.xpath("//*[@name='middleName']"));
        //  lastNameloc.sendKeys(mn);
        sendText(fn, addEmployeePage.firstNameloc);
        sendText(ln, addEmployeePage.lastNameloc);
        sendText(mn, addEmployeePage.middleNameloc);
    }


    @When("user enters employee value for firstname , mmiddlename and lastname and save the employees")
    public void user_enters_employee_value_for_firstname_mmiddlename_and_lastname_and_save_the_employees
            (io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<Map<String , String>> employeeNames = dataTable.asMaps();
        for (Map<String, String> employee : employeeNames){
            //   WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
            //   firstNameloc.sendKeys(employee.get("firstname"));
            //   WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));
            //   lastNameloc.sendKeys(employee.get("lastname"));
            //   WebElement middleNameloc = driver.findElement(By.xpath("//*[@name='middleName']"));
            //   middleNameloc.sendKeys(employee.get("middlename"));
            sendText((employee.get("firstname")), addEmployeePage.firstNameloc);
            sendText((employee.get("lastname")), addEmployeePage.lastNameloc);
            sendText((employee.get("middlename")), addEmployeePage.middleNameloc);
            //  WebElement saveButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));

            Thread.sleep(1000);
            click(addEmployeePage.saveButton);
            //  saveButton.click();
            Thread.sleep(1000);
            //to get back to add employee page after saving the employee, we have to click add employee
            //  WebElement addEmpOption = driver.findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
            //  addEmpOption.click();
            click(dashboardPage.addEmpOption);
            Thread.sleep(2000);
        }
    }

    @When("user enters employee value for firstname , middlename and lastname using excel file and save the employees")
    public void user_enters_employee_value_for_firstname_middlename_and_lastname_using_excel_file_and_save_the_employees() throws InterruptedException, IOException {
        List<Map<String , String>> employeeNames = ExcelReader.read();
        for (Map<String, String> employee : employeeNames) {
            //   WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
            //  firstNameloc.sendKeys(employee.get("firstName"));
            // WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));
            // lastNameloc.sendKeys(employee.get("lastName"));
            // WebElement middleNameloc = driver.findElement(By.xpath("//*[@name='middleName']"));
            // middleNameloc.sendKeys(employee.get("middleName"));
            // WebElement saveButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
            sendText((employee.get("firstName")), addEmployeePage.firstNameloc);
            sendText((employee.get("lastName")), addEmployeePage.lastNameloc);
            sendText((employee.get("middleName")), addEmployeePage.middleNameloc);
            Thread.sleep(1000);
            //saveButton.click();
            click(addEmployeePage.saveButton);
            Thread.sleep(1000);
            //to get back to add employee page after saving the employee, we have to click add employee
            //  WebElement addEmpOption = driver.findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
            //  addEmpOption.click();
            click(dashboardPage.addEmpOption);
            Thread.sleep(2000);
        }
    }

    @And("employee {string} and {string} is present in the database")
    public void employee_is_present_in_the_database(String firstName, String lastName) {

        String query = "SELECT * FROM hs_hr_employee WHERE emp_firstname='" + firstName +
                "' AND emp_lastname='" + lastName + "'";

        List<Map<String, String>> data = DBUtils.fetch(query);

        if (data.isEmpty()) {
            throw new AssertionError("Employee was not found in the database");
        }

        System.out.println("Employee found in database");

    }


}

