package scripts;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontEndTestingHomePage;
import pages.TechGlobalWaitsPage;
import utilities.Driver;
import utilities.Waiter;

public class TechGlobalWaitsPageTest extends TechGlobalBase{

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "Waits" card
     * Click on "Click on me to see a red box" button
     * Validate a red box is displayed
     */

    @BeforeMethod
    public void setPage(){
        techGlobalFrontEndTestingHomePage = new TechGlobalFrontEndTestingHomePage();
        techGlobalWaitsPage = new TechGlobalWaitsPage();
    }


    @Test(priority = 1, description = "Validate red box is visible")
    public void validateRedBox(){
        techGlobalFrontEndTestingHomePage.getFrontendTestingPage();
        techGlobalFrontEndTestingHomePage.clickOnCard(3);

//        techGlobalWaitsPage.redBoxButton.click();
        techGlobalWaitsPage.blueBoxButton.click();
//        Assert.assertTrue(techGlobalWaitsPage.redBox.isDisplayed());
        Waiter.waitForVisibilityOfElement(techGlobalWaitsPage.blueBox, 60);
        Assert.assertTrue(techGlobalWaitsPage.blueBox.isDisplayed());



    }
}