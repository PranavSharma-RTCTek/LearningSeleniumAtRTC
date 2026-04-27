package com.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class methodsToRun {
	private WebDriver driver;

    // Public locators for step definitions
    public By formButton = By.xpath("//*[@ href='/forms']");
    public By practiceFormButton = By.xpath("//*[@ class='element-list accordion-collapse collapse show']");
    public By firstName = By.xpath("//*[@ id='firstName']");
    public By lastName = By.xpath("//*[@ id='lastName']");
    public By emailID = By.xpath("//*[@ id='userEmail']");
    public By maleGender = By.xpath("//*[@ id='gender-radio-1']");
    public By phoneNumber = By.xpath("//*[@ id='userNumber']");
    public By dateOfBirth = By.xpath("//*[@ id='dateOfBirthInput']");
    public By subjects = By.xpath("//*[@ id='subjectsInput']");
    public By hobbySports = By.xpath("//*[@ id='hobbies-checkbox-1']");
    public By hobbyRead = By.xpath("//*[@ id='hobbies-checkbox-2']");
    public By hobbyMusic = By.xpath("//*[@ id='hobbies-checkbox-3']");
    public By picture = By.xpath("//*[@ id='uploadPicture']");
    public By address = By.xpath("//*[@ id='currentAddress']");
    public By stateSelect = By.xpath("//*[@ class='col-md-4 col-sm-12']");
    public By citySelect = By.xpath("//*[@ id = 'city']");
    public By submitButton = By.xpath("//*[@ id='submit']");

    public methodsToRun(WebDriver driver) {
        this.driver = driver;
    }
    
    public void getToForm() throws Exception{
    	driver.findElement(formButton).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(900));
    	driver.findElement(practiceFormButton).click();
    }
    
    public void enterFirstName(String fName) throws Exception{
    	driver.findElement(firstName).click();
    	driver.findElement(firstName).sendKeys(fName);
    }
    
    public void enterLastName(String lName) throws Exception{
    	driver.findElement(lastName).click();
    	driver.findElement(lastName).sendKeys(lName);
    }
    
    public void enterEmailID(String eID) throws Exception{
    	driver.findElement(emailID).click();
    	driver.findElement(emailID).sendKeys(eID);
    }
    
    public void selectGender() throws Exception{
    	driver.findElement(maleGender).click();
    }
    
    public void enterPhoneNumber(String phNo) throws Exception{
    	driver.findElement(phoneNumber).click();
    	driver.findElement(phoneNumber).sendKeys(phNo);
    }
    
    public void enterDOB(String DOB) throws Exception{
    	driver.findElement(dateOfBirth).click();
    	driver.findElement(dateOfBirth).sendKeys(DOB);
    }
    
    public void enterSubjects(String subjectsList) throws Exception{
    	driver.findElement(subjects).click();
    	driver.findElement(subjects).sendKeys(subjectsList);
    	driver.findElement(By.xpath("//*[text()='Maths']")).click();
    }
    
    public void selectHobby_Sports() throws Exception{
    	driver.findElement(hobbySports).click();
    }
    
    public void selectHobby_Reading() throws Exception{
    	driver.findElement(hobbyRead).click();
    }
    
    public void selectHobby_Music() throws Exception{
    	driver.findElement(hobbyMusic).click();
    }
    
    public void uploadPicture(String filePath) {
        WebElement upload =
            driver.findElement(By.id("uploadPicture")); // input[type=file]
        upload.sendKeys(filePath);
    }
    
    public void enterAddress(String addy) throws Exception{
    	driver.findElement(address).click();
    	driver.findElement(address).sendKeys(addy);
    }
    
    public void selectState() throws Exception{
    	driver.findElement(stateSelect).click();
    	driver.findElement(By.xpath("//*[text()='NCR']")).click();
    }
    
    public void selectCity() throws Exception{
    	driver.findElement(citySelect).click();
    	driver.findElement(By.xpath("//*[text()='Noida']")).click();
    }
    
    public void submitForm() throws Exception{
    	driver.findElement(submitButton).click();
    }
}
