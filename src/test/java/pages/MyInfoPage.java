package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfoPage {

    static WebDriver driver;

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    // ================= LOCATORS =================

    // Profile image (clickable)
    private By profileImage = By.xpath("//img[@alt='profile picture']");

    // Upload input (hidden input type=file)
    private By uploadInput = By.xpath("//input[@type='file']");

    // Save button
    private By saveButton = By.xpath("//button[@type='submit']");

    // Success message
    private By successMessage = By.xpath("//button[@type='submit']");


    // Error message
    private By errorMessage = By.xpath("//div[@class='oxd-file-div oxd-file-div--active oxd-file-div--error']");

    // ================= ACTION METHODS =================

    public void clickProfileImage() throws InterruptedException {
        driver.findElement(By.xpath("//img[contains(@src,'viewPhoto')]")).click();
        Thread.sleep(4000);
    }

//    public void uploadFile(String filePath) {
//        driver.findElement(uploadInput).sendKeys("C:\\Users\\18479\\OneDrive\\Desktop\\Prachi final project code\\testdata\\employee-image.jpg");
//    }
    public void uploadFile(String fileName) {

        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/testdata/"
                + fileName;

        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(filePath);
    }

    public static WebElement clickSave() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        return null;
    }

    public String getSuccessMessage() {
        return driver.findElement(By.xpath("//button[@type='submit']")).getText();
    }


    public static String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.<WebElement>until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'oxd-input-field-error-message')]")));

        return error.getText();
    }

    public boolean isProfileImageDisplayed() {
        return driver.findElement(profileImage).isDisplayed();
    }
}
