package stepdefinition;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.SearchPage;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.PropertyReader;

import org.apache.log4j.Logger;

public class SearchSteps {
//jenkins also included
    SearchPage searchPage = new SearchPage();
    Logger log = LoggerHandler.getLogger(SearchSteps.class);

    String[][] searchData;

    @When("User performs product search using excel data")
    public void user_performs_product_search_using_excel() {

        String excelPath = PropertyReader.getProperties()
                .getProperty("ExcelPath");

        String[][] searchData = ExcelReader.getTestData(excelPath, 0);

        for (int i = 0; i < searchData.length; i++) {

            String product = searchData[i][0];
            log.info("Searching product: " + product);

            searchPage.searchProduct(product);

            Assert.assertTrue(
                    searchPage.isSearchResultDisplayed(),
                    "Search result not displayed for: " + product
            );
        }
    }

    @Then("Search results should be displayed for all products")
    public void verify_search_results() {
        log.info("All products searched successfully");
    }
}
