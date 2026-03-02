package com.example.tests;

import com.example.pages.GoogleSearch;
import com.example.utils.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        GoogleSearch googleSearch = new GoogleSearch(driver);
        googleSearch.enterSearch("Selenium WebDriver");
    }
}