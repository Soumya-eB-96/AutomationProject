package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base {
	
	Properties prop;
	FileInputStream fs;
	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")// give at cross browser xml page
	public void initializebrowser(String browser) throws Exception {
		
		prop = new Properties();
		fs = new FileInputStream(Constant.CONFIGFILE);
		prop.load(fs);
		
		
		if(browser.equalsIgnoreCase("chrome"))// doesn't check the case
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			throw new Exception("Invalid Browser");
		}
		//driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		WaitUtility wait = new WaitUtility();
		wait.implicitWait(driver);
		
		
	}

	@AfterMethod(alwaysRun=true)// grouping support only while giving the statement
	public void driverQuit(ITestResult iTestResult) throws IOException 
	{
		if (iTestResult.getStatus() == ITestResult.FAILURE) //iTestResult is an interface, manage entire test result lifecycle
		{
			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		//driver.quit();
// Get the screenshot if it failed otherwise quite session
	}
	
}
