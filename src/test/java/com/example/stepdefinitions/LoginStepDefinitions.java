package com.example.stepdefinitions;

import com.example.pages.LoginPage;
import com.example.utils.BrowserFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = BrowserFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        BrowserFactory.quitDriver();
    }

    // Background Steps
    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        driver.get("https://example.com/login");
        // Wait for page to load
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Verify login page is displayed
        Assert.assertTrue(loginPage.isVisible(loginPage.usernameInput), 
                "Username field not visible - login page not loaded");
    }

    // Login Steps
    @When("the user enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("the user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
        try {
            Thread.sleep(2000); // Wait for login result
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Then Steps
    @Then("the user should be successfully logged in")
    public void userSuccessfullyLoggedIn() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("login"), 
                "User is still on login page after login attempt");
    }

    @Then("an error message should be displayed")
    public void errorMessageDisplayed() {
        boolean isErrorVisible = loginPage.isErrorMessageVisible();
        Assert.assertTrue(isErrorVisible, 
                "Error message is not displayed for invalid credentials");
    }

    @Then("the username input field should be visible")
    public void usernameFieldVisible() {
        Assert.assertTrue(loginPage.isVisible(loginPage.usernameInput), 
                "Username field is not visible");
    }

    @Then("the password input field should be visible")
    public void passwordFieldVisible() {
        Assert.assertTrue(loginPage.isVisible(loginPage.passwordInput), 
                "Password field is not visible");
    }

    @Then("the login button should be visible")
    public void loginButtonVisible() {
        Assert.assertTrue(loginPage.isVisible(loginPage.loginButton), 
                "Login button is not visible");
    }

    @Then("the login result should be {string}")
    public void loginResultShouldBe(String expectedResult) {
        boolean isErrorVisible = loginPage.isErrorMessageVisible();
        
        if ("success".equalsIgnoreCase(expectedResult)) {
            Assert.assertFalse(isErrorVisible, 
                    "Expected successful login but error message was displayed");
        } else if ("failure".equalsIgnoreCase(expectedResult)) {
            Assert.assertTrue(isErrorVisible, 
                    "Expected login failure but no error message was displayed");
        }
    }
}
