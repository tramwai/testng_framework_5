package scripts;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalAlertsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.AlertHandler;


public class TechGlobalAlertsTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalAlertsPage = new TechGlobalAlertsPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Alerts");
    }

    /**
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Alerts" card
    Click on "Warning alert" button
    Validate the alert text equals "You are on TechGlobal Training application."
    Click on "OK" button on the alert
    Validate the result message equals "You accepted warning by clicking OK."
     */

    @Test(priority = 1, description = "Validate warning alert")
    public void warningAlert(){
        // Click on "Warning alert" button
        techGlobalAlertsPage.clickOnAlert("Warning alert");

        // switch to alert page
        Alert alert = driver.switchTo().alert();

        // validate the alert text
        Assert.assertEquals(alert.getText(),"You are on TechGlobal Training application.");

        // confirming the alert button
        alert.accept();

        // validate the result test
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You accepted warning by clicking OK.");

    }


    /**
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Alerts" card
    Click on "Confirmation alert" button
    Validate the alert text equals "Would you like to stay on TechGlobal Training application?"
    Click on "Cancel" button on the alert
    Validate the result message equals "You rejected the alert by clicking Cancel."
    Click on "Confirmation alert" button again
    Click on "OK" button on the alert
    Validate the result message equals "You confirmed the alert by clicking OK."
     */

    @Test(priority = 2, description = "Validate Confirmation alert")
    public void confirmationAlert(){

        // Click on "Confirmation alert" button
        techGlobalAlertsPage.clickOnAlert("Confirmation alert");

        // Validate the alert text equals "Would you like to stay on TechGlobal Training application?"
        // create an alert object

        Assert.assertEquals(AlertHandler.getAlertText(),"Would you like to stay on TechGlobal Training application?");

        // Click on "Cancel" button on the alert
        AlertHandler.dismissAlert();

        // Validate the result message equals "You rejected the alert by clicking Cancel."
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You rejected the alert by clicking Cancel.");

        // Click on "Confirmation alert" button again
        techGlobalAlertsPage.clickOnAlert("Confirmation alert");

        // Click on "OK" button on the alert
       AlertHandler.acceptAlert();

        // Validate the result message equals "You confirmed the alert by clicking OK."
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You confirmed the alert by clicking OK.");

    }

    /**
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Alerts" card
    Click on "Prompt alert" button
    Validate the alert text equals "What would you like to say to TechGlobal?"
    Click on "Cancel" button on the alert
    Validate the result message equals "You rejected the alert by clicking Cancel."
    Click on "Prompt alert" button again
    Click on "OK" button on the alert
    Validate the result message equals "You entered "" in the alert and clicked OK."
    Click on "Prompt alert" button again
    Enter "Hello" to alert input box
    Click on "OK" button on the alert
    Validate the result message equals "You entered "Hello" in the alert and clicked OK."
     */

    @Test(priority = 3, description = "validate Prompt alert")
    public void promptAlert(){
        // Click on "Prompt alert" button
        techGlobalAlertsPage.clickOnAlert("Prompt alert");

        // Validate the alert text equals "What would you like to say to TechGlobal?"
        Assert.assertEquals(AlertHandler.getAlertText(), "What would you like to say to TechGlobal?");

        // Click on "Cancel" button on the alert
        AlertHandler.dismissAlert();

        // Validate the result message equals "You rejected the alert by clicking Cancel."
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You rejected the alert by clicking Cancel.");

        // Click on "Prompt alert" button again
        techGlobalAlertsPage.clickOnAlert("Prompt alert");

        // Click on "OK" button on the alert
        AlertHandler.acceptAlert();

        // Validate the result message equals "You entered "" in the alert and clicked OK."
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You entered \"\" in the alert and clicked OK.");

        // Click on "Prompt alert" button again
        techGlobalAlertsPage.clickOnAlert("Prompt alert");

        // Enter "Hello" to alert input box
        AlertHandler.sendKeysToAlert("Hello");

        // Click on "OK" button on the alert
        AlertHandler.acceptAlert();

        // Validate the result message equals "You entered "Hello" in the alert and clicked OK."
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You entered \"Hello\" in the alert and clicked OK.");

    }






}
