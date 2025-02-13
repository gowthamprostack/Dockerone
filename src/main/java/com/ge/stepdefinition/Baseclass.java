package com.ge.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.testng.TestNGCucumberRunner;

import java.sql.Timestamp;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



public class Baseclass {
	private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> new ChromeDriver());
	private static ThreadLocal<String> browser = new ThreadLocal<>();
    private static ThreadLocal<String> url = new ThreadLocal<>();
    
	@Before
    public void intaitedriver() {
		setBrowser(System.getProperty("browser"));
		setUrl(System.getProperty("url"));
	    
    
		
        switch ("chrome") {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver.set(new ChromeDriver(chromeOptions));
                
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver.set(new FirefoxDriver(firefoxOptions));
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver.set(new EdgeDriver(edgeOptions));
                break;

            default:
                throw new IllegalStateException("Unsupported browser: " + browser);
        }

        // Maximize the browser window
        driver.get().manage().window().maximize();
        getDriver().get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @After
    public void tearDown() {
        quitDriver();
    }

    // Singleton method to access WebDriver
    public WebDriver getDriver() {
        return driver.get();
    }

    // Method to clean up and quit the WebDriver for the current thread
    private void quitDriver() {
        WebDriver driverInstance = driver.get();
        if (driverInstance != null) {
            driverInstance.quit();
            driver.remove(); // Removes the WebDriver reference for the current thread
        }
    }
    
   
    	public  String getBrowser() {
            return browser.get();
        }

        
        public  void setBrowser(String browserValue) {
            browser.set(browserValue);
        }

        // Getter method for url ThreadLocal
        public  String getUrl() {
            return url.get();
        }

        // Setter method for url ThreadLocal
        public  void setUrl(String urlValue) {
            url.set(urlValue);
        
    }
        
        @AfterStep
        public void captureExceptionImage(Scenario scenario) {
           
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                String timeMilliseconds = Long.toString(timestamp.getTime());

                byte[] screenshot = ((TakesScreenshot) getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", timeMilliseconds);
            
        }
 
       
 
}
