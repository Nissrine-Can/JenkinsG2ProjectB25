package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.MyInfoPage;
import utils.CommonMethods;

import static pages.MyInfoPage.getErrorMessage;

public class stepUploadPic extends CommonMethods {

    // WebDriver driver = DriverFactory.getDriver();
    MyInfoPage myInfoPage = new MyInfoPage(driver);

    @Given("the user navigates to {string} page")
    public void navigate_to_my_info(String page) {
        driver.get("https://www.syntaxhrm.com/web/index.php/pim/viewPhotograph/empNumber/1");
    }

    @When("the user clicks on {string}")
    public void click_choose_profile_picture(String button) throws InterruptedException {
        Thread.sleep(3000);
        myInfoPage.clickProfileImage();

    }

    @When("the user selects a valid image file {string}")
    public void upload_valid_image(String fileName) {
        //String path = System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName;
        //myInfoPage.uploadFile("C:\\Users\18479\\OneDrive\\Desktop\\Prachi final project code\testdata\\employee-image.jpg");
        myInfoPage.uploadFile(fileName);
    }



    //@When("the user clicks on \"Save\"")
    //public void click_save() {
    // myInfoPage.clickSave();
    // }

    @Then("the profile picture should be uploaded successfully")
    public void verify_success_upload() throws InterruptedException {
        // Click Save
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Wait (better: use WebDriverWait)
        Thread.sleep(2000);

// Validate message

        WebElement msg = driver.findElement(By.xpath("//div[contains(@class,'oxd-toast--success')]"));
        String text = msg.getText();

        Assert.assertTrue("Success message not displayed",
                text.contains("Successfully Updated"));
        //Assert.assertTrue(msg.isDisplayed());
        // Assert.assertTrue(msg.getText().contains("Successfully updated"));


        //String actualText = myInfoPage.getSuccessMessage();
        //Assert.assertTrue(message.contains("Success /n successfully updated"));
        //Assert.assertTrue(actualText.replace("\n"," ")
        //.contains("Successfully updated"));
    }

    @Then("the uploaded image should be displayed")
    public void verify_image_displayed() {
        Assert.assertTrue(myInfoPage.isProfileImageDisplayed());
    }


    @When("the user selects a file {string}")
    public void upload_invalid_file(String fileName) {
        //String path = System.getProperty("user.dir") + "/testdata/" + fileName;
        myInfoPage.uploadFile(fileName);
    }
    //@When("the user clicks on \"Save\"")
    //public void click_save() {
    // MyInfoPage.clickSave();
    // }

    @Then("an error message {string} should be displayed")
    public void anerrormessageshouldbedisplayed(String expectedMsg) throws InterruptedException {
        Thread.sleep(2000);
        String actualMsg = getErrorMessage();
        Assert.assertEquals(actualMsg, "Error message mismatch!", expectedMsg);
    }


    /*@Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String string)  {
        String actualMessage = getErrorMessage();

        System.out.println("Actual Message: " + actualMessage);

        // Recommended (flexible assertion)
        CharSequence expectedMessage = "File type not allowed";
        Assert.assertTrue("Expected: " + expectedMessage + " but got: " + actualMessage,
                actualMessage.contains(expectedMessage));
    }*/

    @And("the uploaded image should be displayed on the profile.")
    public void theUploadedImageShouldBeDisplayedOnTheProfile() throws InterruptedException {
        Assert.assertTrue(myInfoPage.isProfileImageDisplayed());
        Thread.sleep(2000);

    }



    //@Then("an error message {string} should be displayed.")
    //public void anErrorMessageShouldBeDisplayed(String arg0) {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
    //}
    @Then("an error message {string} should be displayed.")
    public void an_error_message_should_be_displayed(String string) throws InterruptedException {
        Thread.sleep(2000);
        String actualMsg = getErrorMessage();
        Thread.sleep(2000);
        String expectedMsg = new String("File type not allowed");
        Assert.assertEquals(actualMsg, "File type not allowed", expectedMsg);

    }
   /* @And("the uploaded image should be displayed on the profile.")
    public void theUploadedImageShouldBeDisplayedOnTheProfile() throws InterruptedException {
        Assert.assertTrue(myInfoPage.isProfileImageDisplayed());
        Thread.sleep(2000);
    }*/
    /*@When("an error message {string} should be displayed.")
    public void an_error_message_should_be_displayed(String string) throws InterruptedException {
        String actual = myInfoPage.getErrorMessage();
        long expected = 0;
        Assert.assertEquals(expected, actual);

        throw new io.cucumber.java.PendingException();
    }*/

}
