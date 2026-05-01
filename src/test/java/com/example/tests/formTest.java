package com.example.tests;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.pages.methodsToRun;
import com.example.utils.BaseTest;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class formTest extends BaseTest {

	private methodsToRun red;

    @BeforeMethod
    public void setUpPageObjects() {
        red = new methodsToRun(driver);
    }
    
    

	String inputFirstName = "Trevor";
	String inputLastName = "Hunter";
	String inputEmailID = "prosperitree@gmail.com";
	String inputPhoneNumber = "1234567890";
	String inputDOB = "27 Apr 2026";
	String inputSubjects = "Math";
	String inputUploadPicture = ("C:\\Users\\pranav.sharma\\Downloads\\Tree.PNG");
	String inputAddress = "707 S. Lindon Ln., Tempe, AZ);";
	
	public byte[] takeScreenshot() {
	    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Test(groups="Form Tests")
	@Description("This test is to fill all the fields")
	@Severity(value = SeverityLevel.CRITICAL)
	@Epic("DemoQA Automation")
	@Feature("Practice Registration Form")
	@Story("Valid Form Submission")
	@Owner("Pranav Sharma")
	@Tag("UI")
	@Tag("Regression")
	@Tag("FormTest")
	@Link(name = "DemoQA Form", url = "https://demoqa.com/automation-practice-form")
	@Attachment(value = "Screenshot", type = "image/png")
	public void automaticFormFilling2() throws Exception {
		//red.getToForm();
		
		//driver.findElement(By.xpath("//*[@ class='text-center']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		System.out.println("Current URL: " + driver.getCurrentUrl());
		 attachScreenshot("Base URL Loaded Successfully");
		//System.out.println("Page title: " + driver.getTitle());
		//System.out.println(driver.getPageSource());
		 try {
			 System.out.println("I am inside try block");
		WebElement firstName = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))
		);

		firstName.sendKeys("Tree");
	}catch(Exception e) {
		 System.out.println("I am inside catch block");
		WebElement firstName = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))
			);

			firstName.sendKeys("Tree");
			System.out.println("Hello I have written the name");
	}
		 System.out.println("Try catch working");
		//red.enterFirstName(inputFirstName);
		red.enterLastName(inputLastName);
		red.enterEmailID(inputEmailID);
		red.selectGender();
		red.enterPhoneNumber(inputPhoneNumber);
		red.enterDOB(inputDOB);
		red.enterSubjects(inputSubjects);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		red.selectHobby_Reading();
		red.selectHobby_Music();
		red.uploadPicture(inputUploadPicture);
		red.enterAddress(inputAddress);
		red.selectState();
		red.selectCity();
		red.submitForm();
		// add assertion here PLEASE FOR THE LOVE OF GOD 
		
		/*
		List<WebElement> numRows = driver.findElements(By.xpath("//div[contains(@class,\'modal-dialog\')]//following::tbody/tr"));
		int size = numRows.size();
		
		
		for (int i = 1; i <= size; i++) {
			String xPath = "((//div[contains(@class,\"modal-dialog\")]//following::tbody/tr)[" + i + "]/child::td)[1]";
			
		}
		*/
		
		Thread.sleep(2000);

		WebElement tableTitle = driver.findElement(By.xpath("//*[@ id='example-modal-sizes-title-lg']"));
		Assert.assertTrue(tableTitle.isDisplayed(), "Submission table is not displayed");

		String actualName = driver.findElement(By.xpath("((//div[contains(@class,'modal-dialog')]//following::tbody/tr)[1]/child::td)[2]")).getText();
		String actualEmail = driver.findElement(By.xpath("((//div[contains(@class,'modal-dialog')]//following::tbody/tr)[2]/child::td)[2]")).getText();
		String actualGender = driver.findElement(By.xpath("((//div[contains(@class,'modal-dialog')]//following::tbody/tr)[3]/child::td)[2]")).getText();
		String actualMobile = driver.findElement(By.xpath("((//div[contains(@class,'modal-dialog')]//following::tbody/tr)[4]/child::td)[2]")).getText();
		String actualDOB = driver.findElement(By.xpath("((//div[contains(@class,'modal-dialog')]//following::tbody/tr)[5]/child::td)[2]")).getText();
		String actualSubjects = driver.findElement(By.xpath("((//div[contains(@class,'modal-dialog')]//following::tbody/tr)[6]/child::td)[2]")).getText();
		String actualAddress = driver.findElement(By.xpath("((//div[contains(@class,'modal-dialog')]//following::tbody/tr)[9]/child::td)[2]")).getText();

		Assert.assertEquals(actualName, inputFirstName + " " + inputLastName, "Name mismatch");
		Assert.assertEquals(actualEmail, inputEmailID, "Email mismatch");
		Assert.assertEquals(actualMobile, inputPhoneNumber, "Mobile mismatch");

		Assert.assertTrue(actualDOB.contains("2026"), "DOB mismatch");

		Assert.assertTrue(actualSubjects.contains(inputSubjects), "Subjects mismatch");
		Assert.assertEquals(actualAddress, inputAddress, "Address mismatch");

		Assert.assertFalse(actualGender.isEmpty(), "Gender not populated");
		
		takeScreenshot();
	}
	
	@AfterMethod
	public void captureFailureScreenshot(ITestResult result) {
	    if (ITestResult.FAILURE == result.getStatus()) {
	        saveScreenshotPNG();
	        System.out.println("Screenshot taken");
	    }
	}

	@Attachment(value = "Failure Screenshot", type = "image/png")
	public byte[] saveScreenshotPNG() {
	    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}

// allure generate --open



