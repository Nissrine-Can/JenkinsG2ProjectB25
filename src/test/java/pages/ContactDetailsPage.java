package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ContactDetailsPage extends CommonMethods {

    @FindBy(xpath = "//label[text()='Street 1']/following::input[1]")
    public WebElement street1Field;

    @FindBy(xpath = "//label[text()='Street 2']/following::input[1]")
    public WebElement street2Field;

    @FindBy(xpath = "//label[text()='City']/following::input[1]")
    public WebElement cityField;

    @FindBy(xpath = "//label[text()='State/Province']/following::input[1]")
    public WebElement stateField;

    @FindBy(xpath = "//label[text()='Zip/Postal Code']/following::input[1]")
    public WebElement zipField;

    @FindBy(xpath = "//label[text()='Home']/following::input[1]")
    public WebElement homeTField;

    @FindBy(xpath = "//label[text()='Mobile']/following::input[1]")
    public WebElement mobileField;

    @FindBy(xpath = "//label[text()='Work']/following::input[1]")
    public WebElement workField;

    @FindBy(xpath = "//label[text()='Work Email']/following::input[1]")
    public WebElement workEmailField;

    @FindBy(xpath = "//label[text()='Other Email']/following::input[1]")
    public WebElement otherEmailField;
    // //div[@class='oxd-select-text oxd-select-text--active']
    @FindBy(xpath ="//*[@class='oxd-select-text oxd-select-text--active']")
    public WebElement countryDField;
    //oxd-select-text-input
    @FindBy(xpath = "//button[text()=' Save ']")
    public WebElement saveButton;

    // @FindBy(id = "//*[@id='oxd-toaster_1']")
    @FindBy(css =".oxd-toast-container")
    public WebElement successToastMessage;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logOutButton;

    // @FindBy(xpath = "//*[text()='Allows numbers and only + - / ( )']")
    @FindBy(xpath ="//span[text()='Allows numbers and only + - / ( )']")
    public WebElement phoneErMsg;

    @FindBy(xpath = "//*[text()='Should not exceed 25 characters']")
    public WebElement phoneErr2 ;

    @FindBy(xpath = "//*[text()='Expected format: admin@example.com']")
    public static WebElement emailErrorMsg ;

    public ContactDetailsPage(){
        PageFactory.initElements(driver,this);
    }


}
