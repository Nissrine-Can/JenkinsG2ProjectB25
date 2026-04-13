package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class EmployeeListPage extends CommonMethods {

    @FindBy(xpath = "//span[text()='PIM']")
    public static WebElement pimOption;

    @FindBy(xpath = "//a[normalize-space()='Employee List']")
    public static WebElement employeeListOption;

    @FindBy(xpath = "//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public static WebElement employeeNameSearchBox;

    @FindBy(xpath = "//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public static WebElement employeeIdSearchBox;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    public static WebElement searchButton;

    @FindBy(xpath = "//div[@role='rowgroup']//div[@role='row']")
    public static List<WebElement> resultRows;

    @FindBy(xpath = "//div[contains(@class,'oxd-toast')]//*[normalize-space()='No Records Found']")
    public static WebElement noRecordsFoundMessage;

    public EmployeeListPage() {
        PageFactory.initElements(driver, this);
    }
}