package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TechGlobalLogoTest extends TechGlobalBase{

    @Test
    public void validateTechGlobalLogo() {

        //Assert.fail("Failing on purpose because there is a bug created for this");
        Assert.assertTrue(techGlobalBasePage.logo.isDisplayed());
    }

}