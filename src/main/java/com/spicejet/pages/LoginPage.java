package com.spicejet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spicejet.base.TestBase;

public class LoginPage extends TestBase{

	//Page factory
	@FindBy(name="ControlGroupLoginView$MemberLoginView2LoginView$TextBoxUserID")
	WebElement username;
	
	@FindBy(name="ControlGroupLoginView$MemberLoginView2LoginView$PasswordFieldPassword")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy (xpath="//a[@class='signup-link buttonN']")
	WebElement signUpBtn;
	
	@FindBy (xpath="//a[@class='spicejet_logo']")
	WebElement spicejectLogo;

	public LoginPage(){
	PageFactory.initElements(driver,this);	
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateSpicejectLogo(){
		return spicejectLogo.isDisplayed();
	}
	
	public HomePage Login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	}
