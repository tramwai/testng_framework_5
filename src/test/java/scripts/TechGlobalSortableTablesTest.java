package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalSortableTablePage;
import utilities.TableHandler;

import java.util.ArrayList;
import java.util.List;

public class TechGlobalSortableTablesTest extends TechGlobalBase{
    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalSortableTablePage = new TechGlobalSortableTablePage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Sortable Tables");
    }

    /**
    TEST1
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Sortable Tables" card
    Click on the Quantity sort button to toggle Ascending Order
    Verify that the Quantity column of the table is sorted in ascending order
     */
    @Test(priority = 1, description = "Sort table by asc and validate it's sorted by quantity")
    public void validateSortAscByQuantity(){
        // Click on the Quantity sort button to toggle Ascending Order
        techGlobalSortableTablePage.ascByQuantity.click();
        List<WebElement> quantityColumnElements = TableHandler.getTableColumn(driver, 1);
        // empty list
        List<Integer> quantityColumn = new ArrayList<>();

        for (WebElement element : quantityColumnElements) {
            quantityColumn.add(Integer.parseInt(element.getText()));
            }

        for (int i = 1; i < quantityColumn.size(); i++) {
            Assert.assertTrue(quantityColumn.get(i) >= quantityColumn.get(i - 1));
        }
    }

    /**
    TEST2
Go to https://techglobal-training.netlify.app/
Click on "Practices" dropdown in the header
Select the "Frontend Testing" option
Click on the "Sortable Tables" card
Click on the Quantity sort button to toggle descending order
Verify that the Quantity column of the table is sorted in descending order
/*

   /*
TEST3
Go to https://techglobal-training.netlify.app/
Click on "Practices" dropdown in the header
Select the "Frontend Testing" option
Click on the "Sortable Tables" card
Click on the Price sort button to toggle Ascending Order
Verify that the Price column of the table is sorted in ascending order
 */


   /**
TEST4
Go to https://techglobal-training.netlify.app/
Click on "Practices" dropdown in the header
Select the "Frontend Testing" option
Click on the "Sortable Tables" card
Click on the Price sort button to toggle descending order
Verify that the Price column of the table is sorted in descending order
     */

}

