package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;

public class LoginPage {

    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    // ================== LOCATORS ==================

    @FindBy(css = "button[aria-label*='Sign']")
    private WebElement loginButton;

    @FindBy(css = "input[type='email']")
    private WebElement emailInput;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitLoginBtn;

    @FindBy(css = "a[href*='account'], div[class*='account']")
    private WebElement profileIcon;

    @FindBy(css = "p[class*='error'], span[class*='error']")
    private WebElement loginErrorMessage;

    // ================== ACTIONS ==================

    public void clickLoginButton() {
        loginButton.click();
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void submitLogin() {
        submitLoginBtn.click();
    }

    public boolean isLoginSuccessful() {
        return profileIcon.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return loginErrorMessage.isDisplayed();
    }
}
