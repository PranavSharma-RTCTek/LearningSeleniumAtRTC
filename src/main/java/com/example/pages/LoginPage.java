package com.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Public locators for step definitions
    public By usernameInput = By.id("username");
    public By passwordInput = By.id("password");
    public By loginButton = By.id("submit");
    public By errorMessage = By.id("error-message");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Enter username in the username field
     */
    public void enterUsername(String user) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(user);
    }

    /**
     * Enter password in the password field
     */
    public void enterPassword(String pass) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(pass);
    }

    /**
     * Click the login/submit button
     */
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    /**
     * Complete login flow with credentials
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    /**
     * Check if element is visible
     */
    public boolean isVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get error message text
     */
    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Check if error message is visible
     */
    public boolean isErrorMessageVisible() {
        return isVisible(errorMessage);
    }
    
    public void openingForm() {
    	driver.get("https://demoqa.com/");
    	driver.findElement(By.xpath("//*[@ href='forms']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    	driver.findElement(By.xpath("//*[@id='item-0']")).click();
    }
    
    
}