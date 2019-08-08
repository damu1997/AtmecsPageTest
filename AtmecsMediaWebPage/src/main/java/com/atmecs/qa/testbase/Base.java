package com.atmecs.qa.testbase;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import com.atmecs.qa.constants.Constants;
/**
 * This class responsible for browser initialization and termination
 * @author Damodaran.Krishnan
 *
 */
public class Base {
	public static WebDriver driver;
	public Properties properties;
    public void readProperties(String path)
    {
    	properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(path);
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
@BeforeTest
	public void openBrowser() 
	{
    	String path = Constants.PROJECT_BASE_PATH+"/resources/Config.properties";
		readProperties(path);
		String chromepath=Constants.PROJECT_BASE_PATH+properties.getProperty("ChromeDriverPath");
		String firefoxpath=Constants.PROJECT_BASE_PATH+properties.getProperty("FirefoxDriverPath");
		String internetexplorerpath=Constants.PROJECT_BASE_PATH+properties.getProperty("IEDriverPath");
		if (properties.getProperty("browser").equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",chromepath);
			driver = new ChromeDriver();
		} 
		else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",firefoxpath);
			driver = new FirefoxDriver();
		}

		else if (properties.getProperty("browser").equalsIgnoreCase("internetexplorer")) 
		{
			System.setProperty("webdriver.ie.driver",internetexplorerpath);
			driver = new InternetExplorerDriver();
		}
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LODE_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}

//@AfterTest
	public void quitBrowser()  {
    	
    	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS); 
    	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.quit();
	}
}
