package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utilities.Driver;

public class TechGlobalBase {
    WebDriver driver;
    TechGlobalBasePage techGlobalBasePage;
    TechGlobalFrontEndTestingHomePage techGlobalFrontEndTestingHomePage;
    TechGlobalDynamicElementsPage techGlobalDynamicElementsPage;
    TechGlobalWaitsPage techGlobalWaitsPage;
    TechGlobalRadioButtonsPage techGlobalRadioButtonsPage;
    TechGlobalCheckBoxPage techGlobalCheckBoxPage;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get("https://techglobal-training.netlify.app/");
        techGlobalBasePage = new TechGlobalBasePage();
    }

    @AfterMethod
    public void teardown() {
        //We will quit driver and do other proper clean ups
        Driver.quitDriver();
    }
}