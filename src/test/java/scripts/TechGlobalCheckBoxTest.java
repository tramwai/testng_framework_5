package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalCheckBoxPage;
import pages.TechGlobalFrontEndTestingHomePage;

public class TechGlobalCheckBoxTest extends TechGlobalBase {


    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "Checkboxes" card
     * Validate "Apple" and "Microsoft" checkboxes are displayed, enabled and not selected
     * Select both and validate they are both selected
     * Deselect bpth and validate they are deselected
     */

    @BeforeMethod
    public void setPage() {
        techGlobalFrontEndTestingHomePage = new TechGlobalFrontEndTestingHomePage();
        techGlobalCheckBoxPage = new TechGlobalCheckBoxPage();
    }

    // Validate "Apple" and "Microsoft" checkboxes are displayed, enabled and not selected
    @Test(priority = 1, description = "Validate checkboxes")
    public void validateCheckboxes() {
        techGlobalFrontEndTestingHomePage.getFrontendTestingPage();
        techGlobalFrontEndTestingHomePage.clickOnCard(6);

        techGlobalCheckBoxPage.checkboxInput.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertFalse(cb.isSelected());
            Assert.assertTrue(cb.isEnabled());
        });

        for (int i = 0; i < techGlobalCheckBoxPage.checkboxInput.size(); i++) {
            techGlobalCheckBoxPage.checkboxLabel.get(i).click();
            Assert.assertTrue(techGlobalCheckBoxPage.checkboxInput.get(i).isSelected());
        }

        for (int i = 0; i < techGlobalCheckBoxPage.checkboxInput.size(); i++) {
            techGlobalCheckBoxPage.checkboxLabel.get(i).click();
            Assert.assertFalse(techGlobalCheckBoxPage.checkboxInput.get(i).isSelected());
        }

    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "Checkboxes" card
     * Validate "Tesla" and "SpaceX" checkboxes are displayed, enabled and not selected
     * Select both and validate they are both selected
     * Deselect both and validate they are deselected
     */

    @Test(priority = 2, description = "Validate checkboxes of second group")
    public void validateCheckboxes2() {
        techGlobalFrontEndTestingHomePage.getFrontendTestingPage();
        techGlobalFrontEndTestingHomePage.clickOnCard(6);

        techGlobalCheckBoxPage.checkboxInput2.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertTrue(cb.isEnabled());
            Assert.assertFalse(cb.isSelected());
        });

        for (int i = 0; i < techGlobalCheckBoxPage.checkboxInput2.size(); i++) {
            techGlobalCheckBoxPage.checkboxLabel2.get(i).click();
            Assert.assertTrue(techGlobalCheckBoxPage.checkboxInput2.get(i).isSelected());
        }

        for (int i = 0; i < techGlobalCheckBoxPage.checkboxInput2.size(); i++) {
            techGlobalCheckBoxPage.checkboxLabel2.get(i).click();
            Assert.assertFalse(techGlobalCheckBoxPage.checkboxInput2.get(i).isSelected());
        }


    }
}
