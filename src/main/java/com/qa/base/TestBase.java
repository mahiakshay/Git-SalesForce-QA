package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utils.Waits;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	
	public TestBase() throws IOException{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\amahendraka2\\workspace\\SalesForceQA\\src\\main\\java\\com\\qa\\config\\config.properties");
		
		prop.load(fis);
		
	}
	
	public static void initialize(){
		String browName = prop.getProperty("browser");
		
		if (browName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C://firefoxdriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));
		
		driver.manage().timeouts().pageLoadTimeout(Waits.PageLoadTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Waits.ImplicitWait, TimeUnit.SECONDS);
	}
}
