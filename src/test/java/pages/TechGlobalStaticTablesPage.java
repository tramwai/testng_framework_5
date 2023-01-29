package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class TechGlobalStaticTablesPage extends TechGlobalBasePage{
    public TechGlobalStaticTablesPage(){
        super();
    }

    @FindBy(css = ".header")
    public List<WebElement> tableHeader;

    @FindBy(css = "tbody td:nth-child(1)")
    public List<WebElement> tableColumn;

    // method to get table data
    public List<List<WebElement>> getTableData(){
        // empty list
        List<List<WebElement>> tableData = new ArrayList<>();
        // loop to get the data from each row cell
        for (int i = 1; i <= tableColumn.size(); i++) {
            tableData.add(Driver.getDriver().findElements(By.cssSelector("tbody>tr:nth-child(" + i + ") td")));
        }
        return tableData;
    }

}
