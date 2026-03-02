package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearch {
    private WebDriver driver;

    private By SearchInput = By.xpath("//textarea[@title='Search']");

    public GoogleSearch(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearch(String query) {
        driver.findElement(SearchInput).click();
        driver.findElement(SearchInput).sendKeys(query);
    }
}