package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AdminLoginPage extends CommonMethods {

    @FindBy(xpath = "//*[@name='username']")
    public static WebElement usernameField;

    @FindBy(xpath = "//*[@name='password']")
    public static WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[text()='Invalid credentials']")
    public static WebElement errorMessageLoc;

    public AdminLoginPage(){
        PageFactory.initElements(driver,this);
    }
}
