package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.TableHandler;
import utilities.TextHandler;

import java.util.List;
import java.util.stream.IntStream;

public class TechGlobalDynamicTablesTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDynamicTablesPage = new TechGlobalDynamicTablesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dynamic Tables");
    }


    /**
    Go to https://techglobal-training.netlify.app/
    `Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Dynamic Tables" card
    Click on the "ADD PRODUCT" button
    Validate the modal` title equals "Add New Product"
     */

    @Test(priority = 1, description = "pop up validation")
    public void popupValidation(){
        techGlobalDynamicTablesPage.addProductButton.click();
        Assert.assertEquals(techGlobalDynamicTablesPage.modalCardTitle.getText(), "Add New Product");
    }


    /**
    DYNAMIC TABLES
    TEST1
    Go to https://techglobal-training.netlify.app/
    Click on “Practices” dropdown in the header
    Select the “Frontend Testing” option
    Click on the “Dynamic Tables” card
    Click the “Add Product” button
    Enter “2” in the Quantity field
    Enter “Apple Watch” in the Product field
    Enter “500” in the Price $ field
    Click the “Submit” button
    Verify that a new row has been added to the table with the values “2”,
     “Apple Watch, “500” and the calculated Total $ value is “1,000"
     Verify that the Total $ value at the bottom of the table has been updated to reflect the total cost
     of all the products in the table, including the newly added one.
     */

    @Test(priority = 2, description = "Validate dynamic table")
    public void validateDynamicTable(){
        // Click the “Add Product” button
        techGlobalDynamicTablesPage.addProductButton.click();

        // get current total amount and parse to int
        int initialTotal = TextHandler.getInt(techGlobalDynamicTablesPage.totalAmount.getText());

        // initial table rows number
        int tableRowSize = TableHandler.getRowCount(techGlobalDynamicTablesPage.table);

        //int tableRowSize = techGlobalDynamicTablesPage.tableRow.size();
        // validate the existing row size
        Assert.assertEquals(techGlobalDynamicTablesPage.tableRow.size(), 3);
        System.out.println(tableRowSize);

        // validate add new product prompt text
        Assert.assertEquals(techGlobalDynamicTablesPage.modalCardTitle.getText(), "Add New Product");

        /// list of products to be added
        String[] products = {"2", "Apple Watch", "500"};

        // multiply quantity of entered product with the product price
        int myProductTotal = TextHandler.getInt(products[0]) * TextHandler.getInt(products[2]);

        // enter all product values
        IntStream.range(0, products.length).forEach(i -> techGlobalDynamicTablesPage.productDetails.get(i).sendKeys(products[i]));

        // click on the submit button
        techGlobalDynamicTablesPage.submitButton.click();

        // validate the new row was added
        Assert.assertEquals(techGlobalDynamicTablesPage.tableRow.size(), tableRowSize + 1);

        // validate the new product total amount
        int productTotalAmount = TextHandler.getInt(TableHandler.getTableRow(driver, 4).get(3).getText());

        // get last table row data
        List<WebElement> tableRow = TableHandler.getTableRow(driver, 4);


        // get value of the last row
        IntStream.range(0, tableRow.size() - 1).forEach(i -> Assert.assertEquals(tableRow.get(i).getText(), products[i]));

        // validate the last row total matches the calculated one
        Assert.assertEquals(productTotalAmount, myProductTotal);

        // get the new final total
        int newTotal = TextHandler.getInt(techGlobalDynamicTablesPage.totalAmount.getText());

        // expected new total amount
        int expectedTotal = initialTotal + myProductTotal;

        // validate the final totals match
        Assert.assertEquals(newTotal, expectedTotal);
    }
}
