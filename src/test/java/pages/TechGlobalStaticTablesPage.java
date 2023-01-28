package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.WeakHashMap;

public class TechGlobalStaticTablesPage extends TechGlobalBasePage{
    public TechGlobalStaticTablesPage(){
        super();
    }

    @FindBy(css = ".header")
    public List<WebElement> tableHeader;

}
