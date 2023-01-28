package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalStaticTablesPage;
import utilities.TableData;
import utilities.Waiter;

import java.util.List;
import java.util.stream.IntStream;

public class TechGlobalStaticTablesTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalStaticTablesPage = new TechGlobalStaticTablesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Static Tables");
    }

    /**
    TEST 1
        Verify the headers of the table
        Go to https://techglobal-training.netlify.app/
        Click on “Practices” dropdown in the header
        Select the “Frontend Testing” option
        Click on the “Static Tables” card
        Check that the headers of the table are “Rank”, “Company”, “Employees”, and “Country”
        Verify the rows of the table
     */

    @Test(priority = 1, description = "Validate static tables")
    public void validateStaticTables(){
        String[] headers = {"Rank", "Company", "Employees", "Country"};
//        for (int i = 0; i < headers.length; i++) {
//            Assert.assertEquals(techGlobalStaticTablesPage.tableHeader.get(i).getText(), headers[i]);
//        }
        // lambda expression solution
        IntStream.range(0, headers.length).forEach(i -> {
            System.out.println(techGlobalStaticTablesPage.tableHeader.get(i).getText());
            Assert.assertEquals(techGlobalStaticTablesPage.tableHeader.get(i).getText(), headers[i]);
        });
    }


    /**
    Go to https://techglobal-training.netlify.app/
    Click on “Practices” dropdown in the header
    Select the “Frontend Testing” option
    Click on the “Static Tables” card
    Check that first row of the table has the values “1", “Amazon”, “1,523,000", and “USA”
    Verify the columns of the table
     */
    @Test(priority = 2,description = "validate first row of the table")
    public void validateRow(){
        String[] rowData = {"1", "Amazon", "1,523,000", "USA"};
        List<WebElement> tableRow = TableData.getTableRow(driver, 1);

        for (int i = 0; i < tableRow.size(); i++) {
            Assert.assertEquals(tableRow.get(i).getText(), rowData[i]);
        }
    }

    /**
    TEST 3
        Go to https://techglobal-training.netlify.app/
        Click on “Practices” dropdown in the header
        Select the “Frontend Testing” option
        Click on the “Static Tables” card
        Check that the “Country” column of the table has the values “USA”, “China”, “USA”, “USA”, “S. Korea”
        Verify the entire table
     */
    @Test(priority = 3, description = "validate country column")
    public void validateCountryColumn(){
        String[] columnData = {"USA", "China", "USA", "USA", "S. Korea"};
        List<WebElement> tableColumn = TableData.getTableColumn(driver, 4);
//        for (int i = 0; i < tableColumn.size(); i++) {
//            Assert.assertEquals(tableColumn.get(i).getText(), columnData[i]);
//        }

        IntStream.range(0, columnData.length).forEach(i -> {
            System.out.println(tableColumn.get(i).getText());
            Assert.assertEquals(tableColumn.get(i).getText(), columnData[i]);
        });
    }
}
