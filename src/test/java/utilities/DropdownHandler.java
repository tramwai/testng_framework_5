package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownHandler {

    // create a method that takes a dropdown, dropdown options and optiontText that you want to click

    public static void clickOnDropdownOption(WebElement dropdown, List<WebElement> dropdownOptions, String optionText){
        dropdown.click();

        for (WebElement dropdownOption : dropdownOptions) {
            if (dropdownOption.getText().equals(optionText)){
                dropdownOption.click();
                break;
            }
        }
    }


    // Methods for select dropdown
    // by visible text
    public static void selectByVisibleText(WebElement dropdown, String text){
        new Select(dropdown).selectByVisibleText(text);
    }
        // by index
        public static void selectByIndex(WebElement dropdown, int index){
            new Select(dropdown).selectByIndex(index);
        }

    // by value
    public static void selectByValue(WebElement dropdown, String text){
        new Select(dropdown).selectByValue(text);
    }
}
