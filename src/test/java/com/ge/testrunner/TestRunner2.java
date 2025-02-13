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
                 plugin = {"pretty", "html:target/jsonReports/cucumberone.html", "json:target/jsonReports/cucumberone.json"},
                 tags = "@firefox")
public class TestRunner2 extends AbstractTestNGCucumberTests {

Baseclass b=new Baseclass();


@DataProvider
public Object[][] scenario()
{
	return this.scenarios();
}
   
	@BeforeTest
	@Parameters({"browser","url"})
	public void data(String browser,String url)
	{
		//System.setProperty("browser",browser);
		//System.setProperty("url",url);
		
      b.setBrowser(browser);
      b.setUrl(url);
	}
	
}
