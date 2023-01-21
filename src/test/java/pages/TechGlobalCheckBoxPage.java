package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import scripts.TechGlobalBase;
import utilities.Driver;

import java.util.List;

public class TechGlobalCheckBoxPage extends TechGlobalBasePage {
    public TechGlobalCheckBoxPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#checkbox-button-group_1 label")
    public List<WebElement> checkboxLabel;

    @FindBy(css = "#checkbox-button-group_1 input")
    public List<WebElement> checkboxInput;

    @FindBy(css = "#checkbox-button-group_2 label")
    public List<WebElement> checkboxLabel2;

    @FindBy(css = "#checkbox-button-group_2 input")
    public List<WebElement> checkboxInput2;
}
