package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverManager;

import java.time.Duration;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public SearchPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Search for')]")
    private WebElement searchBox;

    @FindBy(xpath = "//div[contains(@class,'text-center') and contains(text(),'results for')]")
    private WebElement searchResults;

    public void searchProduct(String productName) {

        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.click();
//        searchBox.sendKeys(Keys.CONTROL, "a");
//        searchBox.sendKeys(Keys.DELETE);
//        searchBox.sendKeys(productName);
//        searchBox.sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(productName).sendKeys(Keys.ENTER).perform();


        // wait for results to load
        wait.until(ExpectedConditions.visibilityOf(searchResults));
    }

    public boolean isSearchResultDisplayed() {
        return searchResults.isDisplayed();
    }
}
