package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    //here we will create objects of the web elements and methods related to add employee page

    @FindBy(xpath = "//*[@name='firstName']")
    public WebElement firstNameloc;

    @FindBy(xpath = "//*[@name='lastName']")
    public WebElement lastNameloc;

    @FindBy(xpath = "//*[@name='middleName']")
    public WebElement middleNameloc;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement saveButton;

    public AddEmployeePage() {
        //the code we write will be automatically called when you create an object
        //page factory we use to initialise all the elements we use from selenium and the driver is coming from cm
        PageFactory.initElements(driver, this);
    }
}
