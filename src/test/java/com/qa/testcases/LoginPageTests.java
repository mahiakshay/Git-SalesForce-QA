package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;



public class LoginPageTests extends TestBase {
	
	LoginPage loginpage; // object to access LoginPageTests class
	
	public LoginPageTests() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException{
		initialize();
		loginpage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void validateLoginPageTitleTest(){
		String title = loginpage.validateLoginPageTitle();	
		Assert.assertEquals(title, "Login | Salesforce", "Title not Correct");
		System.out.println("Title of the page:" + title);
		}
	
	@Test (priority = 2)
	public void sfLogoTest(){
		boolean flag=loginpage.sfLogoValidate();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest(){
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		//Thread.sleep(5000);
		
		driver.quit();
		
	}

}
