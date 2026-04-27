package com.example.tests;

import com.example.pages.GoogleSearch;
import com.example.pages.methodsToRun;
import com.example.utils.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    
	methodsToRun run = new methodsToRun(driver);
	
    
    public void testGoogleSearch() throws Exception {
        GoogleSearch googleSearch = new GoogleSearch(driver);
        googleSearch.enterSearch("Selenium WebDriver");
      
    }
    
//    @Test
//    public void testQA() throws Exception {
//    	run.getToForm();
//      
//    }
    
    
}