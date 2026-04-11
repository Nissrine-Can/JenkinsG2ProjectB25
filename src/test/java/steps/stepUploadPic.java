package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.awt.*;
import java.time.Duration;

public class stepUploadPic extends CommonMethods {

    @And("the user navigates to {string} page")
    public void user_navigates_to_page(String pageName) {

        if(pageName.equalsIgnoreCase("MY info")) {
            driver.get("https://www.syntaxhrm.com/web/index.php/pim/viewPersonalDetails/empNumber/1");
        }
    }

    @When("the user clicks on {string}")
    public void user_clicks_on_button(String buttonName) {

        if(buttonName.equalsIgnoreCase("Choose Profile Picture")) {

            WebElement chooseBtn = driver.findElement(
                    By.xpath("//img[@class='employee-image']")); // real input element//

            // No need to click actually, but keeping for step consistency
            chooseBtn.click();
        }

    }
    @And("the user selects a valid image file {string}")
    public void user_selects_valid_image(String fileName) throws InterruptedException {

        //WebElement upload = driver.findElement(By.xpath("//img[@src='/web/index.php/pim/viewPhoto/empNumber/1']"));
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + "employee-image" + ".jpg";
        Thread.sleep(5000);
        WebElement uploadInput = driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus']"));
        uploadInput.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//script[@type='text/javascript']")).sendKeys("/src/test/resources/testdata/employee-image.jpg");


    }
   /* @And("the user clicks on {string}")
    public void user_clicks_on_save(String buttonName) {

        if(buttonName.equalsIgnoreCase("Save")) {

            WebElement saveBtn = driver.findElement(
                    By.xpath("//button[@type='submit']")
            );

            saveBtn.click();
        }
    }*/

    @Then("the profile picture should be uploaded successfully")
    public void verify_upload_success() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'message success')]")));

        System.out.println("Upload Successful: " + successMsg.getText());
    }

    @And("the uploaded image should be displayed on the profile.")
    public void verify_uploaded_image_displayed() {

        WebElement profileImage = driver.findElement(
                By.xpath("//img[contains(@src,'viewPhoto')]")
        );

        if(profileImage.isDisplayed()) {
            System.out.println("Profile image displayed successfully");
        } else {
            throw new AssertionError("Profile image not displayed");
        }
    }

    @When("the user selects a file {string}")
    public void user_selects_invalid_file(String fileName) {

        WebElement upload = driver.findElement(By.xpath("//img[@src='/web/index.php/pim/viewPhoto/empNumber/1']"));


        String filePath = "C:\\Users\\18479\\OneDrive\\Desktop" + fileName + ".pdf";
        // example: document.pdf

        upload.sendKeys(filePath);
    }
    @Then("an error message {string} should be displayed")
    public void verify_error_message(String expectedMessage) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("<span data-v-7b563373=\"\" data-v-957b4417=\"\" class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\">Attachment Size Exceeded</span>")));

        String actualMessage = errorMsg.getText().trim();

        if(!actualMessage.contains(expectedMessage)) {
            throw new AssertionError("Expected: " + expectedMessage +
                    " but got: " + actualMessage);
        }

        System.out.println("Error message verified: " + actualMessage);
    }



}