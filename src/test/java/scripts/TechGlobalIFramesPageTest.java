package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalIFramesPage;

import java.util.stream.IntStream;

public class TechGlobalIFramesPageTest extends TechGlobalBase {
    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalIFramesPage = new TechGlobalIFramesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("IFrames");
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “IFrames” card
     * Validate the “Please fill out your information below” text
     */

    @Test(priority = 1, description = "Validate input header text")
    public void validateInputText() {
        driver.switchTo().frame(techGlobalIFramesPage.iFrameId);
        Assert.assertTrue(techGlobalIFramesPage.inputHeader.isDisplayed());
        Assert.assertEquals(techGlobalIFramesPage.inputHeader.getText(), "Please fill out your information below");
    }


    /**
     * TEST 2
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “IFrames” card
     * Enter “John” to first name input box
     * Enter “Doe” to last name input box
     * Click on “SUBMIT” button
     * Validate the result equals “You entered: John Doe”
     */

    @Test(priority = 2, description = "validateFirstNameLastNameInputBox")
    public void validateFirstNameLastNameInputBox() {
        // go to iFrame
        driver.switchTo().frame(techGlobalIFramesPage.iFrameId);
        // store the credentials
        String[] credentials = {"John", "Doe"};
        // Enter “John” to first name input box
        // Enter “Doe” to last name input box
//            for (int i = 0; i < credentials.length; i++) {
//                techGlobalIFramesPage.inputFields.get(i).sendKeys(credentials[i]);
//            }
        IntStream.range(0, credentials.length).forEach(index -> techGlobalIFramesPage.inputFields.get(index).sendKeys(credentials[index]));
        techGlobalIFramesPage.submitButton.click();
        //  go back to parent frame
        driver.switchTo().parentFrame();
        // Validate the result equals “You entered: John Doe”
        Assert.assertEquals(techGlobalIFramesPage.resultText.getText(), "You entered: " + credentials[0] + " " + credentials[1]);
    }
}




