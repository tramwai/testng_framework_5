package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class TechGlobalLogoTest extends TechGlobalBase{

    @Test
    public void validateTechGlobalLogo() {

        //Waiter.waitForVisibilityOfElement(techGlobalBasePage.logo, 30);  // if you have a logo failure use
        //Assert.fail("Failing on purpose because there is a bug created for this");
        Assert.assertTrue(techGlobalBasePage.logo.isDisplayed());
    }

}