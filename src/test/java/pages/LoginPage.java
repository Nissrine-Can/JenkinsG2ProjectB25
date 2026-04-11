package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import java.util.List;


public class LoginPage extends CommonMethods {

    @FindBy(xpath = "//*[@name='username']")
    public WebElement usernameField;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[text()='Invalid credentials']")
    public WebElement invalidCredentialsMessage;

    @FindBy(xpath = "//span[contains(@class,'oxd-input-field-error-message')]")
    public List<WebElement> errorMessages;

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    public WebElement userDropdown;

    @FindBy(xpath = "//a[@href='/web/index.php/auth/logout']")
    public WebElement logoutBtn;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public void login(String username, String password) {
        usernameField.clear();
        usernameField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);

        loginButton.click();
    }
    public void enterusername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickLogin(){
        loginButton.click();
    }
    /*public String getErrorMessage(){
        return errorMessageLoc.getText();
    }*/
    public String getInvalidCredentialsText() {
        return invalidCredentialsMessage.getText().trim();
    }
    public String getRequiredErrorText() {
        if (!errorMessages.isEmpty()) {
            return errorMessages.get(0).getText().trim();
        }
        return "";
    }
    public List<String> getAllRequiredErrors() {
        return errorMessages.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList();
    }
    public void logout() {
        userDropdown.click();

        try {
            Thread.sleep(1000); // wait for dropdown
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logoutBtn.click();
    }
}
