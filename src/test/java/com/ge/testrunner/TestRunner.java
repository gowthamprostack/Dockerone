package com.ge.testrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.ge.stepdefinition.Baseclass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src\\test\\java\\com\\ge\\features"}, 
                 glue = {"com.ge.stepdefinition"}, 
                 plugin = {"pretty", "html:target/jsonReports/cucumber.html", "json:target/jsonReports/cucumber.json"}
                )
public class TestRunner extends AbstractTestNGCucumberTests {

	
	
	

	
}
