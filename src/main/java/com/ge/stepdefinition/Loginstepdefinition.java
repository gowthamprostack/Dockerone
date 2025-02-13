package com.ge.stepdefinition;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Loginstepdefinition {

	Baseclass b=new Baseclass();
	WebDriver driver=b.getDriver();
	
	 public String generateRandomNumber(int length) {
		 
	        return "as";
	    }

	    public String generateRandomString(int length) {
	        return "bs";
	    }

	    @Given("I access the webdriver university contact us page")
	    public void i_access_the_webdriver_university_contact_us_page() {
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    }

	    @When("I enter a unique first name")
	    public void i_enter_a_unique_first_name() {
	    	waitForElementToBeVisible(By.xpath("//input[@name='first_name']"));
	        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }

	    @And("I enter a unique last name")
	    public void i_enter_a_unique_last_name() {
	        driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("AutoLN" + generateRandomNumber(5));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }

	    @And("I enter a unique email address")
	    public void i_enter_a_unique_email_address() {
	    	waitForElementToBeVisible(By.xpath("//input[@name=\"email\"]"));
	        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("AutoEmail" + generateRandomNumber(10) + "@mail.com");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }

	    @And("I enter a unique comment")
	    public void i_enter_a_unique_comment() {
	        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("Hello world " + generateRandomString(20));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }

	    @When("I enter a specific first name {word}")
	    public void i_enter_a_specific_first_name(String firstName) {
	        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }

	    @When("I enter a specific last name {word}")
	    public void i_enter_a_specific_last_name(String lastName) {
	    	waitForElementToBeVisible(By.xpath("//input[@name=\"email\"]"));
	        driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys(lastName);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }

	    @When("I enter a specific email address {word}")
	    public void i_enter_a_specific_email_address(String email) {
	        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    }

	    @When("I enter a specific comment {string}")
	    public void i_enter_a_specific_comment(String comment) {
	    	waitForElementToBeVisible(By.xpath("//input[@name=\"email\"]"));
	        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys(comment);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }

	    @And("I click on the submit button")
	    public void i_click_on_the_submit_button() {
	        driver.findElement(By.xpath("//input[@value=\"SUBMIT\"]")).click();
	    }

	    @Then("I should be presented with a successful contact us submission message")
	    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
	    	waitForElementToBeVisible(By.xpath("//input[@name=\"email\"]"));
	        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	       
	    }

	    public Boolean waitForElementToBeVisible(By locator) {
	    	try
	    	{
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 seconds wait
	        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	    	}
	    	catch (Exception e) {
				return true;
	    		// TODO: handle exception
			}
	    }

}

