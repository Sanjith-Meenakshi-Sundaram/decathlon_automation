package stepdefinition;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.LoggerHandler;
import utils.PropertyReader;

import org.apache.log4j.Logger;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    Logger log = LoggerHandler.getLogger(LoginSteps.class);

    @Given("User is on Decathlon home page")
    public void user_is_on_home_page() {
        log.info("User is on Decathlon home page");
        // URL already launched from Hooks -> DriverFactory
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        log.info("Clicking login button");
        loginPage.clickLoginButton();
    }

    @When("User enters valid username and password")
    public void user_enters_valid_credentials() {

        String username = PropertyReader.getProperties()
                .getProperty("valid.username");
        String password = PropertyReader.getProperties()
                .getProperty("valid.password");

        log.info("Entering valid credentials");
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_credentials() {

        log.info("Entering invalid credentials");
        loginPage.clickLoginButton();
        loginPage.enterEmail("wronguser@test.com");
        loginPage.enterPassword("wrongpassword");
    }

    @When("User clicks on submit login")
    public void user_clicks_submit_login() {
        log.info("Submitting login form");
        loginPage.submitLogin();
    }

    @Then("User should be logged in successfully")
    public void verify_successful_login() {
        log.info("Verifying successful login");
        Assert.assertTrue(loginPage.isLoginSuccessful(),
                "Login was not successful");
    }

    @Then("User should see login error message")
    public void verify_login_error() {
        log.info("Verifying login error message");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message not displayed");
    }
}
