package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException {
		//super();
		
		PageFactory.initElements(driver, this); //If not initialized, we get null pointer exceptions
		// TODO Auto-generated constructor stub
		
	}
	
	//Page Factor or Object Repository
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(name="Login")
	WebElement loginBtn;
	
	@FindBy(id="logo")
	WebElement sflogo;
	
	//Actions or Method
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean sfLogoValidate(){
		return sflogo.isDisplayed();
	}
	
	public void login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	
	
	
	

}
