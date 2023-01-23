package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDynamicElementsPage;
import pages.TechGlobalFrontendTestingHomePage;

public class TechGlobalDynamicElementsTest extends TechGlobalBase {


/**
Go to https://techglobal-training.netlify.app/
Click on "Practices" dropdown in the header
Select the "Frontend Testing" option
Click on the "Dynamic Elements" card
Validate both boxes are displayed with below texts
Box 1
Box 2
 */
    @BeforeMethod
    public void setPage(){
        techGlobalDynamicElementsPage = new TechGlobalDynamicElementsPage();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
    }

    @Test(priority = 1, description = "Testing Dynamic Web Elements")
    public void dynamicElementsTest(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(2);

        Assert.assertTrue(techGlobalDynamicElementsPage.box1.isDisplayed());
        Assert.assertEquals(techGlobalDynamicElementsPage.box1.getText(), "Box 1");

        Assert.assertTrue(techGlobalDynamicElementsPage.box2.isDisplayed());
        Assert.assertEquals(techGlobalDynamicElementsPage.box2.getText(), "Box 2");
    }


}
