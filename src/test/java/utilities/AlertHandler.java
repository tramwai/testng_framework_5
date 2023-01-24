package utilities;

import org.openqa.selenium.WebDriver;

public class AlertHandler {

    // accept alert method
    public static void acceptAlert(){
        Driver.getDriver().switchTo().alert().accept();
    }

    // dismiss alert method
    public static void dismissAlert(){
        Driver.getDriver().switchTo().alert().dismiss();
    }

    // send keys alert method
    public static void sendKeysToAlert ( String key){
        Driver.getDriver().switchTo().alert().sendKeys(key);
    }

    // send keys alert method
    public static String getAlertText (){
        return Driver.getDriver().switchTo().alert().getText();
    }
}
