package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontEndTestingHomePage;
import utilities.Waiter;

public class TechGlobalFrontEndTestingHomeTest extends TechGlobalBase {

    /**
     * TEST TASK
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown
     * Click on "Frontend Testing" option
     * Validate below cards are dsiplayed and their text is as below
     * <p>
     * Locators
     * Xpath-CSS Locators
     * Dynamic Elements
     * Waits
     * Dropdowns
     * Radio Buttons
     * Checkboxes
     * Alerts
     * IFrames
     * Multiple Windows
     * Static Tables
     * Dynamic Tables
     * File Upload
     * File Download
     * Actions
     * Login Form
     * Forgot Password
     * Sortable Tables
     * Pagination
     * Calendar
     */

    @BeforeMethod
    public void setPage() {
        techGlobalFrontEndTestingHomePage = new TechGlobalFrontEndTestingHomePage();
    }

    @Test(priority = 1, description = "Validate Frontend testing cards")
    public void validateFrontEndTestingCards() {
       techGlobalFrontEndTestingHomePage.getFrontendTestingPage();

        String[] cardTexts = {"Locators",
                "Xpath-CSS Locators",
                "Dynamic Elements",
                "Waits",
                "Dropdowns",
                "Radio Buttons",
                "Checkboxes",
                "Alerts",
                "IFrames",
                "Multiple Windows",
                "Static Tables",
                "Dynamic Tables",
                "File Upload",
                "File Download",
                "Actions",
                "Login Form",
                "Forgot Password",
                "Sortable Tables",
                "Pagination",
                "Calendar"};

        for (int i = 0; i < 20; i++) {
            Assert.assertTrue(techGlobalFrontEndTestingHomePage.cards.get(i).isDisplayed());
            Assert.assertEquals(techGlobalFrontEndTestingHomePage.cards.get(i).getText(), cardTexts[i]);
        }
    }


    /**
     Go to https://techglobal-training.netlify.app/
     Click on "Practices" dropdown
     Click on "Frontend Testing" option
     Validate the url contains "frontend"
     */
    @Test(priority = 2, description = "Validate URL")
    public void validateFrontendTestingURL() {
        techGlobalFrontEndTestingHomePage.getFrontendTestingPage();
       Assert.assertTrue(driver.getCurrentUrl().contains("frontend"));

    }

}

