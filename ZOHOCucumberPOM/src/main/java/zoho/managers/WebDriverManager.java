package zoho.managers;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WebDriverManager {
	
	
	WebDriver driver;
	ExtentTest test;
	Properties prop;
	
	public WebDriverManager() {
		// init the properties file
		try {
			prop=new Properties();
			System.out.println(System.getProperty("user.dir"));
			String path = System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
   	public void openBrowser(String browser) {
        log("Open browser "+ browser);
        
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		if(browser.equals("Mozilla")) {
			driver  = new FirefoxDriver();
		}else if(browser.equals("Chrome")) {
			driver  = new ChromeDriver();
		}else if(browser.equals("Edge")) {
			driver  = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void navigate(String urlKey) {
		log("Navigating to "+getProperty(urlKey) );
		driver.get(getProperty(urlKey));
	}
	
	public void click(String locatorKey) {// assuming that locator is xpath
		log("Clicking on "+locatorKey );
		findElement(locatorKey).click();
	}
	
	public void type(String locatorKey, String data) {
		log("Typing in "+locatorKey );
		findElement(locatorKey).sendKeys(data);
	}
	
	
	public WebElement findElement(String locatorKey) {
		By locator = getLocator(locatorKey);
		WebElement e = null;
		try {
		  // present and visible
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		  e = driver.findElement(locator);
		}catch(Exception ex) {
			// report failure
			logFailure("Object not found "+ locatorKey);
		}
		return e;
	}
	
	public By getLocator(String locatorKey) {
		
		if(locatorKey.endsWith("_id"))
			return By.id(getProperty(locatorKey)); // By.id("login_id")
		else if(locatorKey.endsWith("_name"))
			return By.name(getProperty(locatorKey));
		else if(locatorKey.endsWith("_xp"))
			return By.xpath(getProperty(locatorKey));
		else 
			return By.cssSelector(getProperty(locatorKey));
	}
	
	/********************Validation Functions***************************/
	public boolean verifyTitle(String expectedTitleKey) {
		String expectedTitle = getProperty(expectedTitleKey);
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle))
			return true;
		else
			return false;
	}
	
	
	
	/*************Utility Functions******************/
	
	public void init(ExtentTest test) {
    	this.test=test;
    }
    
    public String getProperty(String key) {
    	return prop.getProperty(key);
    }
    
    public void log(String msg) {
		System.out.println(msg);
		test.log(Status.INFO, msg);
	}
    
    public void logFailure(String msg) {
    	System.out.println("FAILURE---- "+ msg);
    	// screenshot of the page and embedd in reports
    	// fail in extent reports
    	test.log(Status.FAIL, msg);
    	// fail in testng-cucumber
    	Assert.fail(msg);// hard assertion
    }
	

	
	
	
	
	
	
	
	
	
	

}
